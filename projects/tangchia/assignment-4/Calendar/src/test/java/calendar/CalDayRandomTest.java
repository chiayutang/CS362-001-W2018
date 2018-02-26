package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

    /**
     * Generate Random Tests that tests CalDay Class.
     */
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

    @Test
    public void radnomtest() throws Throwable {
        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        //   try {

        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
            long randomseed = System.currentTimeMillis(); //10
            //			System.out.println(" Seed:"+randomseed );
            Random random = new Random(randomseed);
            int startYear = ValuesGenerator.RandInt(random);
            int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 30);
            int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
            GregorianCalendar cal = new GregorianCalendar(startYear, startMonth, startDay);
            CalDay calday = new CalDay(cal);



            int n = random.nextInt(100) + 0;
            for (int i = 0; i < n; i++) {
                int startHour = ValuesGenerator.getRandomIntBetween(random, -10, 24);
                int startMinute = ValuesGenerator.getRandomIntBetween(random, -10, 60);
                startDay = ValuesGenerator.getRandomIntBetween(random, -10, 40);
                startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                startYear = ValuesGenerator.RandInt(random);
                String title = "Birthday Party";
                String description = "This is my birthday party.";
                //Construct a new Appointment object with the initial data
                Appt appt = new Appt(startHour,
                        startMinute,
                        startDay,
                        startMonth,
                        startYear,
                        title,
                        description);
                //  if (!appt.getValid()) continue;
                random = new Random();
                String methodName = ApptRandomTest.RandomSelectMethod(random);
                if (methodName.equals("setTitle")) {
                    String newTitle = (String) ValuesGenerator.getString(random);
                    appt.setTitle(newTitle);
                } else if (methodName.equals("setRecurrence")) {
                    random = new Random();
                    n = random.nextInt(2) + 1;
                    int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
                    int[] recurDays = null;
                    if (n > 1) {
                        recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
                    } else {

                    }
                    int recur = ApptRandomTest.RandomSelectRecur(random);
                    int recurIncrement = ValuesGenerator.RandInt(random);
                    int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
                    appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
                }
                calday.addAppt(appt);
            }
            elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);


        }


        //   } catch (NullPointerException e) {

   // }

    }



}