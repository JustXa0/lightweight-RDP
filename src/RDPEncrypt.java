import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


public class RDPEncrypt {
	
	
	
	SecretKey secretKey;
	
		ObjectInputStream in;
	{		
		try {
			in = new ObjectInputStream(new FileInputStream("secret.key"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		try {
			secretKey = (SecretKey) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String Encrypt(String text) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String unencryptedString = text;
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte [] unencryptedByte = unencryptedString.getBytes();
		byte [] encryptedByte = cipher.doFinal(unencryptedByte);
		String encryptedString = new String(encryptedByte);
		return encryptedString;
		
		
	}
	
	public String Decrypt(String text) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String encryptedString = text;
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte [] encryptedByte = encryptedString.getBytes();
		byte [] decryptedByte = cipher.doFinal(encryptedByte);
		String decryptedString = new String(decryptedByte);
		return decryptedString;
	}
}
