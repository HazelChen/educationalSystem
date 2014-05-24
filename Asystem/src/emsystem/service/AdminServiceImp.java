package emsystem.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import emsystem.data.Account;
import emsystem.data.Choice;
import emsystem.data.Course;
import emsystem.data.Student;
import emsystem.database.DealWithAccount;
import emsystem.database.DealWithChoice;
import emsystem.database.DealWithCourse;
import emsystem.database.DealWithStudent;
import emsystem.rmi.AdminService;

public class AdminServiceImp extends UnicastRemoteObject implements AdminService{

	DealWithStudent dwstudent=new DealWithStudent();
	DealWithChoice dwchoice=new DealWithChoice();
	DealWithCourse dwcourse=new DealWithCourse();
	DealWithAccount dwaccount=new DealWithAccount();
	
	public AdminServiceImp() throws RemoteException {
		super();
	}

	@Override
	public boolean adminLogin(String pAccount, String pPassword){
		Account account=dwaccount.search(pAccount);
		boolean b=false;
		if(account!=null){
			if(account.getPassword().equals(pPassword)){
				b=true;
			}
		}
		return b;
	}

	@Override
	public ArrayList<Student> getStudents() {
		return dwstudent.getAllStudent();
	}

	@Override
	public boolean addStudent(Student pStudent){
		return dwstudent.insert(pStudent);
	}

	@Override
	public boolean modifyStudent(Student pStudent){
		return dwstudent.modify(pStudent);
	}

	@Override
	public boolean deleteStudent(String pStudentId){
		return dwstudent.delete(pStudentId);
	}

	@Override
	public String getMajorName(){
		return "π„∏Ê—ß";
	}

	@Override
	public ArrayList<Course> getCourses(){
		return dwcourse.getAllCourse();
	}

	@Override
	public boolean addCourse(Course course){
		return dwcourse.insert(course);
	}

	@Override
	public boolean modifyCourse(Course course){
		return dwcourse.modify(course);
	}

	@Override
	public boolean deleteCourse(String pCourseId){
		return dwcourse.delete(pCourseId);
	}

	@Override
	public ArrayList<Student> getChoosedStudents(String pCourseId){
		ArrayList<Student> result=new ArrayList<Student>();
		ArrayList<Choice> list=dwchoice.getAllChoice();
		for(int i=0;i<list.size();i++){
			Choice choice=list.get(i);
			if(choice.getCourseId().equals(pCourseId)){
				Student stu=dwstudent.search(choice.getStudentId());
				result.add(stu);
			}
		}
		return result;
	}

}
