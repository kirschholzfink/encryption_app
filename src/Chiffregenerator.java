
import java.nio.ByteBuffer;
/**
 * Generiert eine Schlüssel-Byte-Sequenz.
 * (De-)Chiffriert einen Byte-Array auf Grundlage bestimmter Parameter.
 * @author jana
 *
 */
public class Chiffregenerator {
	/**
	 * Parameter a.
	 */
	private double a;
	/**
	 * Parameter b.
	 */
	private double b;
	/**
	 * Parameter m.
	 */
	private double m;
	/**
	 * Durch Nutzereingabe abgefragter Schlüssel.
	 */
	private int initialKey;
	/**
	 * Byte-Array aus generierten Schlüssel-Bytes.
	 */
	private byte[] keySequence;
	
/**
 * Konstruktor der Klasse Chiffregenerator.
 * Fragt zur Verschlüsselung benötigte Eingangsparameter ab.
 * @param a
 * @param b
 * @param m
 * @param initialKey
 */
	public Chiffregenerator(double a, double b, double m, int initialKey) {
		this.a = a;
		this.b = b;
		this.m = m;
		this.initialKey = initialKey;

	}
/**
 * Generiert eine Byte-Schlüssel-Sequenz zur späteren XOR-(De-)Chiffrierung.
 * Initialisiert Byte-Array auf Grundlage der Länge des Input-Arrays.
 * Variable nextAvailableIndex speichert Index des nächsten leeren Feldes in diesem Array.
 * double-Zahl wird auf Grundlage der Formel (a * initialKey + b) mod m generiert und
 * in Absolute-Value-Bytes (8 Bytes pro Double) in Array eingefügt.
 * Der letzte Absolute-Value-Byte der generierten Double-Zahl wird als neuer Key (keyByte) gesetzt.
 * Dies wird wiederholt, bis der Array vollständig gefüllt ist.
 * Der generierte Byte-Array wird als keySequence-Attribut des Objektes gespeichert.
 * @param length
 */
	public void createSequence(int inputLength) {
		byte[] byteSequence = new byte[inputLength];
		int nextAvailableIndex = 0;
		double keyByte = (double) initialKey;
		for (int i = 0; i < byteSequence.length/8; i++) {
			double rand = (this.a * keyByte + this.b) % this.m;
			byte[] randAsBytes = ByteBuffer.allocate(8).putDouble(rand).array();
			for (int n = 0; n < randAsBytes.length; n++) {
				byteSequence[nextAvailableIndex + n] = (byte) Math.abs(randAsBytes[n]);
			}
			nextAvailableIndex = nextAvailableIndex + randAsBytes.length;
			keyByte = (double) Math.abs(randAsBytes[7]);
		}
		this.keySequence = byteSequence;
	}


/**
 * Generiert aus der XOR-Verknüpfung eines input-Arrays mit der generierten byteSequence output-Array.
 * @param inputArray
 * @return
 */
	public byte[] createXOR(byte[] inputArray) {
		byte[] outputArray = new byte[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			byte originalByte = inputArray[i];
			byte keyByte = this.keySequence[i];
			int originAsInt = (int) originalByte;
			int keyAsInt = (int) keyByte;
			int xor = originAsInt ^ keyAsInt;
			byte chiffre = (byte) xor;
			outputArray[i] = chiffre;
		}
		return outputArray;
	}
}
