package Lecture41;

public class Static_Student {

	public static void main(String[] args) {

		Student s1 = new Student("A");
		Student s2 = new Student("B");

		//System.out.println(s1.totalStudents); -> error
		System.out.println(Student.totalStudents);
		System.out.println(s1.rollNo);
		System.out.println(s2.rollNo);
		
		s1.introduceYourself();
		s2.introduceYourself();
		
		Student.getTotalStudents();//static function
	}

}
