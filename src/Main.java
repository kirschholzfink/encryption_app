
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
		
		System.out.println("Hallo! Falls Sie diese Datei ausführen möchten, habe ich die Beispieldatei Gedicht.txt beigefügt.");
		System.out.println("Die Qualität einer Chiffrierung ist maßgeblich von den gewählten Parametern abhängig.");
		System.out.println("Wenn Sie möchten, könnten Sie diese hier nutzen:");
		System.out.println("a: 421");
		System.out.println("b: 54,773");
		System.out.println("m: 259,200");
		System.out.println("Schlüssel: z.B. 3");
		System.out.println("Um eine chiffrierte Datei zu dechiffrieren, geben Sie diese Parameter einfach erneut ein.\n");

		Chiffrierung chiff = new Chiffrierung();
		chiff.execute();

	}
}
