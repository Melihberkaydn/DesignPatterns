package Testing.MockObjectPattern;

public class EnrollmentService {

	public void enroll(Student student, Course course) {
		if (course.enroll(student)) {
			student.addCourse(course);
		}
	}
}
