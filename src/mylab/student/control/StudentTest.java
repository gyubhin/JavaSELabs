package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) {
		try{
			Student student = new Student("202213060", "김민수", "컴퓨터공학", 3);
			
			System.out.println("학번: "+student.getStudentId()+" 이름: "+student.getName()+" 학과: "+student.getMajor()+" 학년: "+student.getGrade());
			
			int newGrade = 5;
			System.out.println(newGrade+"학년으로 변경");		
			student.setGrade(newGrade);
			
			System.out.println("학번: "+student.getStudentId()+"이름: "+student.getName()+"학과: "+student.getMajor()+"학년: "+student.getGrade());
		} catch(InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
	}
}
