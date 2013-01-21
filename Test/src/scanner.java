import java.util.*;

public class scanner {
	public static void main(String[] args){
		//Global vars
		int [][] score = new int[10][3];
		int currentFrame = 9;
		int index = 0;
		
		//This is the scanner info
		Scanner sc = new Scanner(System.in);
		int shot;
		int x = 0;
		int remainder = 10;
		
		//This while loop takes in the user input, and if valid will insert the score into the frame[][] and
		//the scoreBoard array
		//I am using x < 3 because there can be 3 shots if it is on the 10th frame
		while (x < 3){
			System.out.print("What did you shoot in this frame: ");
			while (!sc.hasNextInt()){
				System.out.println();
				System.out.println("That is not valid! Try again.\n");
				System.out.print("What did you shoot in this frame: ");
				sc.next();
			}
			shot = sc.nextInt();
			System.out.println("");
			
			//This deals with frames 1-9
			if (currentFrame <= 8){
				//First index of the frame
				if (index == 0){
					//Ensuring it is a proper first throw
					if (shot > 10 || shot < 0)
						System.out.println("That is not valid! Try again.\n");
					//Logic for if it is a proper shot
					else{
						score[currentFrame][index] = shot;
						//Strike and the frame is over
						if (shot == 10){
							currentFrame++;
							x = 3;
						}
						//A second shot is needed for the frame since it was not a strike
						else{
							index++;
							x = 2;
							remainder -= shot;
						}
					}
				}
				
				//Second shot of the frame
				else{
					//Ensuring the shot is valid
					if (shot > remainder || shot < 0){
						System.out.println("That is not valid! Try again.\n");
					}
					//Frame will now be over, so it will move to the next frame along with making index = 0
					else{
						score[currentFrame][index] = shot;
						x = 3;
						currentFrame++;
						index = 0;
					}
				}
			}
			
			//For the 10th frame
			else{
				//this logic is dealing with the first shot
				if (index == 0){
					//Ensuring it is a proper first throw
					if (shot > 10 || shot < 0)
						System.out.println("That is not valid! Try again.\n");
					else{
						score[currentFrame][index] = shot;
						index = 1;
						//STRIKE
						if (shot == 10)
							//I NEED TO INSERT INFO FOR SCOREBOARD
							index = 1;
						//Anything else
						else
							remainder -= shot;
					}
				}
				
				//Second shot of the 10th frame
				else if (index == 1){
					//Ensuring it is a valid shot
					if (shot > remainder || shot < 0){
						System.out.println("That is not valid! Try again.\n");
					}
					else{
						score[currentFrame][index] = shot;
						index = 2;
						x = 2;
					
						//If the previous throw was a strike
						if (remainder == 10){
							if (shot == 10){
								//herp derp do some scoreBoard manipulation
							}
							else{
								remainder -= shot;
							}
						}
						else{
							//SPARE!!!!1
							if (shot - remainder == 0){
								//Some scoreBoard manipulation
								remainder = 10;
							}
							//Frame is over
							else{
								currentFrame++;
								index = 0;
								x = 3;
							}
						}
					}
				}
				
				//Final throw of the 10th frame
				else{
					//Ensuring it is a valid shot
					if (shot > remainder || shot < 0){
						System.out.println("That is not valid! Try again.\n");
					}
					
					else{
						score[currentFrame][index] = shot;
						index = 0;
						x = 3;
					}
				}
			}
		}
	}
}