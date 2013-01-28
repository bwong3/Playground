//imports
import java.io.*;
import java.util.*;

public class scanFile_CommandLine{
	
	private static int addValues(String key, HashMap<String, Integer> map){
		return map.get(key);
	}
	
	private static void loadValues(HashMap<String, Integer> map){
		map.put("AC", 1);
		map.put("2C", 2);
		map.put("3C", 3);
		map.put("4C", 4);
		map.put("5C", 5);
		map.put("6C", 6);
		map.put("7C", 7);
		map.put("8C", 8);
		map.put("9C", 9);
		map.put("10C", 10);
		map.put("JC", 11);
		map.put("QC", 12);
		map.put("KC", 13);
		map.put("AD", 14);
		map.put("2D", 15);
		map.put("3D", 16);
		map.put("4D", 17);
		map.put("5D", 18);
		map.put("6D", 19);
		map.put("7D", 20);
		map.put("8D", 21);
		map.put("9D", 22);
		map.put("10D", 23);
		map.put("JD", 24);
		map.put("QD", 25);
		map.put("KD", 26);
		map.put("JA", 27);
		map.put("JB", 28);
	}
	
	private static void checkDeck(Scanner deckFile, LinkedList<Integer> list, HashMap<String, Integer> map){
		int count = 0;
		
		while (deckFile.hasNext()){
			String container = deckFile.next();
			
			//We need to ensure that only 2 jokers are within the deck along with diamonds and club suites
			if (container.matches("[J][AB]") || container.matches("[2-9|AJQK][CD]") || container.matches("10[CD]")){
				list.add(addValues(container, map));
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
	}
	
	private static void checkMessage(Scanner messageFile){
		while (messageFile.hasNext()){
			String container = messageFile.next();
			
			//The length of the message needs to be checked
			if (container.length() % 5 != 0){
				System.err.print("Error: Your message was not a multiple of 5 in length!.");
				System.exit(1);
			}
		}
	}
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException{
		keyStream derp = new keyStream();
		
		//Linked list brah
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		//Hashmap Shananigans
		HashMap<String, Integer> map = new HashMap<String, Integer>(28);
		loadValues(map);
		
		if (args.length != 2){
			System.out.print("Usage: java Program 1, takes in 2 files, the first being a deck file, while the second contains" +
					" the message. The program then encrypts the message.");
			System.exit(1);
		}
		else {
			//Have to deal with the first file
			File file1 = new File(args[0]);
			Scanner deckFile = new Scanner(file1);
			
			checkDeck(deckFile, list, map);
			
			//The second file needs to be dealt with now
			File file2 = new File(args[1]);
			Scanner messageFile = new Scanner(file2);
			
			checkMessage(messageFile);
		}
		
		derp.moveJokerA(list);
		
		derp.moveJokerB(list);
	
		derp.tripleCut(list);
		
		derp.countDown(list);
		
		System.out.print(derp.grabKeyStream(list));
	}
}