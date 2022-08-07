package UnitTesting;

import Testing.UnitTesting.Currency;
import Testing.UnitTesting.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

	private final Money m12CHF = new Money(12, Currency.CHF);
	private final Money m14CHF = new Money(14, Currency.CHF);

	@Test
	void testSimpleAdd() {
		Money expected = new Money(26, Currency.CHF);
		Money observed = m12CHF.add(m14CHF);
		assertEquals(expected, observed);
	}

	@Test
	void testSimpleSubtract() {
		Money expected = new Money(2, Currency.CHF);
		Money observed = m14CHF.subtract(m12CHF);
		assertEquals(expected, observed);
	}

	@Test
	void testInvalidAdd() {
		Money m14USD = new Money(14, Currency.USD);
		assertThrows(IllegalArgumentException.class, () -> {
			Money observed = m14CHF.add(m14USD);
      });
	}
}
