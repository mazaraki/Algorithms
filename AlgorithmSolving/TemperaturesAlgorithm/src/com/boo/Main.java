package com.boo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int minimun;
        if (n == 0){
            minimun = 0;
        } else if (n == 1) {
            minimun = in.nextInt();
        } else {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
                arr[i] = t;

            }
            Arrays.sort(arr);

            ArrayList<Integer> arrP = new ArrayList<>();
            ArrayList<Integer> arrN = new ArrayList<>();

            if (!(arr[arr.length - 1] >= 0)) {
                minimun = arr[arr.length - 1];
            } else if (arr[0] >=0){
                minimun = arr[0];
            } else {
                for (int c = 0; c < arr.length; c++) {
                    if (arr[c] >= 0)
                        arrP.add(arr[c]);
                    else
                        arrN.add(arr[c]);
                }

                int pos = arrP.get(0);
                int neg = arrN.get(arrN.size() - 1);

                int minPos = Math.abs(pos);
                int minNeg = Math.abs(neg);
                if (minPos > minNeg) {
                    minimun = neg;
                } else {
                    minimun = pos;
                }
            }
        }
        System.out.println(minimun);
    }
}
