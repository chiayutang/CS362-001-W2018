package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	private static final long TestTimeout = 60 * 50 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

	public static String RandomSelectMethod (Random random){
		String[] methodArray = new String[]{"setTitle", "setRecurrence"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n]; // return the method name
	}
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */

	public static int RandomSelectRecur(Random random) {
		int[] RecurArray = new int[]{Appt.RECUR_BY_WEEKLY, Appt.RECUR_BY_MONTHLY, Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n]; // return the value of the  appointments to recur
	}

	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
	public static int RandomSelectRecurForEverNever(Random random) {
		int[] RecurArray = new int[]{Appt.RECUR_NUMBER_FOREVER, Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n]; // return appointments to recur forever or Never recur
	}
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 LinkedList<Appt> deleted;

		 //   try {

		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			 long randomseed = System.currentTimeMillis(); //10
			 //			System.out.println(" Seed:"+randomseed );
			 Random random = new Random(randomseed);
			 int startYear = ValuesGenerator.RandInt(random);
			 int startDay = ValuesGenerator.getRandomIntBetween(random, -10, 40);
			 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			 TimeTable timeTable = new TimeTable();
			 GregorianCalendar today = new GregorianCalendar(startYear, startMonth, startDay);
		//	 startYear = ValuesGenerator.RandInt(random);
		//	 startDay = ValuesGenerator.getRandomIntBetween(random, -10, 40);
		//	 startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			 GregorianCalendar tomorrow = new GregorianCalendar(startYear, startMonth, startDay+1);
		//	 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		//	 tomorrow.add(Calendar.DAY_OF_MONTH,1);
			 //tomorrow.add(30,1);
			 LinkedList<Appt> listAppts = new LinkedList<Appt>();
			 int startHour=0;
			 int startMinute=0;
			 String title="";
			 String description="";
			 Appt appt = new Appt(startHour,
					 startMinute,
					 startDay,
					 startMonth,
					 startYear,
					 title,
					 description);

			 for (int i = 0; i < 100; i++) {
				 startHour = ValuesGenerator.getRandomIntBetween(random, -10, 24);
				 startMinute = ValuesGenerator.getRandomIntBetween(random, -10, 60);
				 startDay = ValuesGenerator.getRandomIntBetween(random, -10, 40);
				 startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 startYear = ValuesGenerator.RandInt(random);
				 title = "Birthday Party";
				 description = "This is my birthday party.";
				 //Construct a new Appointment object with the initial data
				 appt = new Appt(startHour,
						 startMinute,
						 startDay,
						 startMonth,
						 startYear,
						 title,
						 description);

				//if (!appt.getValid()) continue;
				 random = new Random();
				 String methodName = ApptRandomTest.RandomSelectMethod(random);
				 if (methodName.equals("setTitle")) {
					 String newTitle = (String) ValuesGenerator.getString(random);
					 appt.setTitle(newTitle);
				 } else if (methodName.equals("setRecurrence")) {
					 random = new Random();
					 int n = random.nextInt(10) + 1;
					 int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
					 int[] recurDays = null;
					 if (n > 5) {
						 recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
					 } else {

					 }
					 int recur = ApptRandomTest.RandomSelectRecur(random);
					 int recurIncrement = ValuesGenerator.RandInt(random);
					 int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
					 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
					 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
				 }


				 int a=random.nextInt(10)+1;
				 if(a<=1 && 1<=3){
					 deleted=timeTable.deleteAppt(null,null);
					 deleted=timeTable.deleteAppt(null,appt);
					 deleted=timeTable.deleteAppt(listAppts,null);
					 assertEquals(null,deleted);
				 }
				 else if(a<=4 && 1<=6){
					 appt.setStartHour(-1);
					 listAppts.add(appt);
					 deleted=timeTable.deleteAppt(listAppts,appt);
					 assertEquals(null,deleted);
				 }
				 else if(a == 7 || a == 8){

					 deleted=timeTable.deleteAppt(listAppts,appt);
					 listAppts.add(appt);
					 deleted=timeTable.deleteAppt(listAppts,appt);

				 }

				else {
					 listAppts.add(appt);
				 }
				 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
				// calDays = timeTable.getApptRange(listAppts, today, tomorrow);
				 //deleted=timeTable.deleteAppt(listAppts,listAppts.get(0));
				 listAppts.add(appt);
			 }

			 deleted=timeTable.deleteAppt(listAppts,listAppts.get(1));

			 //LinkedList<CalDay> calDays = new LinkedList<CalDay>();
			// calDays = timeTable.getApptRange(listAppts, today, tomorrow);

			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);

		 }
	 }


	
}
