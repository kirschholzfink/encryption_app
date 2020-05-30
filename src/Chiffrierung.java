import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Controller-Class: Fragt Namen der In- und Outputdateien ab.
 * Einlesen und Ausgeben der Datei. 
 * Speichert In- und Output in Byte-Arrays.
 * Greift auf eine Instanz der Klasse Chiffregenerator zu, um eine Datei zu chiffrieren.
 * 
 * @author jana
 *
 */
public class Chiffrierung {
	/**
	 * Name der Datei, die (de-)chiffriert werden soll.
	 */
	private String inputFileName;
	/**
	 * Name der Datei, in der der (de-)chiffrierte Text ausgegeben werden soll.
	 */
	private String outputFileName;
	/**
	 * Der aus der Datei eigelesene Input als Byte-Array.
	 */
	private byte[] input;
	/**
	 * Der (de-)chiffrierte Output als Byte-Array.
	 */
	private byte[] output;
	/**
	 * Instanz der Klasse Chiffregenerator, der eingelesenen Text (de-)chiffriert.
	 */
	private Chiffregenerator chiffreGen;


	/**
	 * Konstruktor der Klasse Chiffrierung.
	 * Fragt inputFileName und outputFileName durch Nutzereingabe ab (mit Exception-Handling).
	 * Fragt Parameter für den Chiffregenerator ab (mit Exception Handling).
	 * Instanziiert ein Objekt der Klasse Chiffregenerator auf Grundlage dieser Parameter.
	 */
	public Chiffrierung() {

		Scanner scan = new Scanner(System.in);
		boolean acceptInput = false;
		while (!acceptInput) {
			acceptInput = true;
			try {
				System.out.println("Name der Datei, die (de-)chiffriert werden soll:");
				this.inputFileName = scan.nextLine();
				System.out.println("Name der Datei, in die der Output geschrieben werden soll:");
				this.outputFileName = scan.nextLine();
			} catch (Exception e) {
				System.out.println("Da hat etwas nicht funktioniert. Probiere es erneut.");
				acceptInput = false;
				scan.nextLine();
			}
		}

		System.out.println("Eingabe der Parameter:");
		boolean acceptInput1 = false;
		while (!acceptInput1) {
			acceptInput1 = true;
			try {
				System.out.println("a (double):");
				double a = scan.nextDouble();
				System.out.println("b (double):");
				double b = scan.nextDouble();
				System.out.println("m (double):");
				double m = scan.nextDouble();
				System.out.println("Schlüssel (int):");
				int initialKey = scan.nextInt();
				chiffreGen = new Chiffregenerator(a, b, m, initialKey);

			} catch (Exception e) {
				System.out.println("Da ist etwas schiefgelaufen. Probiere es erneut.");
				acceptInput1 = false;
				scan.nextLine();
			}
		}
		scan.close();

	}

	/**
	 * Einlesen des InputFiles als Byte-Array mit der Klasse FileInputStream.
	 * Speichert eingelesenen Byte-Array im input[]-Attribut.
	 * 
	 * @throws IOException
	 */
	public void dateiEinlesen() throws IOException {

		File file = new File(this.inputFileName);
		FileInputStream fin = new FileInputStream(file);
		try {

			this.input = new byte[(int) file.length()];
			fin.read(input);
		} catch (FileNotFoundException e) {
			System.out.println("Datei konnte nicht gefunden werden.");
		} catch (IOException ioe) {
			System.out.println("Etwas hat nicht funktioniert.");
		} finally {

			fin.close();

		}

	}

	/**
	 * Gibt den den output[]-ByteArray über FileOutputStream aus.
	 * 
	 * @throws IOException
	 */
	public void dateiAusgeben() throws IOException {
		try (FileOutputStream outputStream = new FileOutputStream(this.outputFileName)) {
			outputStream.write(this.output);
		} catch (FileNotFoundException nfE) {
			System.err.println("Die Datei konnte nicht gefunden werden.");
		} catch (IOException ioEx) {
			System.err.println("Da ist etwas schiefgelaufen.");
		}
	}

	/**
	 * Führt dateiEinlesen() aus.
	 * Ruft Methode createSequence des Chiffregenerators auf.
	 * Ruft createXOR-Methode des Chiffregenerators auf.
	 * Übergibt input[]-Array.
	 * Führt dateiAusgeben() aus
	 * 
	 * @throws IOException
	 */
	public void execute() throws IOException {
		this.dateiEinlesen();
		this.chiffreGen.createSequence(this.input.length);
		this.output = this.chiffreGen.createXOR(this.input);
		this.dateiAusgeben();
	}

}
