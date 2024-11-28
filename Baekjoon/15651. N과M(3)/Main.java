package com.example.demo;

import java.util.*;
import java.io.*;

/**
 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 1부터 N까지 자연수 중에서 M개를 고른 수열
 같은 수를 여러 번 골라도 된다.
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numN = Integer.parseInt(st.nextToken());
        int numM = Integer.parseInt(st.nextToken());


        int[] arrInt = new int[numN+1];

        for(int i=1; i<=numN; i++){
            arrInt[i] = i;
        }

        findAllCase(arrInt,numM,1,sb);

        System.out.println(sb);
        br.close();

    }

    static void findAllCase(int[] arrInt, int depth, int count, StringBuilder sb){
        if(depth < count){
            for(int i=1; i<count; i++){
                sb.append(arrInt[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<arrInt.length; i++){
            arrInt[count] = i;
            findAllCase(arrInt, depth, count+1,sb);
        }

    }
}