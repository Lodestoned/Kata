import java.io.*;
import  java.util.*;

public class CountingCodeLines {

  public static void main(String[] args){
    
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
    String tempNextLine = "";
    boolean inCommentBlock = false;

    if(!inputFile.exists()){
      System.out.println("File not found");
    }else{
      Scanner in = new Scanner(inputFile);

      while(in.hasNext()){

        tempNextLine = in.nextLine().trim();

        if(tempNextLine.isEmpty()){
          continue;
        }
        if(tempNextLine.contains("/*")){
          // start of block comment found
          inCommentBlock = true;
        }
        if(inCommentBlock && tempNextLine.contains("*/")){
          // end of comment block found
          inCommentBlock = false;
          continue;
        }
        if(!tempNextLine.startsWith("//") && !inCommentBlock){
          linesOfCode++;
        }
      }
    }

    return linesOfCode;
  }
}
