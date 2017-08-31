package com.algorithm.other;

import java.util.Scanner;

/**
 * @Author: feipeixuan
 * @Version:
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class lianjia3 {

    public static void main(String [] args)
    {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int [] array=new int[num];
        for(int i=0;i<array.length;i++)
            array[i]=scanner.nextInt();
        int n=scanner.nextInt();
        int [] array1=new int[n];
        for(int i=0;i<array1.length;i++)
            array1[i]=scanner.nextInt();
        int [] array2=new int[num+1];
        for(int i=1;i<=num;i++)
            array2[i]=array[i-1]+array2[i-1];
        for(int i=0;i<n;i++)
            for(int j=1;j<=num;j++)
                if(array1[i]<=array2[j]) {
                    System.out.println(j);
                    break;
                }
    }
}
