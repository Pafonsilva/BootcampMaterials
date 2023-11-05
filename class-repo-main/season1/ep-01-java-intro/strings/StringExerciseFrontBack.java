class StringExerciseFrontBack {

  public static void main(String[] args) {

    frontBack("Heisenberg");
  }

   public static void frontBack(String str) {

     // we need to make sure the string has more than one character
     // to reverse the front and back chars
     if (str.length() > 1) {

       // select the middle string
       // exclude the first and the last char
       // eisenber
       String mid = str.substring(1, str.length()-1);

       // last + mid + first
       System.out.println(str.charAt(str.length()-1) + mid + str.charAt(0));
    }
  }
}
