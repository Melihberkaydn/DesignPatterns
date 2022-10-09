package MockTesting4;

import Testing.MockObjectPattern4.*;
import org.easymock.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.time.LocalDate;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(EasyMockExtension.class)
class DiscussionTest {
    private static final int MONTH = 3;
    private static final int YEAR = 1995;
    private static final int DAY = 23;

    @TestSubject
    private Discussion discussion = new Discussion();

    @Mock
    private Course courseMock;

    @Mock
    private Comment commentMock;

    // TODO implement the tests
    @Test
    void testComment() {
        expect(commentMock.save()).andReturn(true);
        replay(commentMock);
        discussion.addComment(commentMock);
        assertEquals(1, discussion.getNumberOfComments());
        verify(commentMock);
    }

    @Test
    void testCommentIfSavingFails() {
        expect(commentMock.save()).andReturn(false);
        replay(commentMock);
        discussion.addComment(commentMock);
        assertEquals(0, discussion.getNumberOfComments());
        verify(commentMock);
    }

    @Test
    void testStartCourseDiscussion() {
        Person student = new Student("Melih", "Aydin", LocalDate.of(YEAR, MONTH, DAY), "Informatics", "Management");
        expect(courseMock.isDiscussionAllowed(student)).andReturn(true);
        replay(courseMock);
        boolean testReturn = discussion.startCourseDiscussion(courseMock, student, "How to find a penguin?");
        assertTrue(testReturn);
        assertEquals(discussion.getTopic(), "How to find a penguin?");
        assertEquals(discussion.getCourse(), courseMock);
        verify(courseMock);
    }

}
