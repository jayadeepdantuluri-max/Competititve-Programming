import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    public static int majorityElement(int[] arr){
        int candidate=0,count=0;
        for(int num:arr){
            if(count==0) candidate=num;
            if(num==candidate) count++;
            else count--;
        }
        count=0;
        for(int num:arr){
            if(num==candidate) count++;
        }
        return count>arr.length/2?candidate:-1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(majorityElement(arr));
        sc.close();
    }
}
