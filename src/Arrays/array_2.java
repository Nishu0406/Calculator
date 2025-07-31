// sum of flaot number
package Arrays;
import java.util.*;
public class array_2 {
    // Program to find the sum of float numbers in an array

    public static void main(String[] args) {
       float mark[]={2.3f,6.7f,3.5f,2.5f};
       float sum=0;
       for(int i=0;i<mark.length;i++){
           sum=sum+mark[i];
       }
        System.out.println(sum);
    }
}
