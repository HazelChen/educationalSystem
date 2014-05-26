package edu.nju.educationSystem.server.network;

public class CommandConstants {
	
	/**
	 * 专业
	 */
	public final static String MAJOR = "major";
	/**
	 * 初始学生数据提交到总服务器
	 */
	public final static String STUDENT_DATA = "student_data";
	
	/**
	 * 共享课程
	 */
	public final static String NOT_SELECTED_COURSE_A = "not_selected_course_a";
	public final static String NOT_SELECTED_COURSE_B = "not_selected_course_b";
	public final static String NOT_SELECTED_COURSE_C = "not_selected_course_c";
	
	/**
	 * 每个学生的选课信息
	 */
	public final static String STUDENT_ELECTIVE = "student_elective";
	
	/**
	 * 每个学生的退选信息
	 */
	public final static String COURSE_WITHDRAWAL = "course_withdrawal";
	
	/**
	 * 各个院系的选课记录返还给分服务器
	 */
	public final static String ELECTIVE_RECORD = "elective_record";
	
	/**
	 * 选课信息查看请求
	 */
	public final static String ASK_FOR_COURSE_INFORMATION = "ask_for_course_withdrawal";
	
}
