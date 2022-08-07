package MockTesting;

import Testing.MockObjectPattern.Course;
import Testing.MockObjectPattern.EnrollmentService;
import Testing.MockObjectPattern.Student;
import org.easymock.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(EasyMockExtension.class)
class EnrollmentServiceTest {

	@TestSubject
	private EnrollmentService enrollmentService = new EnrollmentService();
	@Mock
	private Course courseMock;

	@Test
	void testEnrollStudentSuccessful() {
		Student student = new Student();
		int expectedSize = student.getCourses().size() + 1;
		expect(courseMock.enroll(student)).andReturn(true);
		replay(courseMock);

		enrollmentService.enroll(student, courseMock);

		assertEquals(expectedSize, student.getCourses().size());
		verify(courseMock);

	}

	@Test
	void testEnrollStudentFailure() {
		Student student = new Student();
		int expectedSize = student.getCourses().size();
		expect(courseMock.enroll(student)).andReturn(false);
		replay(courseMock);

		enrollmentService.enroll(student, courseMock);

		assertEquals(expectedSize, student.getCourses().size());
		verify(courseMock);
	}

}
