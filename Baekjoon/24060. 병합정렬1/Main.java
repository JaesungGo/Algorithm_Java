import java.io.*;
import java.util.*;

class Main {

    static int numK;
    static int count;
    static int result;
    static int[] arrTmp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numN = Integer.parseInt(st.nextToken());
        numK = Integer.parseInt(st.nextToken());
        result = -1;

        int[] arrA = new int[numN];
        arrTmp = new int[numN];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numN; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arrA,0,arrA.length-1);

        System.out.println(result);

    }

    static void merge_sort(int[] arrInt, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            merge_sort(arrInt,start,mid);
            merge_sort(arrInt,mid+1,end);
            merge(arrInt,start,mid,end);
        }
    }

    static void merge(int[] arrInt, int start, int mid, int end){
        int i = start;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= end){
            if(arrInt[i] <= arrInt[j]){
                arrTmp[t++] = arrInt[i++];
            }else{
                arrTmp[t++] = arrInt[j++];
            }
        }
        while( i <= mid ){
            arrTmp[t++] = arrInt[i++];
        }
        while( j <= end ){
            arrTmp[t++] = arrInt[j++];
        }
        i = start;
        t = 0;
        while( i <= end ){
            count++;
            arrInt[i++] = arrTmp[t++];
            if(count == numK) {
                result = arrInt[i-1];
                break;
            }
        }
    }
}
