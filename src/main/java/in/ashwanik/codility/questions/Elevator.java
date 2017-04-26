package in.ashwanik.codility.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by AshwaniK on 25/04/17.
 */
public class Elevator {
    public static void main(String[] args) {

        Elevator elevator = new Elevator();

        int[] A = new int[]{60, 80, 40};
        int[] B = new int[]{2, 3, 5};
        int M = 5;
        int X = 2;
        int Y = 200;

        System.out.println(elevator.solution(A, B, M, X, Y));

        A = new int[]{40, 40, 100, 80, 20};
        B = new int[]{3, 3, 2, 2, 3};
        M = 3;
        X = 5;
        Y = 200;
        System.out.println(elevator.solution(A, B, M, X, Y));
    }

    public int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        int count = 0;
        int currentWeight = 0;
        int limit = 1;
        int i = 0;
        int length = A.length;
        while (i < length) {
            Set<Integer> floors = new HashSet<>();
            int weight = currentWeight + A[i];
            while (limit <= X && (weight) <= Y && (i < length)) {
                currentWeight = weight;
                floors.add(B[i]);
                limit++;
                i++;
                if (i < length) {
                    weight = currentWeight + A[i];
                }
            }
            //Unloading
            count += floors.size() + 1;
            currentWeight = 0;
            limit = 1;
        }
        return count;
    }
}
