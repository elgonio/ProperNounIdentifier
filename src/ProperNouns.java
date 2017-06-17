/*
  TODO: fix Unnecessary Spaces
        Dont Always Identify words at the start of a sentence as Proper Nouns
        Strip Punctuation in words like 'Latin:'
        Deal with apostrophes in words like Occam's
*/


import java.util.ArrayList;
import java.util.Scanner;

public class ProperNouns {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a Text:");
        String text = in.nextLine();

        ArrayList<String> properNouns = getProperNouns(text);

        System.out.println("Proper Nouns: ");
        for (String s : properNouns) {
            System.out.println(s);
        }
    }

    /*
    This Method Accepts a String and returns all proper nouns in that String
    */
    static public ArrayList<String> getProperNouns(String text) {
        // this just initializes an array of short words which are often used in nouns that are multiplr words long
        // it is done this way because it leads to simpler conditions later on and is more readable
        ArrayList<String> short_words = new ArrayList<String>();
        short_words.add("of");
        short_words.add("the");
        short_words.add("in");
        short_words.add("and");


        ArrayList<String> results = new ArrayList<String>();
        //text = text + " fin"; I will confess I have no idea what this line was supposed to do
        String[] words = text.split(" ");
        String currentNoun = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // The following block does not proper;y deal with the start of sentences
            if (Character.isUpperCase(word.charAt(0)) || (short_words.contains(word) && i < words.length-1)) {
                // The following line appends spaces before words incorrectly
                currentNoun = currentNoun + " " + word;

                // Occams Razor
                currentNoun = currentNoun.trim();
            } else {
                // this block saves the proper noun and prepares to find the next
                if (!currentNoun.equals("") && !short_words.contains(currentNoun)) {
                    results.add(currentNoun);
                }
                currentNoun = "";
            }
        }

        return results;
    }
}
