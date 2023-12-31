public class To_Roman_Numerals{

    public static void main(String[] args){

      String[][] numbers = {{},
      {"","I","II","III","IV","V","VI","VII","VIII","IX"},
      {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
      {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}};

      if(validateInput(args[0]) == false){
        System.out.print("Must input a number between 1 and 3999");
        System.exit(0);
      }
     
      char[] inputNumberChars = args[0].toCharArray();
      int inputSize = inputNumberChars.length;

      if(inputSize > 4){
        // only dealing with hundreds
        System.out.print("Your number is too large for this function.");
      }else{
        int position = inputSize;

        for (int i=0; inputSize > i ;i++ ) {
          if(position < 4){
            System.out.print(numbers[position][Character.getNumericValue(inputNumberChars[i])]);
          }
          else{
            int thousands = Character.getNumericValue(inputNumberChars[0]);
            if(thousands <= 3){
              for(int j=0; j<thousands; j++){
                System.out.print("M");
              }

            }
            else{
              System.out.print("Your number is too large for this function.");
              // exit program
              System.exit(0);
            }
          }
          position--;
        }
      }

  }

  private static boolean validateInput(String input){
    String pattern = "[0-9]{1,4}";
    if(input.matches(pattern)){
      return true;
    }
    return false;

  }
}
