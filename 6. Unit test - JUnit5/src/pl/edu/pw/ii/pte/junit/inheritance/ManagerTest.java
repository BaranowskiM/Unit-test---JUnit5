package pl.edu.pw.ii.pte.junit.inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This program demonstrates inheritance.
 * @version 1.21 2004-02-21
 * @author Cay Horstmann
 * http://www.horstmann.com/corejava.html
 */
public class ManagerTest{
/*	
   public static void main(String[] args)
   {
      // construct a Manager object
      Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      boss.setBonus(5000);

      Employee[] staff = new Employee[3];

      // fill the staff array with Manager and Employee objects

      staff[0] = boss;
      staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

      // print out information about all Employee objects
      for (Employee e : staff)
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ", hire Day: " + e.getHireDay());
   }
*/
   private Manager boss;
   
   
   @BeforeEach
   public void setUp() throws Exception{
	   boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
	   
   }
   
   @AfterEach
	public void tearDown() throws Exception {
	   
	}
   
   @Test
   public void employeeName() {	    
	   assertEquals(boss.getName(), "Carl Cracker");
	   
   }
   
   @Test
   public void employeeSalary() {
	   assertEquals(boss.getSalary(), 80000);
	 
   }

@Test
   public void employeeHireDate() {
		assertEquals(boss.getHireDay().getYear(), 1987);
		assertEquals(boss.getHireDay().getMonthValue(), 12);
		assertEquals(boss.getHireDay().getDayOfMonth(), 15);
	
   }

@Test
	public void emplyeeRiseSalary() {
		boss.raiseSalary(10);
	
	
		assertEquals(boss.getSalary(), 88000);
	
	}

@Test
	public void managerBonus() {
		boss.setBonus(7777);
		
		assertEquals(boss.getSalary(), 87777);
}


}