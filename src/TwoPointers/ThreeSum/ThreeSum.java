package TwoPointers.ThreeSum;

import java.util.*;

public class ThreeSum {

//Solution 1: Brute Force
//    public List<List<Integer>> threeSum(int[] nums){
//        Set<List<Integer>> res = new HashSet<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++){
//            for (int j = i+1; j < nums.length; j++){
//                for(int k = j+1; k < nums.length; k++){
//                    if (nums[i] + nums[j] + nums[k] == 0){
//                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
//                        res.add(tmp);
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(res);
//    }



//Solution 2: HashMap
//    public List<List<Integer>>  threeSum(int[] nums){
//        //Step 1: Sort the Array to make it easier to avoid Duplicates.
//        Arrays.sort(nums);
//
//        //Step 2: Create a HashMap to count occurrences of each number
//        Map<Integer,Integer> count = new HashMap<>();
//        for(int num : nums){
//            count.put(num, count.getOrDefault(num,0) +1);
//        }
//
//        //Step 3: Intialize result list to store unique triplets;
//        List<List<Integer>> res = new ArrayList<>();
//
//        //Step 4: Iterate over the array with the first number (nums[i]).
//        for(int i=0; i < nums.length; i++){
//            //Reduce the count of the current number since its being used.
//            count.put(nums[i], count.get(nums[i]) - 1);
//            //Skip the duplicate elements to avoid duplicate triplets
//            if(i > 0 && nums[i] == nums[i-1]) continue;
//
//            //Step 5: Iterate over the array with the second number (nums[j]).
//            for(int j = i + 1; j < nums.length; j++){
//                //Reduce the count of the current number since its being used.
//                count.put(nums[j], count.get(nums[j]) - 1);
//                //Slip the duplicate elements to avoid duplicate triplets.
//                if(j > i+1 && nums[j] == nums[j-1]) continue;
//
//                //Step 6: Compute the required third number to sum to zero.
//                int target = -(nums[i] + nums[j]);
//
//                //Step 7: Check if the third number exists in the HashMap.
//                if(count.getOrDefault(target, 0) > 0){
//                    res.add(Arrays.asList(nums[i], nums[j], target));
//                }
//            }
//
//            //Step 8: Restore counts for nums[j] before moving to next i.
//            for(int j = i+1; j < nums.length; j++){
//                count.put(nums[j], count.get(nums[j]) + 1);
//            }
//        }
//
//        //Step 9: Return the final list of triplets.
//        return res;
//    }



//Solution 3: Two Pointers
    public List<List<Integer>> threeSum(int[] nums){
        //Step 1: Sort the Array
        Arrays.sort(nums);

        //Step 2: Create result Array list for final output
        List<List<Integer>> res = new ArrayList<>();

        //Step 3: Iterate over the Array for the first element (nums[i])
        for(int i = 0; i < nums.length; i++){
            // If the current number is greater than 0, break because further numbers will only increase the sum.
            if (nums[i] > 0) break;
            //Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i-1]) continue;

            //step 4: Use two-pointer approach to find the remaining two numbers. Create left and right pointer to find other two elements
            int l = i+1, r = nums.length - 1;
            //Step 5: Iterate over array with two pointers to find two elements (nums[l] & nums[r])
            while(l < r){
                //final sum equation
                int sum = nums[i] + nums[l] + nums[r];
                //If sum is more than zero means need to reduce value and array is sorted so come back from right side
                if(sum > 0){
                    r--;
                }
                // If sum is less than zero then need to increase value so for that move forward from left side(just visualize all this in your mind)
                else if(sum < 0){
                    l++;
                }
                // If sum equal to zero so return the final output
                else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    //Move both pointers inward to find the next unique triplet.
                    l++;
                    r--;

                    // Skip duplicate values for `l` to avoid duplicate triplets.
                    while(l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                }
            }
        }
        // Step 5: Return the list of unique triplets.
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSum(nums));
    }
}
