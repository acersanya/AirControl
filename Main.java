package tsd.crypto.algoritm;

import java.io.UTFDataFormatException;
import java.nio.charset.Charset;

public class Main {

	private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			String textClar = "CRIPTEAZA ASTA";
			//poligram
			System.out.println("Text clar: "+textClar);
			String encrypt = Poligram.encrypt(textClar);
			System.out.println("Text criptat poligramic: "+encrypt);
			String decrypt = Poligram.decrypt(encrypt);
			System.out.println("Text anterior descifrat: "+decrypt);
			System.out.println("------------------");
			//polialfa
			String textClarPolialfa = "SUBSTITUTIE POLIALFABETICA";
			System.out.println("Text clar: "+textClarPolialfa);
			encrypt = Polialpha.encrypt("ACADEMIE",textClarPolialfa);
			System.out.println("Text criptat polialfabetic: "+encrypt);
			decrypt = Polialpha.decrypt("ACADEMIE",encrypt);
			System.out.println("Text anterior decriptat: "+decrypt);
			System.out.println("------------------");
			
			textClar = "Algoritmul de criptare DES";
			//DES
			String k = "5qw8sd4h";
			System.out.println("Text clar: "+textClar);
			byte[] enc = DES.encrypt(textClar.getBytes(), k.getBytes());
			System.out.println("Text criptat DES: "+new String(enc));

			byte[] dec = DES.decrypt(enc, k.getBytes());
			System.out.println("Text decriptat DES: "+new String(dec));
			System.out.println("------------------");
			
			
			textClar = "Algoritmul de criptare TripleDES";
			//Triple DES
			byte[][] keys = {
					"lq8z56cm".getBytes(),"pe7slm95".getBytes(),"oqps58d5".getBytes()
			};
			System.out.println("Text clar: "+textClar);
			enc = DES.TripleDES_Encrypt(textClar.getBytes(), keys);
			System.out.println("Text criptat Triple DES: "+new String(enc));
			dec = DES.TripleDES_Decrypt(enc, keys);
			System.out.println("Text decriptat Triple DES: "+new String(dec));
			System.out.println("------------------");
			
			textClar = "Algoritmul de criptare RC6";
			
			//RC6------------------
			System.out.println("Text clar: "+textClar);
			enc = RC6.encrypt(textClar.getBytes(), "123456789abcdefg".getBytes());
			System.out.println("Text criptat RC6: "+new String(enc));
			dec = RC6.decrypt(enc, "123456789abcdefg".getBytes());
			System.out.println("Text decriptat RC6: "+new String(dec));
			
			System.out.println("------------------");
			
			textClar = "Algoritmul de criptare AES";
			//AES
			k = "1a25s8fe5dsg65ad";
			System.out.println("Text clar: "+textClar);
			enc = AES.encrypt(textClar.getBytes(), k.getBytes());
			System.out.println("Text criptat AES: "+new String(enc));

			dec = AES.decrypt(enc, k.getBytes());
			System.out.println("Text decriptat AES: "+new String(dec));
			System.out.println("------------------");
			
			textClar = "Algoritmul de criptare MARS";
			//MARS
			k = "1d58as6toa6s5752";
			System.out.println("Text clar: "+textClar);
			enc = MARS.encrypt(textClar.getBytes(), k.getBytes());
			System.out.println("Text criptat MARS: "+new String(enc));

			dec = MARS.decrypt(enc, k.getBytes());
			System.out.println("Text decriptat MARS: "+new String(dec));
			System.out.println("------------------");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
