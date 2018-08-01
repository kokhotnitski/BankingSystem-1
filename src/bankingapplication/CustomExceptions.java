/*
 CustomExceptions.java
 Jeremy Engelbrecht
 Kirill Viktorovich Okhotnitski
 1 August 2018
 This class is a concrete class of the Exception class from the Java standard
 library. Used to handle certain exceptions within the other classes.
 This application uses JDK v1.8.0_171.
 */
package bankingapplication;

public class CustomExceptions extends Exception  {
    
    //Constructor.
    public CustomExceptions(String message) {
            super(message);
        }
    
}
