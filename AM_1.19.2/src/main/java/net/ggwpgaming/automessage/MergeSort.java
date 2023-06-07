package net.ggwpgaming.automessage;

import java.util.Arrays;
import java.util.Random;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(1000000);

        long startTime = System.currentTimeMillis();
        mergeSort(array);
        long endTime = System.currentTimeMillis();

//        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // Generates random integers between 0 and 999
        }
        return array;
    }
}
