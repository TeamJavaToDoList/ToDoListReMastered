package com.todolist.dao;

import java.util.List;

import com.todolist.model.Performance;

public interface PerformanceDao {

	Long savePerformance(Performance performance);
	Long updatePerformance(Performance performance);
	List<Performance> getAllPerformances();
	List<Performance> getTopFivePerformers();
	Performance getPerformance(Long performanceId);
	void calcMemberPerformance();
	void calcGroupPerformance();
	
	int calcDoneTasks(Long id);
	int calcNotDoneTasks(Long id);
	int calculateNotDoneTasksForGroup(Long id);
	int calculateDoneTasksForGroup(Long id);
	
	
}
