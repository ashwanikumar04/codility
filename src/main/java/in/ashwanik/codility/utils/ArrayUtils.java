package in.ashwanik.codility.utils;

import java.util.Arrays;

/**
 * Created by AshwaniK on 7/15/2016.
 */
public class ArrayUtils {
    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print(boolean[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            print(array[i]);
        }
    }

    public static void print(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            print(array[i]);
        }
    }
}
