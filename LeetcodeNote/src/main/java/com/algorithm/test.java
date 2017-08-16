package com.algorithm;

/**
 * @Author: feipeixuan
 * @Version:
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class test {

    public static void main(String [] args){
        int [] array={0,2,2,1,0,1,0};
        sort(array);
        for(int num:array)
            System.out.println(num);
    }

    public static void sort(int [] array)
    {
        int index0=0,index2=array.length-1;

        for(int i=0;i<=index2;i++)
        {
            if(array[i]==2) {
                swap(i, index2--, array);
                if (array[i] == 0)
                    index0++;
            }
            else if(array[i]==0 && index0==i)
                index0++;
            else if(array[i]==0 && index0!=i)
                swap(i,index0++,array);
        }

    }

    static void  swap(int i,int j,int [] array)
    {
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
}
