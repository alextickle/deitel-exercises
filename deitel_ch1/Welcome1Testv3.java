package java_I;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;


public class Welcome1Testv3 extends TestCase {
	public static String newline = System.getProperty("line.separator");
	
	public void testHelloWorld() {
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
		
		String[] arr = {};
		Welcome1.main(arr);
		assertEquals("ERROR: Non-conformant output!", "Welcome to Java Programming!" + newline, capturedOut.toString());
	}
}
