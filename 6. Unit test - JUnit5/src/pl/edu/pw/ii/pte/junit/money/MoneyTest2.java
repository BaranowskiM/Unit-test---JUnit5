package pl.edu.pw.ii.pte.junit.money;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoneyTest2 {
	private Money m12CHF;
	private Money m14CHF;
	private Money m15USD;
	private Money m16USD;
	private Money m20PLN;
	private Money m21PLN;
	private Money m0PLN;
	private Money m0USD;

	@BeforeEach
	public void setUp() throws Exception {
		m12CHF = new Money(12, "CHF");
		m14CHF = new Money(14, "CHF");
		m15USD = new Money(15, "USD");
		m16USD = new Money(16, "USD");
		m20PLN = new Money(20, "PLN");
		m21PLN = new Money(21, "PLN");
		m0PLN = new Money(0, "PLN");
		m0USD = new Money(0, "USD");
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleAdd2() {
		Money expected = new Money(26, "CHF");
		Money result = m12CHF.add(m14CHF); //
		assertTrue(expected.equals(result)); //
	}

	@Test
	public void testEquals2() {
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertTrue(!m12CHF.equals(m14CHF));
	}
	
	@Test
	public void testMultiplyCurrency() {
		Money expected0 = new Money(0, "CHF");
		Money expected1 = new Money(12, "CHF");
		Money expected3 = new Money(36, "CHF");
		Money expected314 = new Money(42, "CHF");
		
		Money result0 = new Money(0, "CHF");
		Money result3 = new Money(36, "CHF");
		
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, expected1.multiplyCurrency(1));
		assertEquals(expected3, m12CHF.multiplyCurrency(3));
		assertTrue(expected314.equals(m14CHF.multiplyCurrency(3)));
		assertTrue(result0.equals(m14CHF.multiplyCurrency(0)));
		assertEquals(expected0, result0);
		assertEquals(expected1.multiplyCurrency(3), result3);
	}
	
	@Test
	public void testAddDifferentCurrency() {
		Money minusm12CHF = new Money(-12, "CHF");
		
		Money resultm0PLNm20PLN = new Money(20, "PLN");
		Money resultm20PLNm0USD = new Money(20, "PLN");
		Money resultm20PLNm15USD = new Money(65, "PLN");
		Money resultm0USDm12CHF = new Money(16, "USD");
		Money resultm15USDm12CHF = new Money(31, "USD");
		Money resultm20PLNm12CHF = new Money(68, "PLN");
		Money resultm12CHFm20PLN = new Money(17, "CHF");
		Money resultm12CHFm15USD = new Money(23.25, "CHF");
		Money resultm15USDminusm12CHF = new Money(-1, "USD");
		Money resultm15USDm21PLN = new Money(22, "USD");
		
		assertEquals(m20PLN.addAnyCurrency(m15USD), resultm20PLNm15USD);
		assertFalse(m20PLN.addAnyCurrency(m15USD).equals((m15USD).addAnyCurrency(m20PLN)));
		assertEquals(m20PLN.addAnyCurrency(m0USD), resultm20PLNm0USD);
		assertEquals(m15USD.addAnyCurrency(m12CHF), resultm15USDm12CHF);
		assertEquals(m15USD.addAnyCurrency(m21PLN), resultm15USDm21PLN);
		assertEquals(m0USD.addAnyCurrency(m12CHF), resultm0USDm12CHF);
		assertEquals(m0PLN.addAnyCurrency(m20PLN), resultm0PLNm20PLN);
		assertEquals(m20PLN.addAnyCurrency(m12CHF), resultm20PLNm12CHF);
		assertEquals(m12CHF.addAnyCurrency(m20PLN), resultm12CHFm20PLN);
		assertEquals(m12CHF.addAnyCurrency(m15USD), resultm12CHFm15USD);
		assertEquals(m15USD.addAnyCurrency(minusm12CHF), resultm15USDminusm12CHF);
	}
	
	
	@Test
	public void testCurrencyComparasion(){
		assertEquals(m12CHF.currencyComparasion("PLN"), new Money(48, "PLN"));
		assertEquals(m12CHF.currencyComparasion("USD"), new Money(16, "USD"));
		assertEquals(m15USD.currencyComparasion("PLN"), new Money(45, "PLN"));
		assertEquals(m16USD.currencyComparasion("CHF"), new Money(12, "CHF"));
		assertEquals(m20PLN.currencyComparasion("CHF"), new Money(5, "CHF"));
		assertEquals(m21PLN.currencyComparasion("USD"), new Money(7,"USD"));
		assertEquals(m0PLN.currencyComparasion("USD"), new Money(0, "USD"));
		assertEquals(m0USD.currencyComparasion("CHF"), new Money(0, "CHF"));
	}

}
