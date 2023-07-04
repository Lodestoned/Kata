import java.io.*;
import  java.util.*;

public class CountingCodeLines {

  public static void main(String[] args){
    /// TODO: make regex check for code line in checkLineForCode()
    if(validateFileType(args[0])){
      try{
        System.out.println(countCodeLines(args[0]));
      }
      catch(IOException exception) {
        System.out.println(exception);
      }
    }
  }

  private static boolean validateFileType(String filename){
    // All files must be .java files and cannot have special characters.
    String pattern = "[a-zA-Z0-9]{1,}\\.java";

    if(filename.matches(pattern)){
      return true;
    }
    // else
    return false;
  }

  private static int countCodeLines(String filePath) throws IOException {

    File inputFile = new File(filePath);
    int linesOfCode = 0;

    if(!inputFile.exists()){
      System.out.println("File not found");
    }else{
      Scanner in = new Scanner(inputFile);

      while(in.hasNext()){
        if(checkLineForCode(in.nextLine())){
          linesOfCode++;
        }
      }
    }

    return linesOfCode;
  }

  private static boolean checkLineForCode(String lineFromFile){
    /// TODO: add regex check.
    // this temporary pattern counts all blank spaces, which is not what we are after.
    String pattern = "";
    if(lineFromFile.matches(pattern)){
      return true;
    }
    return false;
  }
}
