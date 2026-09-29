import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
public static int maxAscendingSum(int[] arr){
int max=arr[0],sum=arr[0];
for(int i=1;i<arr.length;i++){
if(arr[i]>arr[i-1])sum+=arr[i];
else sum=arr[i];
if(sum>max)max=sum;
}
return max;
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int[] arr=new int[n];
for(int i=0;i<n;i++)arr[i]=sc.nextInt();
System.out.print(maxAscendingSum(arr));
}
}
