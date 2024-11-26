package com.example.demo;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(cards, target) - lowerBound(cards, target)).append(' ');
        }

        System.out.println(sb);
    }

    static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = (low + high) / 2;
            if(arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = (low + high) / 2;
            if(arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}