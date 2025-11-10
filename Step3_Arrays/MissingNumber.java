/*
Problem no: 10 Find Missing number in an array
 */

public class MissingNumber {
    public static int bruteForce(int[] arr, int n){
        int result = 0;
        for(int i=1;i<=n;i++){
            int flag = 0;
            for(int j=0;j<n-1;j++){
                if(arr[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                result = i;
                break;
            }
        }
        return result;
    }

    public static int optimal(int[] arr, int n){
        int s1 = (n*(n+1)/2);
        int s2 = 0;
        for(int i=0;i<n-1;i++){
            s2+= arr[i];
        }
        return s1-s2;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6};
        int n = 6;
        int result = bruteForce(arr,n);
        System.out.print("Missing Number: " + result);
        System.out.println();
        int result1 = optimal(arr,n);
        System.out.print("Missing Number: " + result1);
    }
}
