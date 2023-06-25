public class Bubblesort{

  public static void main(String[] args){
    // For Function Test
    int[] testArray = {5, 0, 7, 9, 19, 33, 6};

    System.out.print("input array: ");
    printArray(testArray);

    System.out.println("");
    System.out.print("After bubblesort: ");

    bubbleSort(testArray);
    printArray(testArray);

  }

  public static void printArray(int[] array){
    for (int i : array) {
      System.out.print(" " + i);
    }
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
