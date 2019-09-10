import java.util.Scanner;
import java.io.*;

/*
 * This class implements a spell checker application. 
 * This class requires a proper implementation to the StirngSet class.
 */
public class SpellChecker {

  public static void main(String [] args) {

    File f = new File("dictionary");
    
    try {
      Scanner sk = new Scanner(f);
        
      StringSet x = new StringSet();
    
      // Read in the entire dictionary...
      while (sk.hasNext()) {
        String word = sk.next();
        x.insert(word);      
      }
      System.out.println("Dicitonary loaded...");
     
      sk = new Scanner(System.in);
      
      // Keep suggesting alternatives as long as the user makes an input.
      while (sk.hasNext()) {
        String word = sk.next();
        if (x.find(word))
	  			System.out.println(word + " is correct.");
        else {
	  			System.out.println("Suggesting alternatives ...");
          // TODO: Code to do the spell checker. Look into the StringSet for all possible alternatives of the input word mis-spelled by one character.
	  			StringSet suggestions = new StringSet();
	  			int sameCount = 0;
	  			for(int i = 0; i < x.size; i++)  //goes through each table of dictionary
	  			{
	  				for(StringNode iter = x.table[i]; iter != null; iter = iter.getNext()) //goes through each chain in table
	  				{		
		  				sameCount = 0;

	  					for(int j = 0; j < word.length(); j++) //goes through each letter of word
	  					{ 
	  						if(iter.getKey().length() == word.length())
	  						{
	  							if(iter.getKey().charAt(j) == word.charAt(j) &&
	  								word.length() == iter.getKey().length()) //checks each character of the words for equality
	  							{
	  								sameCount++; //if char is equal add to count
	  							}
	  						}
	  								
	  					}
	  					if(word.length() == iter.getKey().length())
	  					{
	  						if(sameCount == (word.length() - 1)) //checks if the count is one less meaning one letter difference
	  		  				{
	  		  					suggestions.insert(iter.getKey());
	  		  				}
	  					}
	  				}
	  			}
	  			suggestions.print();
	  		}
		}
 
			
    } catch (FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
    } 
  } 
}
