//imports
import java.io.*;
import java.util.*;

public class scanFile_CommandLine{
	public static void main(String[] args) throws FileNotFoundException{
		if (args.length != 2){
			System.out.print("Usage: java Program 1, takes in 2 files, the first being a deck file, while the second contains" +
					"the message. The program then encrypts the message.");
			System.exit(1);
		}
		else {
			//Have to deal with the first file
			File file1 = new File(args[0]);
			Scanner deckFile = new Scanner(file1);
			
			int count = 0;
			
			while (deckFile.hasNext()){
				String container = deckFile.next();
				
				//We need to ensure that only 2 jokers are within the deck along with diamonds and club suites
				if (container.matches("[J][AB]") || container.matches("[2-9|AJQK][CD]") || container.matches("10[CD]")){
					count++;
				}
				//Ensure there are no other suites in the deck file
				else if (container.matches("[2-9|AJQK][HS]") || container.matches("10[HS]")){
					System.out.print("Error: You have a heart or spade as your suite. This program only " +
							"accepts diamonds and clubs.");
					System.exit(1);
				}
				//Only two jokers are allowed!
				else if (container.matches("[J][1-9|A-Z|a-z]")){
					System.out.print("Error: You have too many jokers in your deck file! This program only " +
							"accepts 2 joker cards.");
					System.exit(1);
				}
				else {
						System.out.print("Error: You contain something that the program cannot identify. Ensure there " +
								"are only 28 total cards: 2 joker cards (ex: JA and JB), and all cards in the diamond and " +
								"club suites (ex: 4D).");
						System.exit(1);
				}				
			}
			
			//wrong number of cards
			if (count != 28){
				System.out.print("Error: Your deck file does not contain the correct amount of cards. There should " +
						"only be 28 cards.");
				System.exit(1);
			}
			
			//The second file needs to be dealt with now
			File file2 = new File(args[1]);
			Scanner messageFile = new Scanner(file2);
			
			while (messageFile.hasNext()){
				String container = messageFile.next();
				
				//The length of the message needs to be checked
				if (container.length() % 5 != 0){
					System.out.print("Error: Your message was not a multiple of 5 in length!.");
					System.exit(1);
				}
			}
		}
		
	}
}