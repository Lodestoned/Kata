public class To_Roman_Numerals{

    public static void main(String[] args){

      String[][] numbers = {{},
      {"","I","II","III","IV","V","VI","VII","VIII","IX"},
      {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
      {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}};

      // Should sanitise input with REGEX check but is beyond the scope of this exercise.
      char[] inputNumberChars = args[0].toCharArray();
      int inputSize = inputNumberChars.length;

      if(inputSize >= 4){
        // only dealing with hundreds
        System.out.print("Your number is too large for this function.");
      }else{
        int position = inputSize;

        for (int i=0; inputSize > i ;i++ ) {
          System.out.print(numbers[position][Character.getNumericValue(inputNumberChars[i])]);
          position--;
        }
      }

  }
}
