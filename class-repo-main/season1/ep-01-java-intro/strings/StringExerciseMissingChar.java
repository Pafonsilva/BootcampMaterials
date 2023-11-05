class StringExerciseMissingChar {

  public static void main(String[] args) {

    missingChar("Robocop", 3);
  }

   public static void missingChar(String str, int n) {

     // Robocop
     // 0123456

     // select all the chars till the chosen one, excluding it
     // "Rob"
     String front = str.substring(0, n);

     // select all chars from the fist after the chosen one
     // "cop"
     String back = str.substring(n + 1);

     System.out.println(front + back);
  }
}
