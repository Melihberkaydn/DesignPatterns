package MockTesting3;

import Testing.MockObjectPattern3.Item;
import Testing.MockObjectPattern3.Account;
import Testing.MockObjectPattern3.CheckoutMethod;
import org.easymock.EasyMockExtension;
import org.easymock.IAnswer;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class AccountTest {


    @Mock
    private CheckoutMethod checkoutMethod1;

    @Mock
    private CheckoutMethod checkoutMethod2;

    @Mock
    private CheckoutMethod checkoutMethod3;

    @Mock
    private Item item;

    @TestSubject
    private Account account = new Account("TestAccount");

    @Test
    void testSecond() {
        expect(checkoutMethod1.pay(item)).andReturn(false);
        expect(checkoutMethod2.pay(item)).andReturn(true);

        List<CheckoutMethod> methods = new ArrayList<>();
        methods.add(checkoutMethod1);
        methods.add(checkoutMethod2);
        methods.add(checkoutMethod3);
        replay(checkoutMethod1,checkoutMethod3, checkoutMethod2, item);

        account.setCheckoutMethods(methods);

        assertTrue(account.checkoutFor(item));

        verify(checkoutMethod3);
    }


   /* @Test
    void testSecond() {
        expect(checkoutMethod1.pay(item)).andReturn(false);
        expect(checkoutMethod2.pay(item)).andReturn(true);

        List<CheckoutMethod> methods = new ArrayList<>();
        methods.add(checkoutMethod1);
        methods.add(checkoutMethod2);

        account.setCheckoutMethods(methods);
        replay(checkoutMethod1, checkoutMethod2, item);

        assertTrue(account.checkoutFor(item));

        verify(checkoutMethod1, checkoutMethod2, item);
    }


    //https://stackoverflow.com/questions/1972488/easymock-test-that-method-in-mock-isnt-called
    //idea andThrow taken from here
    @Test
    void testThird() {
        expect(checkoutMethod1.pay(item)).andReturn(false);
        expect(checkoutMethod2.pay(item)).andReturn(true);
        expect(checkoutMethod3.pay(item)).andReturn(true);

        checkoutMethod3.pay(item);
        expectLastCall().andThrow(new AssertionFailedError()).anyTimes();


        List<CheckoutMethod> methods = new ArrayList<>();
        methods.add(checkoutMethod1);
        methods.add(checkoutMethod2);
        methods.add(checkoutMethod3);

        account.setCheckoutMethods(methods);
        replay(checkoutMethod1, checkoutMethod2,checkoutMethod3, item);

        assertTrue(account.checkoutFor(item));

        verify(checkoutMethod1, checkoutMethod2, item);
    }

*/
}
