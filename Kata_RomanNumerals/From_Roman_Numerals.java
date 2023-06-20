import java.util.HashMap;

public class From_Roman_Numerals{

  public static void main(String[] args){

    HashMap<String, Integer> rValues = new HashMap<String, Integer>();
    rValues.put("I", 1);
    rValues.put("V", 5);
    rValues.put("X", 10);
    rValues.put("L", 50);

    String[] inputValue = null;
    int inputLength = 0;
    int output = 0;

    // Check input
    if(args.length > 0 && args.length < 2 ){
      if(validateInput(args[0])){
        inputValue = args[0].split("(?!^)");
        inputLength = inputValue.length;
      }
    }else{
      // if no Roman Numeral was given or too many values
      System.exit(0);
    }

    int[] instruction = new int[inputLength];

    if(inputLength > 1){
      for (int i=1; i<inputLength; i++ ) {
        if(rValues.get(inputValue[i-1]) < rValues.get(inputValue[i]) ){
          instruction[i] = -1;
        }
      }

      for(int i=inputLength -1; i>=0; i--){

        output += rValues.get(inputValue[i]);

        if(instruction[i] == -1){
          output -= rValues.get(inputValue[i-1]);
          i = i-1;
        }
      }

      System.out.print(output);

    }else{
      System.out.print(rValues.get(inputValue[0]));
    }
  }

  private static boolean validateInput(String input){
    String pattern = "[a-zA-Z]{1,}";
    if(input.matches(pattern)){
      return true;
    }else{
      return false;
    }
  }
}
