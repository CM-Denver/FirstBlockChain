package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		ArrayList<Block> blockChain = new ArrayList<Block>();
		
		Block genesisBlock = new Block("0", "Genesis Block");
		Block secondBlock = new Block(genesisBlock.hash, "Second Block");
		Block thirdBlock = new Block(secondBlock.hash, "Third Block");
		Block fourthBlock = new Block(thirdBlock.hash, "Fourth Block");
		blockChain.add(genesisBlock);
		blockChain.add(secondBlock);
		blockChain.add(thirdBlock);
		blockChain.add(fourthBlock);
		
		for (int i = 0; i < blockChain.size(); i ++) {
			Block block = blockChain.get(i);
			System.out.println("Previous Hash: | " + block.previousHash + " | Content: | " + block.data + " | Hash: | " + block.hash);
		}
		
		System.out.println("BlockChain is Valid: | " + BlockMethods.isBlockValid(blockChain));

	}

}
