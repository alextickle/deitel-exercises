package java_I;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import junit.framework.TestCase;


public class Employee_test extends TestCase {

	public static String newline = System.getProperty("line.separator");
	
	public void testMemberPresence() throws NoSuchFieldException {
		try {
			Employee.class.getDeclaredField("firstName");
			Employee.class.getDeclaredField("lastName");
			Employee.class.getDeclaredField("monthlySalary");
		} catch (SecurityException e) {
			fail("One of the required methods does not exist or is improperly defined. Please refer to the sample solution for more information.");
		}
	}
	
	public void testMemberAccessibility() {
		try {
			assertTrue("firstName should be private", Modifier.isPrivate(Employee.class.getDeclaredField("firstName").getModifiers()));
			assertTrue("lastName should be private", Modifier.isPrivate(Employee.class.getDeclaredField("lastName").getModifiers()));
			assertTrue("monthlySalary should be private", Modifier.isPrivate(Employee.class.getDeclaredField("monthlySalary").getModifiers()));
		} catch (SecurityException e) {
			assertThrowableTestFailure(e);
		} catch (NoSuchFieldException e) {
			fail("One of the required fields does not exist or is improperly defined. Please refer to the sample solution for more information.");
		}
	}
	
	public void testMethodAccessibility() {
		try {
			assertTrue("getFirstName should be public", Modifier.isPublic(Employee.class.getDeclaredMethod("getFirstName").getModifiers()));
			assertTrue("getLastName should be public", Modifier.isPublic(Employee.class.getDeclaredMethod("getLastName").getModifiers()));
			assertTrue("getMonthlySalary should be public", Modifier.isPublic(Employee.class.getDeclaredMethod("getMonthlySalary").getModifiers()));
			
			assertTrue("setFirstName should be public", Modifier.isPublic(Employee.class.getDeclaredMethod("setFirstName", String.class).getModifiers()));
			assertTrue("setLastName should be public", Modifier.isPublic(Employee.class.getDeclaredMethod("setLastName", String.class).getModifiers()));
			assertTrue("setMonthlySalary should be public", Modifier.isPublic(Employee.class.getDeclaredMethod("setMonthlySalary", Double.TYPE).getModifiers()));
		} catch (SecurityException e) {
			assertThrowableTestFailure(e);
		} catch (NoSuchMethodException e) {
			fail("One of the required methods does not exist or is improperly defined. Please refer to the sample solution for more information.");
		}
	}
	
