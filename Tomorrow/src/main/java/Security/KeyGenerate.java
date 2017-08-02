package Security;

import java.security.NoSuchAlgorithmException;

import java.io.*;

import static org.apache.commons.codec.binary.Hex.*;
import static org.apache.commons.io.FileUtils.*;

import javax.crypto.*;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyGenerate {
	
	private static File file = new File("keygenerate.txt");
	
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException{
		SecretKey secret = generateKey();
		saveKey(secret);
	}
	
	public static SecretKey generateKey() throws NoSuchAlgorithmException{
		KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
		return keygenerator.generateKey();
	}
	
	public static void saveKey(SecretKey key) throws IOException
	{
	    char[] hex = encodeHex(key.getEncoded());
	    writeStringToFile(file, String.valueOf(hex));
	}

}
