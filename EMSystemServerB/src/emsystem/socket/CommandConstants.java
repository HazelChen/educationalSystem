package emsystem.socket;

public class CommandConstants {
	
	/**
	 * 初始学生数据提交到总服务器
	 */
	public final static String STUDENT_DATA = "student_data";
	
	/**
	 * 其他院系课程查看
	 */
	public final static String NOT_SELECTED_COURSE_A = "not_selected_course_a";
	public final static String NOT_SELECTED_COURSE_B = "not_selected_course_b";
	public final static String NOT_SELECTED_COURSE_C = "not_selected_course_c";
	
	/**
	 * 共享课程
	 */
	public final static String SHARE_COURSE = "share_course";
	
	/**
	 * 学生选课
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
	
	public final static String GET_COURSE_INFORMATION_BY_ID = "get_course_information_by_id";
	public final static String GET_STUDENT_INFORMATION_BY_ID = "get_student_information_by_id";
	/**
	 * 获得每个学生的选课信息
	 */
	public static final String GET_STUDENT_ELECTIVES = "get_student_electives";
}
