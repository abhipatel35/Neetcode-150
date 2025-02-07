package ArrayHashing.TwoSum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {

    //1, Brute Force

//    public static int[] twoSum(int[] nums, int target) {
//        for(int i=0; i<nums.length; i++){
//            for(int j=i+1; j<nums.length; j++){
//                if(nums[i] + nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[0];
//    }

    //2. Sorting

//    public static int[] twoSum(int[] nums, int target) {
//
//        //creating 2D Array to store values and indices
//        int[][] A = new int[nums.length][2]; // create a 2D array A of size nums.length × 2
//        for (int i=0; i<nums.length; i++){
//            A[i][0] = nums[i]; //stores the number itself
//            A[i][1] = i; //stores the original index of that number
//        }
//
//        // if nums = [3, 1, 4, 2] , then new 2D Array A = [(A[i][0]),(A[i][1])] A = [ [3,0], [1,1], [4,2], [2,3] ]
//
//        //sorting the Array based on numbers
//        Arrays.sort(A, Comparator.comparingInt(a -> a[0])); // comparator.comparingInt(a -> a[0])---Specifies that sorting should be based on the first element a[0]= (A[i][0]).
//
//        //Using Two Pointers to Find the Target Sum
//        int i = 0, j = nums.length - 1;
//        while(i<j){
//            int cur = A[i][0] + A[j][0];
//            if(cur == target){
//                return new int[]{/*need to return indices in ascending order*/ Math.min(A[i][1], A[j][1]), Math.max(A[i][1], A[j][1])};
//            }
//            else if (cur<target){
//                i++;
//            }
//            else{
//                j--;
//            }
//        }
//        return new int[0]; //return empty array
//    }

    //3. Hash Map (Two Pass)

//    public static int[] twoSum(int [] nums, int target){
//        HashMap<Integer, Integer> map1 = new HashMap<>();
//
//        //create Entire HashMap before serching
//        for (int i=0; i<nums.length; i++){
//            map1.put(nums[i], i);
//        }
//
//        for(int i=0; i<nums.length; i++){
//            int diff = target -nums[i];
//            if (map1.containsKey(diff) && map1.get(diff) !=i){
//                return new int[]{i, map1.get(diff)};
//            }
//        }
//        return new int[0];
//    }

    //4. Hash Map (One Pass)

    public static int[] twoSum(int[] nums, int target) {
        //searches and Build the map simultaneously
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map2.containsKey(complement)) {
                return new int[]{map2.get(complement), i};
            }
            map2.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args){
        int[] nums = {3,4,5,6};
        int target = 7;
        System.out.println(Arrays.toString(twoSum(nums,target))); // .toString method to get readable output
    }
}
