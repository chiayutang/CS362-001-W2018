
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {
   long ALLOW_ALL_SCHEMES = 1 << 0;

   public UrlValidatorTest(String testName) {
      super(testName);
   }


   public void testManualTest() {
//You can use this function to implement your manual testing
      String[] schemes = {"http", "https"};
      UrlValidator urlValidator = new UrlValidator(schemes);
      assertTrue(urlValidator.isValid("http://www.google.com"));
      //    assertTrue(urlValidator.isValid("http://tech.yahoo.com/rc/desktops/102;_ylt=Ao8yevQHlZ4On0O3ZJGXLEQFLZA5"));

   }

   public void testYourFirstPartition() {
      //You can use this function to implement your First Partition testing
    /*  ResultPair[] testScheme = {new ResultPair("http", true),
              new ResultPair("ftp", false),
              new ResultPair("httpd", false),
              new ResultPair("telnet", false)};

*/
      String[] schemes = {"http", "https", "ftp"};
      UrlValidator urlVal = new UrlValidator(schemes, 0);

      ResultPair testPair = new ResultPair("http", true);
      boolean result = urlVal.isValidScheme(testPair.item);
      //    assertEquals(testPair.valid,result);
      assertEquals(true, testPair.valid);


      testPair = new ResultPair("ftp", false);
      result = urlVal.isValidScheme(testPair.item);
      assertEquals(false, testPair.valid);

      testPair = new ResultPair("httpd", false);
      result = urlVal.isValidScheme(testPair.item);
      assertEquals(false, testPair.valid);

      testPair = new ResultPair("telnet", false);
      result = urlVal.isValidScheme(testPair.item);
      assertEquals(false, testPair.valid);

   }

   public void testYourSecondPartition() {
      //You can use this function to implement your Second Partition testing
      String[] schemes = {"http", "https", "ftp"};
      UrlValidator urlVal = new UrlValidator(schemes, 0);

      ResultPair testPair = new ResultPair("http", true);
      boolean result = urlVal.isValidScheme(testPair.item);
      assertEquals(false, testPair.valid);

      //   assertEquals(testPair.valid,result);

      testPair = new ResultPair("ftp", false);
      result = urlVal.isValidScheme(testPair.item);
      assertEquals(true, testPair.valid);

      testPair = new ResultPair("httpd", false);
      result = urlVal.isValidScheme(testPair.item);
      assertEquals(true, testPair.valid);

      testPair = new ResultPair("telnet", false);
      result = urlVal.isValidScheme(testPair.item);
      assertEquals(true, testPair.valid);

   }
   //You need to create more test cases for your Partitions if you need to 

   public void testIsValid() {
      private final boolean printStatus = false;
      private final boolean printIndex = false;
      //You can use this function for programming based testing


      testIsValid(testUrlParts, UrlValidator.ALLOW_ALL_SCHEMES);
      for (int index = 0; index < testPartsIndex.length - 1; index++) {
         testPartsIndex[index] = 0;
      }
   }

   public void testIsValid(Object[] testObjects, long allowAllSchemes) {
      UrlValidator urlVal = new UrlValidator(null, null, allowAllSchemes);
      int statusPerLine = 60;
      int printed = 0;
      if (printIndex) {
         statusPerLine = 6;
      }
      do {
         StringBuilder testBuffer = new StringBuilder();
         boolean expected = true;
         for (int testPartsIndexIndex = 0; testPartsIndexIndex < testPartsIndex.length; ++testPartsIndexIndex) {
            int index = testPartsIndex[testPartsIndexIndex];
            ResultPair[] part = (ResultPair[]) testObjects[testPartsIndexIndex];
            testBuffer.append(part[index].item);
            expected &= part[index].valid;

         }

         String url = testBuffer.toString();
         boolean result = urlVal.isValid(url);
         if (result == true)
            System.out.println(url);
         assertEquals(url, expected, result);
/*            if (printStatus) {
               if (printIndex) {
                  System.out.print(testPartsIndextoString());
               } else {
                  if (result == expected) {
                     System.out.print('.');
                  } else {
                     System.out.print('X');
                  }
               }
               printed++;
               if (printed == statusPerLine) {
                  System.out.println();
                  printed = 0;
               }
            }
          */
      } while (incrementTestPartsIndex(testPartsIndex, testObjects));


   }

   static boolean incrementTestPartsIndex(int[] testPartsIndex, Object[] testParts) {
      boolean carry = true;  //add 1 to lowest order part.
      boolean maxIndex = true;
      for (int testPartsIndexIndex = testPartsIndex.length - 1; testPartsIndexIndex >= 0; --testPartsIndexIndex) {
         int index = testPartsIndex[testPartsIndexIndex];
         ResultPair[] part = (ResultPair[]) testParts[testPartsIndexIndex];
         if (carry) {
            if (index < part.length - 1) {
               index++;
               testPartsIndex[testPartsIndexIndex] = index;
               carry = false;
            } else {
               testPartsIndex[testPartsIndexIndex] = 0;
               carry = true;
            }
         }
         maxIndex &= (index == (part.length - 1));
      }


      return (!maxIndex);
   }

   private String testPartsIndextoString() {
      StringBuilder carryMsg = new StringBuilder("{");
      for (int testPartsIndexIndex = 0; testPartsIndexIndex < testPartsIndex.length; ++testPartsIndexIndex) {
         carryMsg.append(testPartsIndex[testPartsIndexIndex]);
         if (testPartsIndexIndex < testPartsIndex.length - 1) {
            carryMsg.append(',');
         } else {
            carryMsg.append('}');
         }
      }
      return carryMsg.toString();

   }

   public static void main(String[] argv) {

      UrlValidatorTest fct = new UrlValidatorTest("url test");
      fct.setUp();
      fct.testIsValid();
      fct.testIsValidScheme();
   }


   ResultPair[] testUrlScheme = {new ResultPair("http://", true),
           new ResultPair("ftp://", true),
           new ResultPair("h3t://", true),
           new ResultPair("3ht://", false),
           new ResultPair("http:/", false),
           new ResultPair("http:", false),
           new ResultPair("http/", false),
           new ResultPair("://", false),
           new ResultPair("", true)};

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
           new ResultPair("go.com", true),
           new ResultPair("go.au", true),
           new ResultPair("0.0.0.0", true),
           new ResultPair("255.255.255.255", true),
           new ResultPair("256.256.256.256", false),
           new ResultPair("255.com", true),
           new ResultPair("1.2.3.4.5", false),
           new ResultPair("1.2.3.4.", false),
           new ResultPair("1.2.3", false),
           new ResultPair(".1.2.3.4", false),
           new ResultPair("go.a", false),
           new ResultPair("go.a1a", false),
           new ResultPair("go.1aa", false),
           new ResultPair("aaa.", false),
           new ResultPair(".aaa", false),
           new ResultPair("aaa", false),
           new ResultPair("", false)
   };
   ResultPair[] testUrlPort = {new ResultPair(":80", true),
           new ResultPair(":65535", true),
           new ResultPair(":0", true),
           new ResultPair("", true),
           new ResultPair(":-1", false),
           new ResultPair(":65636", false),
           new ResultPair(":65a", false)
   };
   ResultPair[] testPath = {new ResultPair("/test1", true),
           new ResultPair("/t123", true),
           new ResultPair("/$23", true),
           new ResultPair("/..", false),
           new ResultPair("/../", false),
           new ResultPair("/test1/", true),
           new ResultPair("", true),
           new ResultPair("/test1/file", true),
           new ResultPair("/..//file", false),
           new ResultPair("/test1//file", false)
   };
   //Test allow2slash, noFragment
   ResultPair[] testUrlPathOptions = {new ResultPair("/test1", true),
           new ResultPair("/t123", true),
           new ResultPair("/$23", true),
           new ResultPair("/..", false),
           new ResultPair("/../", false),
           new ResultPair("/test1/", true),
           new ResultPair("/#", false),
           new ResultPair("", true),
           new ResultPair("/test1/file", true),
           new ResultPair("/t123/file", true),
           new ResultPair("/$23/file", true),
           new ResultPair("/../file", false),
           new ResultPair("/..//file", false),
           new ResultPair("/test1//file", true),
           new ResultPair("/#/file", false)
   };

   ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
           new ResultPair("?action=edit&mode=up", true),
           new ResultPair("", true)
   };

   Object[] testUrlParts = {testUrlScheme, testUrlAuthority, testUrlPort, testPath, testUrlQuery};
   Object[] testUrlPartsOptions = {testUrlScheme, testUrlAuthority, testUrlPort, testUrlPathOptions, testUrlQuery};
   int[] testPartsIndex = {0, 0, 0, 0, 0};

   //---------------- Test data for individual url parts ----------------
   ResultPair[] testScheme = {new ResultPair("http", true),
           new ResultPair("ftp", false),
           new ResultPair("httpd", false),
           new ResultPair("telnet", false)};






};
