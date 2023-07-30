import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;


public class WordChains{
  ///quicksort idea, make list of words and order them, then check for farthest away from start with only one change. (nearest to goal word)
  public static void main(String[] args){
    ArrayList<String> wordList = null;

    ///TODO: optimize and adjust logic.

    if(args.length != 3){
      System.out.println("Missing required parameters: dictionary, starting word, goal word.");
      System.exit(0);
    }

    if(checkFiletype(args[0])){
      wordList = getCustomDictionary(args[0]);
      Collections.sort(wordList);
    }else{
      System.out.println("Incorrect Dictionary Filetype.");
    }

    int firstIndex = findWordPosition(wordList, args[1]);
    if(firstIndex == -1){
      System.out.printf("Could not find %s in dictionary provided.",args[1]);
      System.exit(0);
    }

    int goalIndex = findWordPosition(wordList, args[2]);
    if(goalIndex == -1){
      System.out.printf("Could not find %s in dictionary provided.",args[2]);
      System.exit(0);
    }

    /// Confirm that the "goal word" comes later than start word in dictionary order.
    if(firstIndex < goalIndex){
      printChain(buildChain(wordList, firstIndex, goalIndex));
    }
    else{
      /// else, make the goal word our first word
      printChain(buildChain(wordList, goalIndex, firstIndex));
    }
  }

  private static void printChain(ArrayList<String> wordChain){
    for (String word : wordChain) {
      System.out.println(word);
    }
  }


  private static ArrayList<String> buildChain(ArrayList<String> dictionary, int startPos, int goalPos){
    ArrayList<String> wordChain = new ArrayList<String>();
    int currentPos = startPos;
    boolean chainComplete = false;

    wordChain.add(dictionary.get(currentPos));

    while(!chainComplete){

      currentPos = findNextWordPos(dictionary, currentPos, goalPos);

      if(currentPos == -1){
        System.out.println("Could not create word chain with provided dictionary.");
        System.exit(0);
      }

      wordChain.add(dictionary.get(currentPos));

      if(currentPos == goalPos){
        chainComplete = true;
        continue;
      }
    }

    return wordChain;
  }

  private static int findNextWordPos(ArrayList<String> dictionary, int currentPos, int goalPos){

    String dummyWord = "";
    int result = -1;
    int charPosition = 0;
    char dummyWordChar = '@';
    char goalWordChar = dictionary.get(goalPos).charAt(0);
    boolean lookingForWord =  true;

    dummyWord = dictionary.get(currentPos);
    dummyWordChar = dummyWord.charAt(0);


    while(lookingForWord){

      dummyWordChar++;

      if(dummyWordChar > goalWordChar){
        // we have gone past the goal word in the alphabet sequence.
        charPosition++;

        // if a match was found previously, return that match.
        if(result != -1){
          return result;
        }
      }

      if(charPosition > (dummyWord.length() - 1)){
        // we have not found a word match and are now out of bounds. Ideally this should never happen.
        System.out.println("Program could not find the right words to build this chain.");
        System.exit(0);
      }

      dummyWord = insertLetter(dummyWord, dummyWordChar, charPosition);

      /// Check if new word is a real word.
      if(dictionary.contains(dummyWord)){
        /// Visual Test:
        System.out.println(dummyWord);
        result = dictionary.indexOf(dummyWord);
      }
    }

    return result; // temp return value
  }

  private static String insertLetter(String word, char letter, int position){
    /// Caution: possible out of bounds error if position is larger than word
    return word.substring(0, position) + letter + word.substring(position + 1);
  }

  private static int findWordPosition(ArrayList dictionary, String inputWord){
    if(dictionary.contains(inputWord.toLowerCase())){
      return dictionary.indexOf(inputWord.toLowerCase());
    }
    return -1;
  }

  private static boolean checkFiletype(String filePath){
    String pattern = "[a-zA-Z0-9\\_\\-]{1,}\\.txt";
    String pattern2 = "[a-zA-Z0-9\\_\\-]{1,}\\.csv";

    if(filePath.matches(pattern) || filePath.matches(pattern2)){
      return true;
    }
    return false;
  }

  private static ArrayList<String> getCustomDictionary(String filePath){

    ArrayList<String> wordList = new ArrayList<String>();
    File inputFile = null;
    Scanner in = null;

    try{
      inputFile = new File(filePath);

      if(!inputFile.exists()){
        System.out.println("File not found");
      }else{
        in = new Scanner(inputFile);

        while(in.hasNext()){
          java.util.Collections.addAll(wordList, in.nextLine().split(","));
        }
        // close Scanner
        in.close();
      }
    }catch(IOException exception){
      System.out.println(exception);
    }

    return wordList;
  }
}

