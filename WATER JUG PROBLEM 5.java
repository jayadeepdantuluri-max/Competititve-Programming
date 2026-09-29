import java.io.*;
import java.util.*;
public class Main{
    public static int Gcd(int m, int n){
        if(n==0)
           return m;
        else
           return Gcd(n,(m%n));
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int t=sc.nextInt();
        int g;
        if(a>b)
           g=Gcd(a,b);
        else 
           g=Gcd(b,a);
        int res=t%g;
        if(res == 0)
           System.out.print("YES");
        else
           System.out.print("NO");             
    }
}
