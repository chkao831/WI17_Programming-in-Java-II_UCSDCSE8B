/** Filename: FunWithIntArrays.java
 *  Modified by: Chih-Hsuan Kao, cs8bwagy
 *  Date: Jan 11, 2018
 *
 *  Compile Error - Invalid method declaration; return type required
 *  Incorrect: public static findMax(int[] array){
 *  Fix: public static int findMax(int[] array){
 *  Explanation: the return type of this method is an integer
 *
 *  Compile Error - Not a statement
 *  Incorrect: sum == array[i];
 *  Fix: sum = array[i];
 *  Explanation: To assign the value array[i] to sum should use =, not ==
 *
 *  Compile Error - cannot find symbol
 *  Incorrect: min = array[0]; 
 *  Fix: int min = array[0];
 *  Explanation: the type of the integer min should be declared
 *
 *  Compile Error - incompatible types: possible lossy conversion from double
 *  to int
 *  Incorrect: int average = ( sum / (array.length));
 *  Fix: double average = ( sum / (array.length));
 *  Explanation: resetting average as a double type so it generates the right
 *  value as in instruction
 *
 *  Compile Error - imcomparable types: int and <null>
 *  Incorrect: if(array == null)
 *  Fix: Revise the method header as public static
 *  int[] arrayCopy(int[] array)
 *  Explanation: In order to check if the integer array is null;
 *  integer value cannot be compared with null
 *
 *  Runtime Error - ArrayIndexOutOfBoundsException
 *  Incorrect: for (int i = 0; i <= array.length; i++){
 *  Fix: for (int i = 0; i < array.length; i++){
 *  Explanation: array[i] is out of bound; array[i-1] is the
 *  last one among the array
 *
 *  Runtime Error - ArrayIndexOutOfBoundsException
 *  Incorrect: for (int i = 0; i < result.length -1; ++i){
 *  for (int j=0; i<result.length-i-1;j++){
 *  Fix: for (int i = 0; i < result.length; ++1){
 *  for (int j=0; j<result.length-i-1; j++){
 *  Explanation: Fix the i part so that every index in the array
 *  is run through; and then fix the loop for j part so that the for loop
 *  is executed according to right logic
 *
 *  Wrong Output when testing out - The generated Array
 *  Incorrect: result[j + 1] = result[j]; result[j] = temp; 
 *  Fix: result[j] = result[j+1]; result[j+1] = temp; 
 *  Explanation: Fixing the wrong logic. Using temp to preserve the
 *  value of the former index, assigning the value of the later index to the
 *  former, and then assigning the value of the preserved value to later one
 *
 *  Wrong Output when testing out - The generated Array
 *  Incorrect: if (array != null) return; 
 *  Fix: if(array == null) return;
 *  Explanation: a logical error; return (terminate the method call) if the
 *  array is null
 *
 *  Wrong Output when testing out - Wrong Array Copy
 *  Incorrect: for (int i = 0; i < array.length; i++){result[i++] = array[i];}
 *  Fix: for (int int i = 0; i < array.length; i++){result[i] = array[i];}
 *  Explanation: by fixing it like that, the corresponding value at index i
 *  of the initial array would be assigned to the corresponding value
 *  at index i of the copied array
 *
 *  Wrong Output when testing out - Average value 
 *  Incorrect: sum = array[i];
 *  Fix: sum = array[i] + sum;
 *  Explanation: by adding sum to sum through the for loop,
 *  the sum would be accumulated
 */

public class FunWithIntArrays {

 // return the largest element in the input array
 public static int findMax(int[] array) {
  //short circuit protects null access
  if (array == null || array.length == 0)
   return -1;

  int max = array[0];

  for (int i = 0; i < array.length; i++) {
   if (array[i] > max) {
    max = array[i];
   }
  }

  return max;
 }

 // return the smallest element in the input array
 public static int findMin(int[] array) {
  //short circuit protects null access
  if (array == null || array.length == 0)
   return -1;

  int min = array[0];

  for (int i = 0; i < array.length; i++) {
   if (array[i] < min) {
i    min = i;
   }
  }

  return min;
 }


  // return the average of elements in the input array
  public static double findAvg( int array[] ) {
    //short circuit protects null access
    if ( array == null || array.length == 0 )
      return -1;

    double sum = 0;

    for ( int i=0; i < array.length; i++ ) {
      sum = array[i] + sum;
    }

    double average = ( sum  / ( array.length ) );

    return average;
  }

 // return a copy of the input array
 public static int[] arrayCopy(int[] array) {
  if (array == null)
   return null;

  int[] result = new int[array.length];

  for (int i = 0; i < array.length; i++) {
   result[i] = array[i];
  }
  return result;
 }

 // output the elements of the input array
 public static void printArray(int[] array) {
  if (array == null)
   return;

  for (int i = 0; i < array.length; i++) {
   System.out.print(array[i] + ", ");
  }

  System.out.println();
 }

 // return a sorted copy of the input array
 public static int[] arraySort(int[] array) {
  if (array == null)
   return null;

  int[] result = arrayCopy(array);

  for (int i = 0; i < result.length; ++i) {
   for (int j = 0; j < result.length - i - 1 ; j++) {
    if (result[j] > result[j + 1]) {
     //swapping result[j] and result[j+1]
     int temp = result[j];
     result[j] = result[j+1];
     result[j+1] = temp;
    }
   }
  }
  return result;
 }
}
