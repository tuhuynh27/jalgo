package com.tuhuynh.jalgo.riddles;

public class MaxSubArraySum {
    public static void run() {
        int []arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(arr));
    }

    static int maxSubArraySum(int[] a) {
        int sumArr = a[0], maxSum = a[0];
        for (int j = 1; j < a.length; j++) {
            sumArr = Math.max(a[j], sumArr + a[j]);
            maxSum = Math.max(maxSum, sumArr);
        }
        return maxSum;
    }
}
