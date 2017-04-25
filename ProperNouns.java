/*
  TODO: fix Unnecessary Spaces
        Dont Always Identify words at the start of a sentence as Proper Nouns
        Make considerations for phrases that are nouns e.g Keeper of the Light
*/


import java.util.ArrayList;
import java.util.Scanner;

public class ProperNouns
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Input a Text:");
    String text = in.nextLine();

    ArrayList<String> properNouns = getProperNouns(text);

    for (String s : properNouns)
    {
      System.out.println(s);
    }
  }

  /*
  This Method Accepts a String and returns all proper nouns in that String
  */
  static public ArrayList<String> getProperNouns(String text)
  {
    ArrayList<String> results = new ArrayList<String>();
    text = text + " fin";
    String[] words = text.split(" ");
    String currentNoun = "";

    for (int i = 0 ; i < words.length  ; i++)
    {
      String word = words[i];

      // The following block does not proper;y deal with the start of sentences
      if(Character.isUpperCase(word.charAt(0)))
      {
        // The following line appends spaces before words incorrectly
        currentNoun = currentNoun + " " + word;
      }else
      {
        if (!currentNoun.equals(""))
        {
          results.add(currentNoun);
        }
        currentNoun = "";
      }
    }

    return results;
  }
}
