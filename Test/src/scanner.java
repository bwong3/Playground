import java.util.*;

public class scanner {
	public static void main(String[] args){
		//This is the scanner info
		Scanner sc = new Scanner(System.in);
		int shot;
		int x = 0;
		int remainder = 10;
		
		System.out.print("What did you shoot in this frame: ");
		
		do {
			while (!sc.hasNextInt()){
				System.out.println("That is not valid! Try again.\n");
				System.out.print("Enter roll: ");
				sc.next();
			}
			shot = sc.nextInt();
			if (shot > 10 || shot < 0 || shot > remainder){
				System.out.println("That is not valid! Try again.\n");
				System.out.print("Enter roll: ");
			}
		} while (shot > 10 || shot < 0 || shot > remainder);
	
		System.out.println("");
		System.out.println("Done!");
	}
}