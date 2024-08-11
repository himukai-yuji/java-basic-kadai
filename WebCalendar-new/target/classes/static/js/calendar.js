/**
 * 
 */
const weeks = ['日', '月', '火', '水', '木', '金', '土']
const date = new Date()
let year = date.getFullYear()
let month = date.getMonth() + 1
let dbList = [];

// 日付型フォーマット変換関数(引数→yyyy/mm/dd形式に変換)
// 引数が"yyyy-mm-dd"形式の文字列型であることが前提
// ※本当はもっと汎用的に作成しても良いが一旦はこれで
function formatDate(date, sep="/") {
	date = date.replace(/-/g,"");
	let yyyy = date.substr(0,4);
	let mm = date.substr(4,2);
	let dd = date.substr(6,2);
	
	//書式を合わせるため0埋めを削除
	if(mm.slice(0,1) == '0'){
		mm = mm.slice(-1);
	}
	if(dd.slice(0,1) == '0'){
		dd = dd.slice(-1);
	}

  return `${yyyy}${sep}${mm}${sep}${dd}`;
}


function showCalendar(year, month) {
	const calendarHtml = createCalendar(year, month)
	const sec = document.createElement('section')
	sec.innerHTML = calendarHtml
	document.querySelector('#calendar').appendChild(sec)
	
	month++
	if (month > 12) {
	year++
	month = 1
        }
    addtable()
}

function createCalendar(year, month) {
    const startDate = new Date(year, month - 1, 1) // 月の最初の日を取得
    const endDate = new Date(year, month,  0) // 月の最後の日を取得
    const endDayCount = endDate.getDate() // 月の末日
    const lastMonthEndDate = new Date(year, month - 2, 0) // 前月の最後の日の情報
    const lastMonthEndDayCount = lastMonthEndDate.getDate() // 前月の末日
    const startDay = startDate.getDay() // 月の最初の日の曜日を取得
    let dayCount = 1 // 日にちのカウント
    let calendarHtml = '' // HTMLを組み立てる変数

    calendarHtml += '<h1>' + year  + '年' + month +'月'+ '</h1>'
    calendarHtml += '<table>'

    // 曜日の行を作成
    for (let i = 0; i < weeks.length; i++) {
        calendarHtml += '<td>' + weeks[i] + '</td>'
    }

    for (let w = 0; w < 5; w++) {
        calendarHtml += '<tr>'

        for (let d = 0; d < 7; d++) {
            if (w == 0 && d < startDay) {
                // 1行目で1日の曜日の前
                let num = lastMonthEndDayCount - startDay + d + 1
                calendarHtml += '<td class="is-disabled">' + num + '</td>'
            } else if (dayCount > endDayCount) {
                // 末尾の日数を超えた
                let num = dayCount - endDayCount
                calendarHtml += '<td class="is-disabled">' + num + '</td>'
                dayCount++
            } else {
                calendarHtml += `<td class="calendar_td" data-date="${year}/${month}/${dayCount}">${dayCount}</td>`
                dayCount++
            }
        }
        calendarHtml += '</tr>'
    }
    calendarHtml += '</table>'

    return calendarHtml
}
//メモ機能追加部分
function addtable(){

    // ToDOリストと自由記入欄のtableを作成
    let toDo = 'ToDo';
    let memo = 'メモ';
	let calendarHTML="";
	let toDoTextNum = 0;
	let memoTextNum = 0;
	let todoID = "todo";
	let memoID = "memo";
    calendarHTML += '<tr class="mytr"><th class="myth">'+toDo+'</th><th class="myth">'+ memo +'</th></tr>'
	calendarHTML += '<tr class="mytr"><td class="todo"><textarea></textarea>'+'</td><td class="memo"><textarea></textarea></td></tr>'

    // 各日にちにtableを挿入
    let elms = document.querySelectorAll('.calendar_td');
    let tableElm = document.createElement('table');
    tableElm.id='mytable';
    tableElm.innerHTML = calendarHTML;
    elms.forEach(elm => {
        tableElm = tableElm.cloneNode(true);
        elm.appendChild(tableElm);
    })
    //textareaにidを付与
    elms = document.querySelectorAll('.todo');
    elms.forEach(elm => {
		toDoTextNum += 1;
		elm.setAttribute("id",todoID+toDoTextNum)
		})
	elms = document.querySelectorAll('.memo');
    elms.forEach(elm => {
		memoTextNum += 1;
		elm.setAttribute("id",memoID+memoTextNum)
		})
    //DBから取得した値を設定
    toDoTextNum = 1;
	memoTextNum = 1;
    elms = document.querySelectorAll('.calendar_td');
    elms.forEach(elm => {
	    const date = elm.getAttribute('data-date');
		const event = dbList.find(e => formatDate(e.date) === date);
	    if (event) {
	        document.getElementById(todoID+toDoTextNum).textContent = event.todo;
	        document.getElementById(memoID+memoTextNum).textContent = event.memo;
	    }
	    toDoTextNum += 1;
	    memoTextNum += 1;
    })
    

}


function moveCalendar(e) {
    document.querySelector('#calendar').innerHTML = ''

    if (e.target.id === 'prev') {
        month--

        if (month < 1) {
            year--
            month = 12
        }
    }

    if (e.target.id === 'next') {
        month++

        if (month > 12) {
            year++
            month = 1
        }
    }

    showCalendar(year, month)
}

function fetchEvents() {
    fetch('/api/event')
        .then(response => {
			if (!response.ok) {
	      		throw new Error('Network response was not ok');
		    }
		    return response.json();})
        .then(data => {
			dbList = data;
            console.log(dbList);
            showCalendar(year, month);
        })
        .catch(error => console.error('Error fetching events:', error));
}

document.querySelector('#prev').addEventListener('click', moveCalendar)
document.querySelector('#next').addEventListener('click', moveCalendar)
fetchEvents()