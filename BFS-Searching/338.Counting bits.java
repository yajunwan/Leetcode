
// Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

// Example 1:

// Input: n = 2
// Output: [0,1,1]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// Example 2:

// Input: n = 5
// Output: [0,1,1,2,1,2]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101
class Solution {
    public int[] countBits(int n) {
    //     List<Integer> result = new ArrayList<>();
    //     if (n==0){
    //         result.add(0);
    //     }else if (n==1){
    //         result.add(0);
    //         result.add(1);
    //     }else{
    //         result.add(0);
    //         result.add(1);
    //         for (int i=0;i<(n+1-2);i++){
    //             int count = 0;
    //             int quotient = 2+i;
    //             while (quotient>0){
    //                 if (quotient%2==1){
    //                     count++;
    //                 }
    //                 quotient = quotient/2;
    //             }
    //             result.add(count);
    //         }
    //     }
    //     int arr[] = new int[n+1];
    //     for(int i=0;i<n+1;i++){
    //         arr[i] = result.get(i);
    //     }
    //     return arr;
        int array[] = new int[num+1];
        array[0]=0;
        if(num>=1){
            array[1]=1;
        }
        for(int i=2;i<=num;i++){
            int mod = i%2;
            int n = i/2;
            array[i] = array[mod] + array[n];  
        }
        return array;
    }
    }
}