	public void testConstructorBaseCase() {
		final String first = "John";
		final String last = "Doe";
		final double salary = 1000;
		
		Employee employee = new Employee(first, last, salary);

		try {
			Field fFirst = Employee.class.getDeclaredField("firstName");
			fFirst.setAccessible(true);
			Field fLast = Employee.class.getDeclaredField("lastName");
			fLast.setAccessible(true);
			Field fSalary = Employee.class.getDeclaredField("monthlySalary");
			fSalary.setAccessible(true);
			
			assertEquals(fFirst.get(employee), first);
			assertEquals(fLast.get(employee), last);
			assertEquals(fSalary.get(employee), salary);
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testConstructorNegativeSalary() {
		final String first = "John";
		final String last = "Doe";
		final double salary = -1000;
		
		Employee employee = new Employee(first, last, salary);

		try {
			Field fSalary = Employee.class.getDeclaredField("monthlySalary");
			fSalary.setAccessible(true);
			
			assertEquals(0.0, fSalary.get(employee));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testGetFirstName() {
		final String first = "John";
		final String last = "Doe";
		final double salary = 1000;
		
		Employee employee = new Employee(first, last, salary);

		assertEquals("getFirstName did not return the expected value", first, employee.getFirstName());
	}
	
	public void testGetLastName() {
		final String first = "John";
		final String last = "Doe";
		final double salary = 1000;
		
		Employee employee = new Employee(first, last, salary);

		assertEquals("getLastName did not return the expected value", last, employee.getLastName());
	}
	
	public void testGetMonthlySalary() {
		final String first = "John";
		final String last = "Doe";
		final double salary = 1000;
		
		Employee employee = new Employee(first, last, salary);

		assertEquals("getMonthlySalary did not return the expected value", salary, employee.getMonthlySalary());
	}
	
	public void testSetFirstName() {
		final String first = "John";
		final String last = "Doe";
		final double salary = 1000;
		
		Employee employee = new Employee(first, last, salary);
		final String first2 = "Jane";
		employee.setFirstName(first2);

		Field fFirst;
		try {
			fFirst = Employee.class.getDeclaredField("firstName");
			fFirst.setAccessible(true);
			assertEquals("setFirstName did not return the expected value", first2, fFirst.get(employee));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testSetLastName() {
		final String first = "John";
		final String last = "Doe";
		final double salary = 1000;
		
		Employee employee = new Employee(first, last, salary);
		final String last2 = "Darling";
		employee.setLastName(last2);

		Field fLast;
		try {
			fLast = Employee.class.getDeclaredField("lastName");
			fLast.setAccessible(true);
			assertEquals("setLastName did not return the expected value", last2, fLast.get(employee));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testSetMonthlySalaryBase() {
		final String first = "John";
		final String last = "Doe";
		final double salary = 1000;
		
		Employee employee = new Employee(first, last, salary);
		final double salary2 = 8675309;
		employee.setMonthlySalary(salary2);

		Field fSalary;
		try {
			fSalary = Employee.class.getDeclaredField("monthlySalary");
			fSalary.setAccessible(true);
			assertEquals("setMonthlySalary did not return the expected value", salary2, fSalary.get(employee));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testSetMonthlySalaryNegative() {
		final String first = "John";
		final String last = "Doe";
		final double salary = 1000;
		
		Employee employee = new Employee(first, last, salary);
		final double salary2 = -1000;
		employee.setMonthlySalary(salary2);

		Field fSalary;
		try {
			fSalary = Employee.class.getDeclaredField("monthlySalary");
			fSalary.setAccessible(true);
			assertEquals("setMonthlySalary did not return the expected value: " + salary, salary, fSalary.get(employee));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testSetMonthlySalaryZero() {
		final String first = "John";
		final String last = "Doe";
		final double salary = 1000;
		
		Employee employee = new Employee(first, last, salary);
		final double salary2 = 0;
		employee.setMonthlySalary(salary2);

		Field fSalary;
		try {
			fSalary = Employee.class.getDeclaredField("monthlySalary");
			fSalary.setAccessible(true);
			assertEquals("setMonthlySalary did not return the expected value: " + salary, salary, fSalary.get(employee));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testYearlySalaryOutputBen() {
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
		
		final double expectedInitialSalaryBen = 14814.72;
		
		String[] arr = {};
		EmployeeTest.main(arr);
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			
			/* FIRST LINE
			 */
			try {    // Skip to Ben's salary
				sc.skip("\\D+");
			} catch (Exception e) {
				fail("The program's output is non-conformant: descriptive text absent");
			}
			if (!sc.hasNextDouble()) {
				fail("The program's output is non-conformant: Ben's salary not present as expected");
			}
			final double bensSalary = sc.nextDouble();
			final double delta = expectedInitialSalaryBen/12 * .01;
			if (expectedInitialSalaryBen/12 - delta <= bensSalary && bensSalary <= expectedInitialSalaryBen/12 + delta) {
				fail ("The program's output is non-conformant: monthly salaries are being displayed (yearly salaries are required by the assignment prompt)");
			}
			assertEquals("The program's output is non-conformant: Ben's salary not as specified", expectedInitialSalaryBen, bensSalary, expectedInitialSalaryBen * .01);
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testRaiseOutput() {
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
		
		String[] arr = {};
		EmployeeTest.main(arr);
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", sc.hasNext(), true);
			sc.next();
			try {    // Skip to Ben's salary
				sc.skip("\\D+");
			} catch (Exception e) {
				fail("The program's output is non-conformant: last name and descriptive text absent");
			}
			if (!sc.hasNextDouble()) {
				fail("The program's output is non-conformant: Ben's salary not present as expected");
			}
			final double bensSalary = sc.nextDouble();
			
			/* SECOND LINE
			 */
			try {    // Skip to Paul's salary
				sc.skip("\\D+");
			} catch (Exception e) {
				fail("The program's output is non-conformant: descriptive text absent");
			}
			if (!sc.hasNextDouble()) {
				fail("The program's output is non-conformant: Paul's salary not present as expected");
			}
			final double paulsSalary = sc.nextDouble();
			
			/* FOURTH LINE
			 */
			try {    // Skip to Ben's raised salary
				sc.skip("\\D+");
			} catch (Exception e) {
				fail("The program's output is non-conformant: descriptive text absent");
			}
			if (!sc.hasNextDouble()) {
				fail("The program's output is non-conformant: Ben's raised salary not present as expected");
			}
			final double bensRaisedSalary = sc.nextDouble();
			assertEquals("The program's output is non-conformant: Ben's raised salary not as specified", bensSalary * 1.1, bensRaisedSalary, bensSalary * 1.1 * .01);
			
			/* FIFTH LINE
			 */
			try {    // Skip to Paul's raised salary
				sc.skip("\\D+");
			} catch (Exception e) {
				fail("The program's output is non-conformant: descriptive text absent");
			}
			if (!sc.hasNextDouble()) {
				fail("The program's output is non-conformant: Pauls's raised salary not present as expected");
			}
			final double paulsRaisedSalary = sc.nextDouble();
			assertEquals("The program's output is non-conformant: Paul's raised salary not as specified", paulsSalary * 1.1, paulsRaisedSalary, paulsSalary * 1.1 * .01);
			
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}

	public void testAttemptNegativeSalaryOutput() {
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
		
		String[] arr = {};
		EmployeeTest.main(arr);
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", sc.hasNext(), true);
			sc.next();
			try {    // Skip to Ben's salary
				sc.skip("\\D+");
			} catch (Exception e) {
				fail("The program's output is non-conformant: last name and descriptive text absent");
			}
			if (!sc.hasNextDouble()) {
				fail("The program's output is non-conformant: Ben's salary not present as expected");
			}
			sc.nextDouble();    // Read past Ben's salary
			
			/* SECOND LINE
			 */
			try {    // Skip to Paul's salary
				sc.skip("\\D+");
			} catch (Exception e) {
				fail("The program's output is non-conformant: descriptive text absent");
			}
			if (!sc.hasNextDouble()) {
				fail("The program's output is non-conformant: Paul's salary not present as expected");
			}
			sc.nextDouble();    // Read past Paul's salary
			
			/* FOURTH LINE
			 */
			try {    // Skip to Ben's raised salary
				sc.skip("\\D+");
			} catch (Exception e) {
				fail("The program's output is non-conformant: descriptive text absent");
			}
			if (!sc.hasNextDouble()) {
				fail("The program's output is non-conformant: Ben's raised salary not present as expected");
			}
			final double bensRaisedSalary = sc.nextDouble();
			
			/* FIFTH LINE
			 */
			try {    // Skip to Paul's raised salary
				sc.skip("\\D+");
			} catch (Exception e) {
				fail("The program's output is non-conformant: descriptive text absent");
			}
			if (!sc.hasNextDouble()) {
				fail("The program's output is non-conformant: Pauls's raised salary not present as expected");
			}
			sc.nextDouble();    // Read past Paul's raised salary
			
			/* SEVENTH LINE
			 */
			try {    // Skip to Ben's still non-negative salary
				sc.skip("\\D+");
			} catch (Exception e) {
				fail("The program's output is non-conformant: descriptive text absent");
			}
			if (!sc.hasNextDouble()) {
				fail("The program's output is non-conformant: Ben's raised salary not present as expected");
			}
			final double bensFinalSalary = sc.nextDouble();
			assertEquals("The program's output is non-conformant: Ben's decidedly non-negative salary not as specified", bensRaisedSalary, bensFinalSalary, bensRaisedSalary * .01);
			
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testEmployeeOutputFormat() {
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
		
		String[] arr = {};
		EmployeeTest.main(arr);
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", sc.hasNext(), true);
			String firstLine = sc.nextLine().toLowerCase();
			assertEquals("The program's output is non-conformant: first line does not contain \"Benjamin\"", true, firstLine.contains("benjamin"));
			assertEquals("The program's output is non-conformant: first line does not contain \"Bernanke\"", true, firstLine.contains("bernanke"));
			assertEquals("The program's output is non-conformant: first line does not contain \"Bernanke\"", true, firstLine.contains("salary"));
			assertEquals("The program's output is non-conformant: first line does not contain a numeric value (necessary to represent the yearly salary)", true, firstLine.contains("salary"));
			Scanner digitScan = new Scanner(firstLine);
			try {    // Skip to Ben's salary
				digitScan.skip("\\D+");
			} catch (Exception e) {
				// Squelched... we'll already have failed on one of the asserts above if the above line would throw an exception
			}
			if (!digitScan.hasNextDouble()) {
				fail("The program's output is non-conformant: Ben's salary not present as expected");
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
//	/* Personally I'd prefer to validate the output using this omnibus method... it'd make things more simple for me, but it wouldn't provide
//	 * as much granularity for partial credit. Still, your code should pass this test method; I just commented it out to avoid "double jeopardy" 
//	 */
//	public void testNominalOutput() {
//		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(capturedOut));
//		
//		final double expectedInitialSalaryBen = 14814.72;
//		final double expectedInitialSalaryPaul = 28148.04;
//		final double expectedPostRaiseSalaryBen = expectedInitialSalaryBen * 1.1;
//		final double expectedPostRaiseSalaryPaul = expectedInitialSalaryPaul * 1.1;
//		
//		String[] arr = {};
//		EmployeeTest.main(arr);
//		Scanner sc = new Scanner(capturedOut.toString());
//		try {
//			
//			/* FIRST LINE
//			 */
//			assertEquals("The program's output is non-conformant: no output was recorded", sc.hasNext(), true);
//			assertEquals("The program's output is non-conformant: first token is not \"Benjamin\"", "Benjamin", sc.next());
//			try {    // Skip to Ben's salary
//				sc.skip("\\D+");
//			} catch (Exception e) {
//				fail("The program's output is non-conformant: last name and descriptive text absent");
//			}
//			if (!sc.hasNextDouble()) {
//				fail("The program's output is non-conformant: Ben's salary not present as expected");
//			}
//			final double bensSalary = sc.nextDouble();
//			assertEquals("The program's output is non-conformant: Ben's salary not as specified", expectedInitialSalaryBen, bensSalary, expectedInitialSalaryBen * .01);
//			try {    // Skip to Paul's first name
//				sc.skip("\\W+");
//			} catch (Exception e) {
//				fail("The program's output is non-conformant: line-breaks not present as expected");
//			}
//			
//			/* SECOND LINE
//			 */
//			try {    // Skip to Paul's last name
//				sc.next();
//				assertEquals("The program's output is non-conformant: \"Volcker's\" last name not present where expected on line 2", "Volcker's", sc.next());
//			} catch (Exception e) {
//				fail("The program's output is non-conformant: \"Volcker's\" last name not present where expected on line 2");
//			}
//			try {    // Skip to Paul's salary
//				sc.skip("\\D+");
//			} catch (Exception e) {
//				fail("The program's output is non-conformant: descriptive text absent");
//			}
//			if (!sc.hasNextDouble()) {
//				fail("The program's output is non-conformant: Paul's salary not present as expected");
//			}
//			final double paulsSalary = sc.nextDouble();
//			assertEquals("The program's output is non-conformant: Paul's salary not as specified", expectedInitialSalaryPaul, paulsSalary, expectedInitialSalaryPaul * .01);
//			
//			/* FOURTH LINE
//			 */
//			try {    // Skip to Ben's raised salary
//				sc.skip("\\D+");
//			} catch (Exception e) {
//				fail("The program's output is non-conformant: descriptive text absent");
//			}
//			if (!sc.hasNextDouble()) {
//				fail("The program's output is non-conformant: Ben's raised salary not present as expected");
//			}
//			final double bensRaisedSalary = sc.nextDouble();
//			assertEquals("The program's output is non-conformant: Ben's raised salary not as specified", expectedPostRaiseSalaryBen, bensRaisedSalary, expectedPostRaiseSalaryBen * .01);
//			
//			/* FIFTH LINE
//			 */
//			try {    // Skip to Paul's raised salary
//				sc.skip("\\D+");
//			} catch (Exception e) {
//				fail("The program's output is non-conformant: descriptive text absent");
//			}
//			if (!sc.hasNextDouble()) {
//				fail("The program's output is non-conformant: Pauls's raised salary not present as expected");
//			}
//			final double paulsRaisedSalary = sc.nextDouble();
//			assertEquals("The program's output is non-conformant: Paul's raised salary not as specified", expectedPostRaiseSalaryPaul, paulsRaisedSalary, expectedPostRaiseSalaryPaul * .01);
//			
//			/* SEVENTH LINE
//			 */
//			try {    // Skip to Ben's still non-negative salary
//				sc.skip("\\D+");
//			} catch (Exception e) {
//				fail("The program's output is non-conformant: descriptive text absent");
//			}
//			if (!sc.hasNextDouble()) {
//				fail("The program's output is non-conformant: Ben's raised salary not present as expected");
//			}
//			final double bensFinalSalary = sc.nextDouble();
//			assertEquals("The program's output is non-conformant: Ben's decidedly non-negative salary not as specified", expectedPostRaiseSalaryBen, bensFinalSalary, expectedPostRaiseSalaryBen * .01);
//			
//		} catch (Exception e) {
//			assertThrowableTestFailure(e);
//		}
//	}
	
	/* method name retrieval code courtesy of: http://dev.kanngard.net/Permalinks/ID_20030114224837.html
	 */
	private void assertThrowableTestFailure(Throwable thrown) {
		StackTraceElement stackTraceElements[] =
            (new Throwable()).getStackTrace();
		fail(thrown.getClass().getName() + " encountered! Unable to successfully execute test: " + stackTraceElements[1].toString());
	}
}