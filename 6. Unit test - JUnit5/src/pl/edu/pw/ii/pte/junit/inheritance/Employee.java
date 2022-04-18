package pl.edu.pw.ii.pte.junit.inheritance;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * This program demonstrates inheritance.
 * @version 1.21 2004-02-21
 * @author Cay Horstmann
 * http://www.horstmann.com/corejava.html
 */

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee
{
   private String name;
   private double salary;
   private Date hireDay;
   private LocalDate localDate;

   public Employee(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
      hireDay = calendar.getTime();
      
      //Zamiana stylu daty ze wzglêdu na brak mo¿liwoœci odczytania konkretnego dnia miesi¹ca.
      // By³a tylko mo¿liwoœæ odczytania dnia tygodnia
      localDate = hireDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   //Zmiana typu zwracanego z metody ze wzglêdu na zmianê stylu daty
   public LocalDate getHireDay()
   {
      return localDate;
   }
   
   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }
}
