import java.util.ArrayList; // import the ArrayList class
import java.io.*;
import java.util.Scanner;


public class WordChains{
  ///quicksort idea, make list of words and order them, then check for farthest away from start with only one change. (nearest to goal word)
  public static void main(String[] args){
    ArrayList<String> wordlist = new ArrayList<String>();

    // String[] lineOfWords = {"Hi", "Buy", "bye"};
    // wordlist.add("test");
    // java.util.Collections.addAll(wordlist, lineOfWords);

  }

  private static boolean checkFiletype(String filePath){
    String pattern = "[a-zA-Z0-9]{1,}\\.txt";
    String pattern2 = "[a-zA-Z0-9]{1,}\\.csv";

    if(filePath.matches(pattern) || filePath.matches(pattern2)){
      return true;
    }
    return false;
  }

  private static void /* ArrayList<String> */ getfile(String filePath){
    try{
      File inputFile = new File(filePath);
      Scanner in = new Scanner(inputFile);

    }catch(IOException exception){
      System.out.println(exception);
    }
    /// TODO: remember to close Scanner
  }
}
