import java.util.ArrayList;
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
      // Collections.sort(wordList);

      ///TODO: store and use the word positions
      findWordPosition(wordList, args[1]);
      findWordPosition(wordList, args[2]);


    }else{
      System.out.println("Incorrect Filetype.");
    }
  }

  private static int findWordPosition(ArrayList dictionary, String inputWord){
    if(dictionary.contains(inputWord.toLowerCase())){
      return dictionary.indexOf(inputWord.toLowerCase());
    }

    System.out.printf("Could not find %s in dictionary.",inputWord);
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
