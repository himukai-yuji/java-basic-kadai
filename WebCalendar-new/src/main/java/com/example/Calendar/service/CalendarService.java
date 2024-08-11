package com.example.Calendar.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.Calendar.entity.CalendarEntity;
import com.example.Calendar.repository.CalendarRepository;

@Service
public class CalendarService {
	
	@Value("${spring.datasource.url}")
    private String dbUrl;
	
	@Autowired
	private CalendarRepository calendarRepository;
    
	public List<CalendarEntity> getAllItems() {
        return calendarRepository.findAllCalender();
    }

}