public class Bubblesort{

  public static void main(String[] args){
    // For Function Test

  }

  public static int[] bubbleSort(int[] inputArray){

    boolean swapped = true;

    while(swapped){

      swapped = false;
      int tempInt = 0;

      for (int i=0; i<inputArray.length -1; i++ ) {
        if(inputArray[i] > inputArray[i + 1]){
          tempInt = inputArray[i];
          inputArray[i] = inputArray[i + 1];
          inputArray[i + 1] = tempInt;

          swapped = true;
        }
      }

    }

    return inputArray;
  }
}
