import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;


public class WordChains{
  ///quicksort idea, make list of words and order them, then check for farthest away from start with only one change. (nearest to goal word)
  public static void main(String[] args){
    ArrayList<String> wordList = null;

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
    boolean chainComplete = false;

    wordChain.add(dictionary.get(startPos));

    while(!chainComplete){

      startPos = findNextWordPos(dictionary, startPos, goalPos);

      if(startPos == -1){
        System.out.println("Could not create word chain with provided dictionary.");
        System.exit(0);
      }

      wordChain.add(dictionary.get(startPos));

      if(startPos == goalPos){
        chainComplete = true;
        continue;
      }
    }

    return wordChain;
  }

  private static int findNextWordPos(ArrayList<String> dictionary, int currentPos, int goalPos){

    String dummyWord = "";
    int tempResult = -1;
    char dummyWordChar = '@';
    char goalWordChar = dictionary.get(goalPos).charAt(0);

    dummyWord = dictionary.get(currentPos);
    dummyWordChar = dummyWord.charAt(0);

    dummyWordChar++;
    dummyWord = insertLetter(dummyWord, dummyWordChar, 0);

    /// Check if new word is a real word.
    if(dictionary.contains(dummyWord)){
      tempResult = dictionary.indexOf(dummyWord);
    }


///TODO: check that first letter of current is not the same as goal, or when changed is higher value than goal
/// if so, then use next letter in word. repeat check
/// TODO: check if dummyWord is the same as goal word.
    return tempResult; // temp return value
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


