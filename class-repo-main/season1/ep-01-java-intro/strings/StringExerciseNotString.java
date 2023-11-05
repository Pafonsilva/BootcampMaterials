class StringExerciseNotString {

  public static void main(String[] args) {

    notString("semicolon");
    notString("not bad");
  }

   public static void notString(String str) {

     // if the string has 3 or more chars
     // and the first three chars are equal to "not"
     if (str.length() >= 3 && str.substring(0, 3).equals("not")) {

       System.out.println(str);
     } else {

       System.out.println("not " + str);
     }
  }
}
