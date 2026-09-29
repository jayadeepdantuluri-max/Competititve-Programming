import java.util.Scanner;
public class Main{
    public static int divide(int dividend,int divisor){
        if(dividend==Integer.MIN_VALUE&&divisor==-1)return Integer.MAX_VALUE;
        boolean negative=(dividend<0)^(divisor<0);
        long dvd=Math.abs((long)dividend);
        long dvs=Math.abs((long)divisor);
        long quotient=0;
        while(dvd>=dvs){
            long temp=dvs,multiple=1;
            while(dvd>=(temp<<1)){
                temp<<=1;
                multiple<<=1;
            }
            dvd-=temp;
            quotient+=multiple;
        }
        if(negative)quotient=-quotient;
        if(quotient>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        if(quotient<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        return (int)quotient;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int dividend=sc.nextInt();
        int divisor=sc.nextInt();
        System.out.println(divide(dividend,divisor));
        sc.close();
    }
}
