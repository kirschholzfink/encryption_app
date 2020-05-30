
/**
 * Eine Instanz der Klasse Chiffrierung wird erzeugt.
 * Mit der execute()-Methode wird die Chiffrierung ausgeführt.
 */
import java.io.IOException;

public class Main {
	/**
	 * Main-Methode dieser Anwendung.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {

		System.out.println("This app encrypts as well as decrypts data.\n");

		System.out.println("You will now be prompted to enter parameters used to encrypt or decrypt your file data.");

		System.out.println(
				"In order to decrypt a file that has previously been encrypted with a set of parameters, the same parameters should be used.");

		System.out.println(
				"As encryption quality depends significantly on the complexity of your parameters, if you'd like to give it a quick try, here's my recommendation:\n");

		System.out.println("a : 421");

		System.out.println("b : 54,773");

		System.out.println("m : 259,200");

		System.out.println("key : e.g. 3\n");
		
		System.out.println("As a sample file, I've included 'Gedicht.txt'.");
		System.out.println("The program will now be executed :-).\n");

		Chiffrierung chiff = new Chiffrierung();
		chiff.execute();

	}
}
