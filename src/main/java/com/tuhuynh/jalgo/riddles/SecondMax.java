package com.tuhuynh.jalgo.riddles;

public class SecondMax {
    public static void run() {
        int[] arr = {1, 2, 3, 4};

        int max = arr[0];
        int secondMax = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
        }

        System.out.println(secondMax);
    }
}
