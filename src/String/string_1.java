package String;

import javax.swing.*;

public class string_1 {
    // Program to find the first character of a string
public static void main(String[] args){
    String str ="Hello";
    if ((str != null) && (str.length()> 0) &&(str.charAt((0))!=' '))
    {
        char firstChar = str.charAt(0);
        System.out.println("The first character of the string is: " + firstChar);

    }
    else {
        System.out.println("The string is empty or null, so it has no first character ");
    }
}
}
