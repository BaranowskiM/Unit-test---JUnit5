package pl.edu.pw.ii.pte.junit.money;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

class Money {
	private double fAmount;
	private String fCurrency;
	private double p = 1;
	private String[] currencyList = {"CHF", "USD", "PLN"};
	private double[] currencyValue = {4.0, 3.0, 1.0};
		
	public Money(double amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}

	public double amount() {
		return fAmount;
	}

	public String currency() {
		return fCurrency;
	}

	public Money add(Money m) {
		return new Money(amount() + m.amount(), currency());
	}

	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money a = (Money) anObject;

			return a.currency().equals(currency()) && amount() == a.amount();
		}
		return false;

	}
	
	public Money multiplyCurrency(int k) {
		return new Money(k * amount(), currency());
	}
	
	public Money addAnyCurrency (Money m) {
		
		for(int i = 0; i < currencyList.length; i++) {
			for(int j = 0; j < currencyList.length; j++) {
				if(currency().equals(currencyList[i]) && m.currency().equals(currencyList[j])) {
					p = (currencyValue[j] / currencyValue[i]);
				}
			}
		}
		
		return new Money(amount() + m.amount() * p, currency());
		
	}	
	
	
	public Money currencyComparasion (String curr) {
		
		
		for(int i = 0; i < currencyList.length; i++) {
			for(int j = 0; j < currencyList.length; j++) {
				if(currency().equals(currencyList[i]) && curr.equals(currencyList[j])) {
					p = (currencyValue[i] / currencyValue[j]);
				}
			}
		}
		
		return new Money(amount() * p, curr);
	}

}