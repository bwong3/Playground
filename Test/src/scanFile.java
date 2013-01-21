//imports
import java.io.*;
import java.nio.*;
import java.util.*;

public class scanFile{
	public static void main(String[] args) throws FileNotFoundException{
		File someFile = new File("info.txt");
		Scanner file = new Scanner(someFile);
		
		while(file.hasNext()){
			System.out.println(file.nextLine());
		}
		
	}
}