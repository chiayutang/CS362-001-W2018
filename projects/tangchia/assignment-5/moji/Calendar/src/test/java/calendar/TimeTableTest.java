package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable timeTable=new TimeTable();
		 GregorianCalendar today = new GregorianCalendar(2016,3,3);
		 GregorianCalendar tomorrow = new GregorianCalendar(2016,3,4);
		 //tomorrow.add(30,1);
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();

		 int startHour=15;
		 int startMinute=30;
		 int startDay=4;
		 int startMonth=3;
		 int startYear=2016;
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
		 listAppts.add(appt);


		 assertNotNull(listAppts);
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		 assertNotNull(calDays);
		 appt.setRecurrence( null, 1, 2, 1000);
		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		 startHour=15;
		 startMinute=33;
		 startDay=3;
		 startMonth=3;
		 startYear=2016;
		 title="Birthday";
		 description="This is my birthday.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 //listAppts.add(appt);
		 int[] recurDaysArr={2,3,4};
		 appt.setRecurrence( recurDaysArr, 1, 2, 1000);
		 listAppts.add(appt);
		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		 assertNotNull(calDays);


		 int[] pv={1,0};
		 listAppts = timeTable.permute(listAppts,pv);
		 assertNotNull(listAppts);

		 startHour=17;
		 startMinute=33;
		 startDay=1;
		 startMonth=3;
		 startYear=2016;
		 title="Bd";
		 description="bd.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt);

		 appt.setRecurrence( null, 1, 2, 1000);

		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		 assertNotNull(calDays);

		 startHour=17;
		 startMinute=33;
		 startDay=1;
		 startMonth=3;
		 startYear=2016;
		 title="Bd";
		 description="bd.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt);

		 appt.setRecurrence( null, 1, 0, 1000);

		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		 assertNotNull(calDays);

		 startHour=17;
		 startMinute=33;
		 startDay=1;
		 startMonth=3;
		 startYear=2016;
		 title="Bd";
		 description="bd.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt);

		// LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		 assertNotNull(calDays);

		 appt.setRecurrence( null, 2, 2, 1000);



		 startHour=17;
		 startMinute=33;
		 startDay=133;
		 startMonth=3;
		 startYear=2016;
		 title="Bd";
		 description="bd.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt);

		 appt.setRecurrence( recurDaysArr, 3, 2, 1000);

		 startHour=17;
		 startMinute=33;
		 startDay=133;
		 startMonth=3;
		 startYear=2016;
		 title="Bd";
		 description="bd.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 appt.setStartHour(-1);
		 appt.setRecurrence( null, 3, 2, 1000);
		 listAppts.add(appt);

		// LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		 assertNotNull(calDays);


		 GregorianCalendar occurrenceDay =
				 new GregorianCalendar(appt.getStartYear(), appt.getStartMonth(),
						 appt.getStartDay());
		 listAppts = timeTable.deleteAppt(listAppts,listAppts.get(1));
		 assertNotNull(listAppts);


		 LinkedList<Appt> listApptsnull = new LinkedList<Appt>();
		 listApptsnull=null;
		 listApptsnull = timeTable.deleteAppt(listApptsnull,listAppts.get(1));
		 assertNull(listApptsnull);

		listAppts.get(1).setStartHour(-1);

		 listAppts = timeTable.deleteAppt(listAppts,listAppts.get(1));
		 assertNull(listAppts);


		 LinkedList<Appt> listApptsother = new LinkedList<Appt>();
		 startHour=17;
		 startMinute=33;
		 startDay=1;
		 startMonth=3;
		 startYear=2016;
		 title="Bd";
		 description="bd.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listApptsother.add(appt);
		 int[] pv_2={0};
		 listApptsother = timeTable.permute(listApptsother,pv_2);
		 assertNotNull(listApptsother);
		 assertEquals(  1,listApptsother.get(0).getStartDay());




	 }

	 @Test
	  public void test02()  throws Throwable  {

		 TimeTable timeTable=new TimeTable();
		 GregorianCalendar today = new GregorianCalendar(2016,3,3);
		 GregorianCalendar tomorrow = new GregorianCalendar(2016,3,4);
		 //tomorrow.add(30,1);
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();



		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		 assertNotNull(calDays);

		 int startHour=15;
		 int startMinute=30;
		 int startDay=3;
		 int startMonth=3;
		 int startYear=2016;
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
		 listAppts.add(appt);

		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		 assertNotNull(calDays);

		 int[] pv={0};
		 listAppts = timeTable.permute(listAppts,pv);
		 assertNotNull(listAppts);


		 LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(0));
		 assertEquals(null,listDeletedAppts);

		 startHour=17;
		 startMinute=33;
		 startDay=1;
		 startMonth=3;
		 startYear=2016;
		 title="Bd";
		 description="bd.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt);
		 int[] pvv={1,0};
		 listAppts = timeTable.permute(listAppts,pvv);
		 assertNotNull(listAppts);

		 int[] pvvv={0,1};
		 listAppts = timeTable.permute(listAppts,pvvv);
		 assertNotNull(listAppts);

		 startHour=17;
		 startMinute=33;
		 startDay=1;
		 startMonth=3;
		 startYear=2016;
		 title="Bd";
		 description="bd.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 int[] recurDaysArr={2,3,4};
		 appt.setRecurrence( recurDaysArr, 1, 2, 1000);
		 listAppts.add(appt);
		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		 assertNotNull(calDays);
		 int[] pvvvv={0,2,1};
		 listAppts = timeTable.permute(listAppts,pvvvv);
		 assertNotNull(listAppts);
		 listAppts = timeTable.deleteAppt(listAppts,listAppts.get(1));
		 assertNotNull(listAppts);
		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		 assertNotNull(calDays);

		 startHour=17;
		 startMinute=33;
		 startDay=1;
		 startMonth=3;
		 startYear=2016;
		 title="Bd";
		 description="bd.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt);
		 startHour=17;
		 startMinute=33;
		 startDay=1;
		 startMonth=3;
		 startYear=2016;
		 title="Bd";
		 description="bd.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 listAppts.add(appt);
		 listAppts = timeTable.deleteAppt(listAppts,listAppts.get(2));
		 assertNotNull(listAppts);
	 }
	@Test
	public void test03()  throws Throwable  {
		TimeTable timeTable=new TimeTable();
		GregorianCalendar today = new GregorianCalendar(2016,3,3);
		GregorianCalendar tomorrow = new GregorianCalendar(2016,3,4);
		//tomorrow.add(30,1);
		LinkedList<Appt> listAppts = new LinkedList<Appt>();

		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertNotNull(calDays);

		int startHour=15;
		int startMinute=30;
		int startDay=3;
		int startMonth=3;
		int startYear=2016;
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
		listAppts.add(appt);

		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertNotNull(calDays);
	}

	@Test
	public void test04()  throws Throwable  {
		TimeTable timeTable=new TimeTable();
		GregorianCalendar today = new GregorianCalendar(2016,3,3);
		GregorianCalendar tomorrow = new GregorianCalendar(2016,3,4);
		//tomorrow.add(30,1);
		LinkedList<Appt> listAppts = new LinkedList<Appt>();

		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertNotNull(calDays);

		int startHour=15;
		int startMinute=30;
		int startDay=3;
		int startMonth=3;
		int startYear=2016;
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
		appt.setStartHour(-1);
		listAppts.add(appt);
		appt.setRecurrence( null, 1, 2, 1000);
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertNotNull(calDays);
	}
//add more unit tests as you needed
}
