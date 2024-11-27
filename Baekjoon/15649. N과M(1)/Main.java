package com.example.demo;

import java.util.*;
import java.io.*;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 */


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numN = sc.nextInt();
        int numM = sc.nextInt();

        int[] arrInt = new int[numM];
        boolean[] visited = new boolean[numN];

        printAllCase(arrInt, 0, numN, numM, visited);
    }

    public static void printAllCase(int[] arrInt, int depth, int n, int m, boolean[] visited) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arrInt[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arrInt[depth] = i + 1;
                printAllCase(arrInt, depth + 1, n, m, visited);
                visited[i] = false;
            }
        }
    }
}