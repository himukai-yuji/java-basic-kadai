package com.example.Calendar.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Calendar.entity.CalendarEntity;


@Repository
public interface  CalendarRepository extends JpaRepository<CalendarEntity, Integer>{
	
	@Query(value = "SELECT * FROM calendertd ORDER BY DATE", nativeQuery = true)
	List<CalendarEntity> findAllCalender();
	

}