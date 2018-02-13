package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions

		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());

	 }

	 @Test
	  public void test02()  throws Throwable  {


			 int startHour=21;
			 int startMinute=30;
			 int startDay=15;
			 int startMonth=01;
			 int startYear=2018;
			 String title=null;
			 String description=null;
			 //Construct a new Appointment object with the initial data
			 Appt appt = new Appt(startHour,
					 startMinute ,
					 startDay ,
					 startMonth ,
					 startYear ,
					 title,
					 description);


		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());
		 appt.setStartHour(0);
		 assertTrue(appt.getValid());
		 appt.setStartHour(10);
		 assertEquals(10,appt.getStartHour());
		 assertTrue(appt.getValid());
		 appt.setStartHour(23);
		 assertTrue(appt.getValid());
		 appt.setStartHour(10);


		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 assertEquals(null,appt.toString());

		 appt.setStartMinute(0);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(59);
		 assertTrue(appt.getValid());

		 appt.setStartMinute(10);
		 assertEquals(10,appt.getStartMinute());
		 assertTrue(appt.getValid());

		 appt.setStartDay(-1);
		 assertFalse(appt.getValid());
		 appt.setStartDay(1);
		 assertTrue(appt.getValid());
		 appt.setStartDay(31);
		 assertTrue(appt.getValid());
		 appt.setStartDay(10);
		 assertEquals(10,appt.getStartDay());
		 assertTrue(appt.getValid());

		 appt.setStartMonth(1);
		 assertTrue(appt.getValid());

		 appt.setStartYear(0);
		 assertTrue(appt.getValid());
		 assertNotEquals(2000,appt.getStartYear());

		 appt.setStartMonth(12);
		 assertTrue(appt.getValid());

		 appt.setStartMonth(10);
		 assertEquals(10,appt.getStartMonth());
		 assertTrue(appt.getValid());

		 appt.setStartYear(2000);
		 assertEquals(2000,appt.getStartYear());
		 assertTrue(appt.getValid());



		 //Construct a new Appointment object with the initial data


		 assertEquals("",appt.getDescription());

		 appt.setDescription("test");
		 assertEquals("test",appt.getDescription());


		 assertEquals("",appt.getTitle());

		 appt.setTitle("test");
		 assertEquals("test",appt.getTitle());


		 int[] recurDaysArr={2,3,4};
		 appt.setRecurrence( recurDaysArr, 10, 2, 10);

		 assertEquals(10,appt.getRecurNumber());
		 assertEquals(10,appt.getRecurBy());
		 assertNotNull(appt.getRecurDays());
		 assertTrue(appt.isRecurring());
		 assertEquals(2,appt.getRecurIncrement());

		 assertNotNull(appt.toString());
		 appt.setStartHour(14);
		 assertNotNull(appt.toString());
		 appt.setStartHour(11);
		 assertNotNull(appt.toString());
		 appt.setStartHour(12);
		 assertNotNull(appt.toString());
		 appt.setStartHour(0);
		 assertNotNull(appt.toString());
		 assertNotNull(appt.compareTo(appt));
		 assertNotEquals("x",appt.toString());
	 }

	@Test
	public void test03()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		assertEquals(0, appt.compareTo(appt));
		assertNotEquals("x",appt.toString());
		assertEquals("\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
		assertNotNull(appt.compareTo(appt));
		appt.setStartHour(11);
		assertEquals("\t1/15/2018 at 11:30am ,Birthday Party, This is my birthday party.\n", appt.toString());
		appt.setStartDay(-1);
		assertNull(appt.toString());
		appt.setStartHour(0);

		assertEquals(0, appt.compareTo(appt));

		assertNotNull(appt.compareTo(appt));
		startHour=21;
		startMinute=0;
		startDay=15;
		startMonth=01;
		startYear=2018;
		title=null;
		description=null;
		//Construct a new Appointment object with the initial data
		Appt appt_1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		assertEquals(-7, appt.compareTo(appt_1));
		appt.setStartHour(11);
		assertEquals(4, appt.compareTo(appt_1));
		appt.setStartMinute(0);
		assertEquals(-26, appt.compareTo(appt_1));
		appt.setStartMonth(12);
		assertEquals(-15, appt.compareTo(appt_1));
		appt.setStartYear(20);
		assertEquals(-2013, appt.compareTo(appt_1));

	}

//add more unit tests as you needed

	
}
