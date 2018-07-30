/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapplication;

/**
 *
 * @author jeremye
 */
public abstract class DataTypeConvertor {
    
    public static boolean CheckInteger(String input)
    {
       try
       {
          //here we try and parse the string character as an integer if is succeeds it will return true shown below
          Integer.parseInt(input);
          return true;
       }
       catch(NumberFormatException exp)
       {
          //the character failed to parse as a integer returning a false value
          return false;
       }
    }
    
    public static boolean CheckDouble(String input)
    {
       try
       {
          //here we try and parse the string character as an integer if is succeeds it will return true shown below
          Double.parseDouble(input);
          return true;
       }
       catch(NumberFormatException exp)
       {
          //the character failed to parse as a integer returning a false value
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


