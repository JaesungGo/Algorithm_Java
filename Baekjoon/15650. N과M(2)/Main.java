package com.example.demo;

import java.util.*;
import java.io.*;

/**
 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 고른 수열은 오름차순이어야 한다.
 */


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numN = sc.nextInt();
        int numM = sc.nextInt();

        int[] arrInt = new int[numN+1];
        boolean[] visited = new boolean[numN+1];

        for(int i=1; i<=numN; i++){
            arrInt[i] = i;
        }

        decideArrNum(arrInt, visited, numM, 1);

    }

    public static void decideArrNum(int[] arrInt, boolean[] visited, int depth, int count){
        if( count > depth ){
            for(int i=1; i<=depth; i++){
                System.out.print(arrInt[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<arrInt.length; i++){
            if(!visited[i]){
                if(count ==1 || arrInt[count-1] < i ){
                    visited[i] = true;
                    arrInt[count] = i;
                    decideArrNum(arrInt, visited, depth, count+1);
                    visited[i] = false;
                }
            }
        }
    }
}