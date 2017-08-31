package com.algorithm.hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: feipeixuan
 * @Version:
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class lianjia2 {

    public static void main(String [] args) throws FileNotFoundException {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        HashSet<Integer> hashSet=new HashSet();
        for(int i=0;i<num;i++)
            hashSet.add(scanner.nextInt());
        ArrayList<Integer> arrayList=new ArrayList(hashSet.size());
        for(int value:hashSet)
            arrayList.add(value);
        Collections.sort(arrayList);
        System.out.println(arrayList.size());
        for(int i=0;i<arrayList.size();i++)
            if(i!=arrayList.size()-1)
                System.out.print(""+arrayList.get(i)+" ");
            else
                System.out.print(""+arrayList.get(i));

    }
}
