package net.ggwpgaming.automessage;

import java.util.Arrays;

import java.util.Arrays;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                swap(array, ++i, j);
            }
        }

        swap(array, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(1000000);

        long startTime = System.currentTimeMillis();
        quickSort(array);
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
