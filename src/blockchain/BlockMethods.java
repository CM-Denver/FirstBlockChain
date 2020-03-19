package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class BlockMethods {

	public static String sha256(String plainText) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] sha256Hash = digest.digest(plainText.getBytes("UTF-8"));
		
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < sha256Hash.length; i ++) {
			String hex = Integer.toHexString(0xff & sha256Hash[i]);
			if  (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		
		return hexString.toString();
	}
	
	public static boolean isBlockValid(ArrayList<Block> blockChain) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		int height = blockChain.size();
		
		boolean valid = true;
		
		for (int i = height - 1; i > 0; i--) {
			Block current = blockChain.get(i);
			Block previous = blockChain.get(i - 1);
			//Confirms the previous block's hash is equal to the stated previous hash:
			if (previous.hash != current.previousHash) {
				valid = false;
			}
			//Checks if hashed content (previousHash + data) of block is equal to block's stated hash:
			if (current.hash.equals(sha256(current.previousHash + current.data)) == false) {
				valid = false;
			}
		}
		
		return valid;
	}
	
}
