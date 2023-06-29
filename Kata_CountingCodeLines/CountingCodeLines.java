public class CountingCodeLines {

  public static void main(String[] args){
    //TODO: check file is valid, if valid open file and check each line adding lines with code to counter. output count to screen.
    if(validateFileType(args[0])){
      System.out.print("it worked");
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

  private static boolean checkLineForCode(String lineFromFile){
    //TODO: ipmlement Regex check
    return false;
  }
}
