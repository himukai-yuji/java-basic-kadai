package com.example.Calendar.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Calendar.entity.CalendarEntity;
import com.example.Calendar.service.CalendarService;

@Controller
public class HomeController {
	@Autowired
    private CalendarService calendarService;
	
	@GetMapping("/api/event")
	@ResponseBody
    public List<CalendarEntity> getItems() {
        return calendarService.getAllItems();
    }
	
    @GetMapping("/")
    public String index() {
        return "calender";
    }
	@PostMapping("/submit")
	public String submit(Model model){
		return "calender";
	}
}