/*
Problem no: 9 Find the Union
 */


import java.util.*;

public class FindTheUnion {
    public static void bruteForce(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        Set<Integer> set = new LinkedHashSet<Integer>();

        for(int i: arr1){
            set.add(i);
        }
        for(int i: arr2){
            set.add(i);
        }
        List<Integer> union = new ArrayList<>(set);
        System.out.print("Union: " + union);

    }
    public static void optimal(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;

        List<Integer> union = new ArrayList<>();

        while (i<n1 && j<n2){
            if(arr1[i] <= arr2[j]){
                if(union.isEmpty() || union.get(union.size() -1) != arr1[i] ){
                    union.add(arr1[i]);
                }
                i++;
            }
            else{
                if(union.isEmpty() || union.get(union.size() -1) != arr2[j]){
                    union.add(arr2[j]);
                }
                j++;

            }
        }
        while (i<n1){
            if(arr1[i] <= arr2[j]){
                if(union.isEmpty() || union.get(union.size() -1) != arr1[i] ){
                    union.add(arr1[i]);
                }
                i++;
            }

        }
        while (j<n2){
            if(union.isEmpty() || union.get(union.size() -1) != arr2[j]){
                union.add(arr2[j]);
            }
            j++;

        }
        System.out.println("Union of Two Sorted Arrays: " + union);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3,3,4,5,5};
        int[] arr2 = {2,3,4,5,6};
        bruteForce(arr1,arr2);
        System.out.println();
        optimal(arr1,arr2);

    }

}
