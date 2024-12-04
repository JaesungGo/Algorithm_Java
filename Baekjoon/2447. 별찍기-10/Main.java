package com.example.demo;

import java.util.*;
import java.io.*;

/**
 * 재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
 *
 * 크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
 *
 * ***
 * * *
 * ***
 * N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
 */

public class Main {

    static char[][] starMap;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numN = sc.nextInt();
        starMap = new char[numN][numN];
        for(char[] n : starMap){
            Arrays.fill(n,' ');
        }

        makeStar(0,0,numN);

        for(char[] n : starMap){
            bw.write(n);
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }


    static void makeStar(int r, int c, int size){
        if( size == 1 ){
            starMap[r][c] = '*';
            return;
        }

        int sizeN = size/3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1) continue;
                makeStar(r+j * sizeN, c+i* sizeN, sizeN);
            }
        }
    }
}