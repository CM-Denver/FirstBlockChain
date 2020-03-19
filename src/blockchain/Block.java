package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	
	public String data;
	public String previousHash;
	public String hash;

	public Block(String previousHash, String data) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		this.previousHash = previousHash;
		this.data = data;
		this.hash = BlockMethods.sha256(previousHash + data);
	}
}
