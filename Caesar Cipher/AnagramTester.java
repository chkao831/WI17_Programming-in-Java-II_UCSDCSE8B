
public class AnagramTester {

    public static void testP1() {
        System.out.println("--- Testing p1() ---");
       
        String word = "hello";

	// Same as:
        // String[] possibleAnagrams = new String[3];
        // possibleAnagrams[0] = "cse8b";
        // possibleAnagrams[1] = "rocks";
        // possibleAnagrams[2] = "elloh";
        String[] possibleAnagrams = {"cse8b","rocks","elloh"};
        
        // We can use a try/catch statement to keep the program running even
        // when an exception is thrown.
        try {
            // This is how to call p1. p2 through p8 are called with the same
            // parameters.
            AnagramFinder.p1(possibleAnagrams, word);

	} catch (NullPointerException e) {
            // This code will execute if p1 throws a NullPointerException.
            System.out.println("An exception occurred! " + e.toString());
        }
        
        // This code will occur if try block executes successfully, or if the
        // exception is caught.
        System.out.println("-- Done testing p1() ---");

    }

   public static void testP2() {
        System.out.println("--- Testing p2() ---");
        
        String word = null; 
        
        String[] possibleAnagrams = { "cse8b", "rocks", "elloh" };
        
        try {
            AnagramFinder.p2(possibleAnagrams, word);
            
        } catch (NullPointerException e) {
            System.out.println("An exception occurred! " + e.toString());
        }
        
        System.out.println("-- Done testing p2() ---");
        }

    public static void testP3() {
        System.out.println("--- Testing p3() ---");
       
        String word = "hello";

        String[] possibleAnagrams = { "cse8b", "rocks", "elloah" };
        
        try {
            AnagramFinder.p3(possibleAnagrams, word);

	} catch (NullPointerException e) {
            System.out.println("An exception occurred! " + e.toString());
        }
        
        System.out.println("-- Done testing p3() ---");
	
	}

	
     public static void testP5() {
        System.out.println("--- Testing p5() ---");
       
        String word = "ccse8bb";

         String[] possibleAnagrams = new String[3];
         possibleAnagrams[0] = "cse8b";
         possibleAnagrams[1] = "rocks";
         possibleAnagrams[2] = "hello";
        
        try {
            AnagramFinder.p5(possibleAnagrams, word);

	} catch (NullPointerException e) {
            System.out.println("An exception occurred! " + e.toString());
        }
        
        System.out.println("-- Done testing p5() ---");

    }

      public static void testP6() {
        System.out.println("--- Testing p6() ---");
       
        String word = "hello";

        String[] possibleAnagrams = new String[0];
        

        try {
            AnagramFinder.p6(possibleAnagrams, word);

	} catch (NullPointerException e) {
            System.out.println("An exception occurred! " + e.toString());
        }
        
        System.out.println("-- Done testing p6() ---");

    }



      public static void testP7() {
        System.out.println("--- Testing p7() ---");
       
        String word = "hello";

        String[] possibleAnagrams = { "" };
        

        try {
            AnagramFinder.p7(possibleAnagrams, word);

	} catch (NullPointerException e) {
            System.out.println("An exception occurred! " + e.toString());
        }
        System.out.println("-- Done testing p7() ---");

    }


       public static void testP8() {
        System.out.println("--- Testing p8() ---");
       
        String word = "hello";

        String[] possibleAnagrams = { "cse8b", "rocks", "e lloh" };
        
        try {
            AnagramFinder.p8(possibleAnagrams, word);

	} catch (NullPointerException e) {
            System.out.println("An exception occurred! " + e.toString());
        }
        
        System.out.println("-- Done testing p8() ---");
    }

        
        
 
    public static void main(String[] args) {
        testP1();
	testP2();
	testP3();
	testP5();
	testP6();
	testP7();
	testP8();
	
    }
}
