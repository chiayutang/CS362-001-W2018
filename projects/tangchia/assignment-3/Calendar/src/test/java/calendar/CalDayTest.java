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

		 //assertEquals(2000,calday.getAppts().get(0)getStart);


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

		 GregorianCalendar cal =
				 new GregorianCalendar(2000,3,
						 11);
		 CalDay calday = new CalDay(cal);

		 assertEquals(11,calday.getDay());
		 assertEquals(3,calday.getMonth());
		 assertEquals(2000,calday.getYear());

		 int Hour=3;
		 int Minute=3;
		 int Day=3;
		 int Month=3;
		 int Year=2030;
		 String Title=null;
		 String Description=null;
		 //Construct a new Appointment object with the initial data
		 Appt appt_1 = new Appt(Hour,
				 Minute ,
				 Day ,
				 Month ,
				 Year ,
				 Title,
				 Description);

		 calday.addAppt(appt_1);
		 appt_1.setStartHour(-1);
		 assertEquals(-1,calday.getAppts().get(0).getStartHour());
		 calday.addAppt(appt_1);

		 Hour=3;
		 Minute=3;
		 Day=3;
		 Month=3;
		 Year=2000;
		 Title=null;
		 Description=null;
		 //Construct a new Appointment object with the initial data
		 Appt appt_2 = new Appt(Hour,
				 Minute ,
				 Day ,
				 Month ,
				 Year ,
				 Title,
				 Description);

		 calday.addAppt(appt_2);
		 assertEquals(3,calday.getAppts().get(1).getStartHour());

		 Hour=3;
		 Minute=3;
		 Day=3;
		 Month=3;
		 Year=2000;
		 Title=null;
		 Description=null;
		 //Construct a new Appointment object with the initial data
		 Appt appt_3 = new Appt(Hour,
				 Minute ,
				 Day ,
				 Month ,
				 Year ,
				 Title,
				 Description);

		 calday.addAppt(appt_3);
		 appt_3.setStartHour(1);
		 assertEquals(1,calday.getAppts().get(2).getStartHour());
		 calday.addAppt(appt_3);

		 Hour=6;
		 Minute=3;
		 Day=3;
		 Month=3;
		 Year=2000;
		 Title=null;
		 Description=null;
		 //Construct a new Appointment object with the initial data
		 Appt appt_4 = new Appt(Hour,
				 Minute ,
				 Day ,
				 Month ,
				 Year ,
				 Title,
				 Description);

		 calday.addAppt(appt_4);


		 assertEquals(1,calday.getAppts().get(3).getStartHour());
	 }
//add more unit tests as you needed	
}
