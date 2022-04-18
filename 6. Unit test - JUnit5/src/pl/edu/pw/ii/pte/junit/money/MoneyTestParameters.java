package pl.edu.pw.ii.pte.junit.money;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTestParameters {
	
	@ParameterizedTest
	@ValueSource(strings = {"PLN", "CHF", "USD"})
	public void testSimpleAddParam(String currency) {
		Money m12curr = new Money(12, currency);
		Money m14curr = new Money(14, currency);
		Money expected = new Money(26, currency);
		Money result = m12curr.add(m14curr);
		assertEquals(expected, result);
	}
	
	@ParameterizedTest
	@CsvSource({"10, PLN, 10, PLN, 15, USD", "5, USD, 5, USD, 9, CHF", "15, CHF, 15, CHF, 4, PLN"})
	public void testEqualsParam(int a, String acurr, int b, String bcurr, int c, String ccurrency) {
		Money aMoney = new Money(a, acurr);
		Money bMoney = new Money(b, bcurr);
		Money cMoney = new Money(c, ccurrency);
		assertTrue(aMoney.equals(bMoney));
		assertFalse(aMoney.equals(cMoney));
		assertTrue(!cMoney.equals(bMoney));
		assertTrue(!aMoney.equals(null));
	}
	
	@ParameterizedTest
	@CsvSource({"12, 2, 24", "20, 3, 60", "0, 0, 0", "12, 1, 12"})
	public void testMultiplyCurrencyParam(int a, int p, int expected){
		Money aPLN = new Money(a, "PLN");
		Money expectedPLN = new Money(expected, "PLN");
		assertTrue(aPLN.multiplyCurrency(p).equals(expectedPLN));
	}

	
	@ParameterizedTest
	@CsvSource({"12, PLN, 10, PLN, 22", "20, PLN, 15, USD, 65", "12, PLN, 10, CHF, 52",
		"12, USD, 10, USD, 22", "12, USD, 12, PLN, 16", "12, USD, 12, CHF, 28", 
		"12, CHF, 10, CHF, 22", "12, CHF, 20, PLN, 17", "12, CHF, 12, USD, 21"})
	public void testAddAnyCurrency(int a,String currencyA, int b, String currency2, 
			int expected) {
		Money aMoney = new Money(a, currencyA);
		Money bMoney = new Money(b, currency2);
		Money expectedMoney = new Money(expected, currencyA);
		Money resultMoney = aMoney.addAnyCurrency(bMoney);
		assertTrue(resultMoney.equals(expectedMoney));	
	}
	
	

	@ParameterizedTest
	@CsvSource({"21, PLN, USD, 7", "12, PLN, CHF, 3", "12, USD, PLN, 36", "12, USD, CHF, 9", 
		"12, CHF, PLN, 48", "12, CHF, USD, 16"})
	public void testCurrencyComparasion(int a, String currencyA, String currencyB, 
			int expected) {
		Money aMoney = new Money(a, currencyA);
		Money expectedMoney = new Money(expected, currencyB);
		Money resultMoney = aMoney.currencyComparasion(currencyB);
		assertTrue(resultMoney.equals(expectedMoney));	
	}
	
	
	

}
