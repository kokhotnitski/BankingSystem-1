/*
 DataTypeConvertor.java
 Jeremy Engelbrecht
 Kirill Viktorovich Okhotnitski
 1 August 2018
 This class is used within other classes to handle unknown type exceptions and 
 to convert variables to other types.
 This application uses JDK v1.8.0_171.
 */
package bankingapplication;

public abstract class DataTypeConvertor {
    
    public static boolean CheckInteger(String input)
    {
       try
       {
          //Here we try and parse the string character as an integer if is 
          //succeeds it will return true shown below.
          Integer.parseInt(input);
          return true;
       }
       catch(NumberFormatException exp)
       {
          //The character failed to parse as a integer returning a false value.
          return false;
       }
    }
    
    public static boolean CheckDouble(String input)
    {
       try
       {
          //Here we try and parse the string character as an integer if is 
          //succeeds it will return true shown below.
          Double.parseDouble(input);
          return true;
       }
       catch(NumberFormatException exp)
       {
          //The character failed to parse as a integer returning a false value
          return false;
       }
    }
    
    public static int convertToInteger(String inputValue){
        return Integer.parseInt(inputValue);
    }
    
    public static Double convertToDouble(String inputValue){
        return Double.parseDouble(inputValue);
    }
    
    public static String convertToString(Double inputValue){
        return Double.toString(inputValue);
    }
    
    public static String convertToString(int inputValue){
        return Integer.toString(inputValue);
    }
    
}
