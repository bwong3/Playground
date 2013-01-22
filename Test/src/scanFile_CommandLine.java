//imports
import java.io.*;
import java.nio.*;
import java.util.*;

public class scanFile_CommandLine{
	public static void main(String[] args) throws FileNotFoundException{
		if (args.length != 2){
			System.out.print("Usage: java Program 1, takes in 2 files, 1 being a deck, while the other contains" +
					"the message. The program then encrypts the message.");
			System.exit(1);
		}
		else {
			File file1 = new File(args[0]);
			Scanner file = new Scanner(file1);
			
			while (file.hasNext()){
				if (file.next().matches("[AJQK2-9][ABCD]") || file.next().matches("10[CD]")){
					//DO SOMETHING
					System.out.println(file.next());
				}
				else {
					System.out.print("Error: Deck file does not have proper contents. It must only have " +
							"diamonds and clubs as suits. Also it can only contain 2 jokers.");
				}
			}
		}
		
	}
}