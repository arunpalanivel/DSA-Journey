/*
Problem no: 10 Intersection of Sorted Arrays.
 */

import java.util.ArrayList;
import java.util.List;


public class IntersectionOfSorted {
    public static void bruteForce(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] temp = new int[n2];
        List<Integer> intersection = new ArrayList<>();

        for(int i=0;i<n1;i++){
            for(int j=0; j<n2;j++){
                if(arr1[i] == arr2[j] && temp[j] == 0){
                    intersection.add(arr2[j]);
                    temp[j] = 1;
                    break;
                }
                if(arr2[j] > arr1[i]){
                    break;
                }
            }
        }
        System.out.print("Intersection of Two Sorted Arrays: " + intersection);
    }

    public static void optimal(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        List<Integer> intersection = new ArrayList<>();

        while (i<n1 && j<n2){
            if(arr1[i] < arr2[j]) i++;
            else if (arr1[i] > arr2[j]) j++;
            else {
                intersection.add(arr2[j]); // arr[i]
                j++; // i++ as well
            }
        }
        System.out.print("Intersection of Two Sorted Arrays: " + intersection);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3,3,4,5,5};
        int[] arr2 = {2,3,4,5,6};
        bruteForce(arr1,arr2);
        System.out.println();
        optimal(arr1,arr2);
    }
}
