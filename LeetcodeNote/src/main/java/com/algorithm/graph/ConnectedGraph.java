package com.algorithm.graph;

import java.util.*;

public class ConnectedGraph {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][];
        for (int i = 0; i < n; i++)
            array[i] = new int[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                array[i][j] = scanner.nextInt();
        boolean[] flag = new boolean[n];
        List<List<Integer>> sumList=new LinkedList<List<Integer>>();
        for(int i=0;i<n;i++){
            if(flag[i]==false){
                List<Integer> list=new LinkedList<Integer>();
                flag[i]=true;
                sumList.add(list);
                list.add(i);
                dfs(i,n,flag,array,list);
            }
        }
        for (List<Integer> list:sumList) {
            System.out.println(list);
        }
    }

    public static void dfs(int index, int n, boolean[] flag, int[][] array, List<Integer> list) {
        for (int i = 0; i < n; i++) {
            if (array[index][i] == 1 && flag[i] == false) {
                list.add(i);
                flag[i] = true;
                dfs(i, n, flag, array, list);
            }
        }
    }
}
