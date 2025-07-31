package Arrays;
import java.util.*;
public class array_1 {
// Program to take input from user and sort the array
// and print the elements of the array
// This program uses the Scanner class to read input from the user

    public static void main(String[] args) {
        int arr[]=new int[5];
        Scanner sc=new Scanner(System.in);
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
            System.out.println(arr[i]);
        }

    }

}
