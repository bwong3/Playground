import java.util.LinkedList;


public class keyStream {
	public keyStream(){
		
	}
	
	public static void tripleCut(LinkedList<Integer> list){
		int indexA = list.indexOf(27);
		int indexB = list.indexOf(28);
		
		if (indexA > indexB){
			int[] firstCut = new int[indexB];
			int i = 0;
			
			while (i < indexB){
				firstCut[i] = list.get(i);
				System.out.print(firstCut[i] + " ");
				i++;
			}
			
			int[] secondCut = new int[28 - indexA];
			
			System.out.println();
			i = indexA + 1;
			int j = 0;
			while (i < 28){
				secondCut[j] = list.get(i);
				System.out.print(secondCut[j] + " ");
				i++;
				j++;
			}
			
			System.out.println();
			int[] remainder = new int [indexA - indexB + 1];
			i = indexB;
			j = 0;
			while (i < indexA+1){
				remainder[j] = list.get(i);
				System.out.print(remainder[j] + " ");
				i++;
				j++;
			}
			
			System.out.println();
			
			//Time to put it all together
			j = 0;
			i = 0;
			while(j < secondCut.length-1){
				list.set(i, secondCut[j]);
				System.out.print(list.get(i) + " ");
				i++;
				j++;
			}
			
			j = 0;
			while(j < remainder.length){
				list.set(i, remainder[j]);
				System.out.print(list.get(i) + " ");
				i++;
				j++;
			}
			
			j = 0;
			while(j < firstCut.length){
				list.set(i, firstCut[j]);
				System.out.print(list.get(i) + " ");
				i++;
				j++;
			}
		}
		else{
			
		}
	}
	
	public static void moveJokerA(LinkedList<Integer> list){
		//We must move the JA first!
		int jokerA = list.indexOf(27);
		
		//If the joker is in the last spot of the deck
		if (jokerA == 27){
			//Grab the first element and place it into a temp var 
			//so it can be replaced by the joker
			int temp = list.getFirst();
			list.set(0, 27);
			list.set(27, temp);
		}
		else {
			int temp = list.get(jokerA+1);
			list.set(jokerA+1, 27);
			list.set(jokerA, temp);
		}
	}
	
	public static void moveJokerB(LinkedList<Integer> list){
		//Now to move JB
		int jokerB = list.indexOf(28);
		
		if (jokerB == 27){
			//Set the Joker to the front of the deck
			int temp = list.get(0);
			list.set(0, 28);
			list.set(27, temp);
			
			//Move the Joker to the second spot of the deck
			temp = list.get(1);
			list.set(1, 28);
			list.set(0, temp);
		}
		else if (jokerB == 26){
			int temp = list.get(jokerB+1);
			//Set the JB to the last spot
			list.set(27, 28);
			list.set(26, temp);
			
			//Place JB at the top of the deck
			temp = list.get(0);
			list.set(0, 28);
			list.set(27, temp);
		}
		else{
			//First move
			int temp = list.get(jokerB+1);
			list.set(jokerB+1, 28);
			list.set(jokerB, temp);
			
			//Second move
			temp = list.get(jokerB+2);
			list.set(jokerB+2, 28);
			list.set(jokerB+1, temp);
		}
	}
}
