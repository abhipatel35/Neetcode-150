package ArrayHashing.ProductExceptSelf;

import java.util.Arrays;

public class ProductExceptSelf {

// solution 1 : Brute force
        // public int[] productExceptSelf(int[] nums) {
        //     int n = nums.length; // get total length of array to iterate through
        //     int[] res = new int[n]; // create result array to store final output

        //     //start brute force
        //     for(int i = 0; i<n; i++){
        //         int prod = 1; // intially take total product as 1.

        //         //nested for loop to get value of all other numbers in j index
        //         for (int j = 0; j < n ; j++){
        //             //run if loop until if i is not equal to j
        //             if(i != j){
        //                 //new product will be the product of other elements(j) of array except itself(i)
        //                 prod *= nums[j];
        //             }
        //         }
        //         res[i] = prod;// store new product as new value for element in index i
        //     }
        //     return res; //return final output
        // }




// solution 2 : Division
        // public int[] productExceptSelf(int[] nums){

        //     //step 1: compute the total product(Ignoring Zero)
        //     int prod = 1; //intial vlaue of prod
        //     int zeroCount = 0; //To count the no. of zeroes in nums
        //     // Iterate through num
        //     for(int num : nums){
        //         //if num is not zero then multiply it to prod
        //         if(num != 0){
        //             prod *= num;
        //         }
        //         //if num is zero then increase zeroCount
        //         else{
        //             zeroCount++;
        //         }
        //     }

        //     //step 2: Handle the special case of multiple zeros.
        //     // if there are two or more zeros then result should be all zeroes.
        //     if(zeroCount > 1){
        //         return new int[nums.length]; // Return an array of size nums.length intialized with zero
        //     }

        //     //step 3: Compute the result
        //     int[] res = new int[nums.length];
        //     for (int i=0; i<nums.length ; i++){
        //         //If there is one zero then what?
        //         if(zeroCount > 0){
        //             //then only the index where nums[i] == 0 will contain prod (product of all non-zero numbers)
        //             //all other('?' used) indices will be zero.
        //             res[i] = (nums[i] == 0) ? prod : 0;
        //         }
        //         //If zeroCount is zero means all are non zero values then
        //         else{
        //             res[i] = prod/nums[i];
        //         }
        //     }
        //     return res;
        // }



//solution 3: Prefix and Suffix
        // public int[] productExceptSelf(int[] nums){

        //     // Step 1: Intialize variables and Array result, prefix, suffix
        //     int n  = nums.length;
        //     int[] res = new int[n]; // to store result
        //     int[] pref = new int[n]; // to store prefix
        //     int[] suff = new int[n]; // to store suffix
        //     pref[0] = 1; // pref product of 0th element in array is 1. so first element of prefix array is 1.
        //     suff[n-1] = 1; // suff product of last(n-1) element in array is 1. so last element of suffix array is 1.

        //     //Step 2: Compute prefix product array
        //     for(int i=1; i<n ; i++){
        //         pref[i] = nums[i-1] * pref[i-1];
        //     }

        //     //Step 3: Copmute suffix product Array
        //     for(int i=n-2; i>=0; i--){
        //         suff[i] = nums[i+1] * suff[i+1];
        //     }

        //     //Step 4: Compute final result array using pref and sufff arrays
        //     for(int i=0; i<n; i++){
        //         res[i] = pref[i] * suff[i];
        //     }

        //     //Return result array as final output
        //     return res;S
        // }



//solution 4: prefix and suffix (optimal)
        public int[] productExceptSelf(int[] nums){

            //Step 1: Initialize variable and Array
            int n = nums.length;
            int[] res = new int[n]; // To store final result

            //Step 2: compute the prefix product array and store in res array
            // everything same as pref array
            res[0] = 1;
            for(int i=1; i<n; i++){
                res[i] = res[i-1] * nums[i-1];
            }

            //Step 3: compute the suffix product array and final result array together
            int postfix = 1; //this one work as suff[n-1] = 1
            for(int i=n-1; i>=0; i--){
                res[i] *= postfix; // we will multiply res here prefix array to postfix array to get final result
                postfix *= nums[i]; // update postfix for next iteration
            }

            //Return final result
            return res;
        }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        ProductExceptSelf solution = new ProductExceptSelf();
        System.out.println("Result: " + Arrays.toString(solution.productExceptSelf(nums)));
    }
}
