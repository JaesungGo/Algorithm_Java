package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다.
 */

public class Main {

    static int[] arrInt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 초기화
        int num1 = sc.nextInt();
        arrInt = new int[num1];

        // 배열 채우기
        for(int i=0; i<num1; i++){
            int num2 = sc.nextInt();
            arrInt[i] = num2;
        }

        // 배열 정렬
        Arrays.sort(arrInt);


        // 배열 열어서 비교
        int num3 = sc.nextInt();
        for(int i=0; i<num3; i++){
            int num4 = sc.nextInt();
            System.out.println(findNum4(num4,num1));
        }
    }

    static int findNum4(int num4, int num1) {

        int result = 0;
        int high = num1-1;
        int low = 0;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arrInt[mid] == num4) {
                result = 1;
                return result;
            }
            else if (arrInt[mid] > num4) high = mid - 1;
            else low = mid + 1;
        }
        return result;
    }
}
