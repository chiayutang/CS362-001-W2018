package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 GregorianCalendar cal =
				 new GregorianCalendar(2000,3,
						 11);
		 CalDay cd = new CalDay();

	 	 CalDay calday = new CalDay(cal);
		 cd.isValid();
		 cd.iterator();
		 cd.toString();


		 int startHour=3;
		 int startMinute=3;
		 int startDay=3;
		 int startMonth=3;
		 int startYear=2030;
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
		appt.setStartDay(-1);
		 calday.addAppt(appt);

		 calday.isValid();
		 calday.iterator();
		 calday.toString();

		 startHour=10;
		 startMinute=30;
		 startDay=15;
		 startMonth=01;
		 startYear=2018;
		 title="Birthday Party";
		 description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 calday.addAppt(appt);

		 startHour=21;
		 startMinute=30;
		 startDay=15;
		 startMonth=01;
		 startYear=2018;
		 title="Birthday Party";
		 description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 calday.addAppt(appt);
		 assertNotNull(calday.iterator());
		 assertNotNull(calday.toString());
		 startHour=20;
		 startMinute=30;
		 startDay=15;
		 startMonth=01;
		 startYear=2018;
		 title="Birthday Party";
		 description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 calday.addAppt(appt);



		 assertNotNull(calday.toString());


		 assertNotNull(calday.getSizeAppts());
		 assertNotEquals(0,calday.getSizeAppts());
		 assertNotNull(calday.iterator());



	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed	
}
