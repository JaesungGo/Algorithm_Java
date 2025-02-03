import java.io.*;
import java.util.*;

class Main {

    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numN = Integer.parseInt(st.nextToken());
        int[] arrInt = new int[numN];
        tmp = new int[numN];

        for (int i=0; i<numN; i++) {
            arrInt[i] =  Integer.parseInt(br.readLine());
        }

        mergeSort(arrInt,0,numN-1);

        for (int i : arrInt) {
            System.out.println(i);
        }

    }

    static void mergeSort(int[] arrInt, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(arrInt, start, mid);
            mergeSort(arrInt, mid+1, end);
            merge(arrInt,start,mid,end);
        }
    }

    static void merge(int[] arrInt, int start, int mid, int end){
        int i = start;
        int j = mid + 1;
        int k = start;

        while( i <= mid && j <= end){
            if( arrInt[i] < arrInt[j]){
                tmp[k++] = arrInt[j++];
            }else {
                tmp[k++] = arrInt[i++];
            }
        }

        while( i <= mid ){
            tmp[k++] = arrInt[i++];
        }

        while( j <= end ){
            tmp[k++] = arrInt[j++];
        }

        for(int idx = start; idx <= end; idx++) {
            arrInt[idx] = tmp[idx];
        }
    }
}
