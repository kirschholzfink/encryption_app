//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//
//public class Zeile {
//
//	private String lineAsString;
////	private byte[] lineAsBytes;
//	private int finalIndex;
//
//	public Zeile(String lineAsString, int finalIndex) {
//		this.lineAsString = lineAsString;
////		this.lineAsBytes = lineAsBytes;
//		this.finalIndex = 0;
//	}
//
////	public int getFinalIndex() {
////		return finalIndex;
////	}
//
////	public void setFinalIndex(int finalIndex) {
////		this.finalIndex = finalIndex;
////	}
//
//	public byte[] stringToByte() {
////		byte[] array = this.lineAsString.getBytes();
////		byte[] array = this.lineAsString.getBytes(Charset.forName("Cp1252"));
//		byte[] array = this.lineAsString.getBytes(StandardCharsets.ISO_8859_1);
//		return array;
//	}
//
//	public String bytesToString(byte[] outputArray) {
////		String result = new String(outputArray);
////		String result = new String(outputArray, Charset.forName("Cp1252"));
////		String result = new String(outputArray, Charset.forName("UTF-8"));
//		String result = new String(outputArray, StandardCharsets.ISO_8859_1);
//		return result;
//	}
//
//	public String toString() {
//		return this.lineAsString;
//	}
//}
