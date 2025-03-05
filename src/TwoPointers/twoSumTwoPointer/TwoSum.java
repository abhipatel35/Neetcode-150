package TwoPointers.twoSumTwoPointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

//Solution 1: Brute Force
//    public int[] twoSum(int[] numbers, int target){
//        for(int i = 0; i < numbers.length ; i++){
//            for(int j = i + 1; j < numbers.length ; j++){
//                if(numbers[i] + numbers[j] == target){
//                    return new int[] {i+1, j+1};
//                }
//            }
//        }
//        return new int[0];
//    }



//Solution 2: Binary Search Tree
//    public int[] twoSum(int[] numbers, int target){
//        //Step 1: Iterate through each element as a potential first number
//        for(int i = 0 ; i < numbers.length ; i++){
//
//            //Step 2: Intialize necessary Variables
//            int l = i+1, r = numbers.length-1;
//            int tmp = target - numbers[i];
//
//            //Step 3: Perform binary search for 'tmp' in the range [l, r]
//            while(l <= r){
//
//                // Find Mid and (r-l) is to Avoids potential integer overflow
//                int mid = l + (r-l)/2 ;
//
//                //If mid is equal tp tmp needed then return our final result
//                if(numbers[mid] == tmp){
//                    return new int[] {i+1, mid+1};
//                }
//                //else if mid is less than tmp needed then our answer is in right part of the binary tree
//                else if (numbers[mid] < tmp){
//                    l = mid + 1;
//                }
//                //else if mid is greater than tmp needed then our answer is in left part of the binary tree
//                else{
//                    r = mid -1;
//                }
//            }
//        }
//        // Return empty array if no solution is found
//        return new int[0];
//    }



//Solution 3: HashMap
//    public int[] twoSum(int[] numbers, int target){
//        // Create a HashMap to store numbers and their respective indices
//        Map<Integer, Integer> mp = new HashMap<>();
//
//        // Iterate through the numbers array
//        for(int i = 0; i < numbers.length; i++){
//
//            // Compute the complement (number required to reach the target)
//            int tmp = target - numbers[i];
//
//            // Check if the complement exists in the map
//            if (mp.containsKey(tmp)){
//                // If found, return the stored index of the complement and the current index (+1 for 1-based index)
//               return new int[] {mp.get(tmp), i+1};
//            }
//
//            // Otherwise, store the current number with its index (+1 for 1-based index)
//            mp.put(numbers[i], i+1);
//        }
//        // Return empty array if no solution is found
//        return new int[0];
//    }




//Solution 4: Two Pointers
    public int[] twoSum(int[] numbers, int target){

        //Step 1: Intialize Varibles
        int l = 0, r = numbers.length-1;

        //Iterate through each element from both sides
        while(l<r){

            //Get current sum based on both side values
            int currSum = numbers[l] + numbers[r];

            //If current sum is more than target we want then need to reduce value for that we need to reduce index from right side as its non-decreasing array
            if(currSum>target){
                r--;
            }
            //If current sum id less than target we want then need to increase value for that we need to increase index from left side
            else if(currSum < target){
                l++;
            }
            // else if current sum == target then return final output
            else{
                return new int[] {l+1, r+1};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        int target = 3;
        TwoSum solution = new TwoSum();
        System.out.println(Arrays.toString(solution.twoSum(numbers , target)));
    }
}
