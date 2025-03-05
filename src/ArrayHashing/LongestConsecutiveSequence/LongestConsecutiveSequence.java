package ArrayHashing.LongestConsecutiveSequence;

import java.util.*;

public class LongestConsecutiveSequence {

//Solution 1: Brute Force

//    public int longestSequence(int[] nums){
//        //Step 1: Initialize the result variable 'res' to 0.
//        int res = 0;
//
//        //Step 2: Create a HashSet to store all unique numbers.
//        Set<Integer> store = new HashSet<>();
//
//        //Step 3: Loop through the input array and add each number to the HashSet.
//        for(int num : nums){
//            store.add(num);
//        }
//
//        //Step 4: Iterate through each number in the array to find the longest streak of consecutive numbers.
//        for(int num : nums){
//
//            //Step 5: Intialize variables
//            int streak = 0; // This will store the length of the current streak of consecutive numbers.
//            int curr = num; // This variable tracks the current number in the sequence.
//
//            //Step 6: Check if 'curr' is in the HashSet. If so, keep incrementing 'curr' to find consecutive numbers.
//            while(store.contains(curr)){
//                streak++;
//                curr++;
//            }
//
//            //Step 7: Update the result with the maximum streak length found so far.
//            res = Math.max(res, streak);
//        }
//
//        // Step 8: Return the longest streak found.
//        return res;
//    }





// Solution 2: Sorting

//    public int longestSequence(int[] nums){
//
//        // Step 1: Check if the input array is empty
//        if(nums.length == 0 ){
//            return 0;
//        }
//
//        //Step 2: Sort the given Array
//        Arrays.sort(nums);
//
//        //Step 3; Intialize necessary Variables
//        int res = 0; // This will store the length of the longest consecutive sequence found.
//        int curr = nums[0]; // This variable tracks the current number in the sequence.
//        int streak = 0; // his will store the length of the current streak of consecutive numbers.
//        int i = 0; // This is the index used to traverse through the sorted array.
//
//        //Step 4: traverse through the sorted array
//        while(i < nums.length){
//
//            // If current number (curr) is not equal to nums[i], it means we encountered a new number
//            if(curr != nums[i]){
//                curr = nums[i]; // Update curr to the new number
//                streak = 0; // Reset streak as we're starting a new sequence
//            }
//
//            // Step 5: Skip over duplicate numbers
//            while(i < nums.length && nums[i] == curr){
//                i++; // Move past all occurrences of the current number
//            }
//
//            streak++; // Increment streak for the current number
//            curr++; // Increment curr to check for the next consecutive number
//
//            // Step 6: Update the result with the maximum streak found so far
//            res = Math.max(res, streak);
//        }
//
//        // Step 7: Return the longest consecutive sequence length
//        return res;
//    }




//Solution 3: Hash Set

//    public int longestSequence(int[] nums){
//
//        // Variable to track the length of the longest consecutive sequence
//        int res = 0;
//
//        // Step 1: Create a HashSet to store unique numbers from the array
//        Set<Integer> store = new HashSet<>();
//        for(int num : nums){
//            store.add(num); // Add each number from the array to the set
//        }
//
//        // Step 2: Iterate through each number in the set
//        for(int num : store){
//            // Step 3: Check if the current number is the start of a sequence
//            if(!store.contains(num-1)){
//                // If the previous number (num - 1) is not in the set, it means `num` is the start of a sequence
//
//                int streak = 1; // Initialize the length of the current sequence
//
//                // Step 4: Check for consecutive numbers and extend the sequence
//                while(store.contains(num + streak)){
//                    streak++; // Increment the length as we find consecutive numbers
//                }
//
//                // Step 5: Update the longest sequence found so far
//                res = Math.max(res, streak);
//            }
//        }
//        // Step 6: Return the length of the longest consecutive sequence
//        return res;
//    }




//Solution 4:  Hash Map

    public int longestSequence(int[] nums){

        // Variable to track the length of the longest consecutive sequence
        int res = 0;

        // A HashMap mp is created where the key is an integer from the array, and the value is the length of the consecutive sequence that includes this integer.
        Map<Integer,Integer> mp = new HashMap<>();

        // Step 1: Iterate through each number in the input array
        for (int num : nums){
            // Step 2: If the number is not already in the map, process it
            if(!mp.containsKey(num)){
                // Step 3: Calculate the total length of the sequence that `num` belongs to
                mp.put(num, mp.getOrDefault(num-1, 0) + mp.getOrDefault(num+1, 0) + 1);
                // Explanation: For each number num, we check if it can be part of a larger consecutive sequence by looking at its neighbors, num - 1 and num + 1.
                //             mp.getOrDefault(num - 1, 0): This gets the length of the sequence that ends at num - 1 (if it exists) or returns 0 if num - 1 isn't part of a sequence.
                //             mp.getOrDefault(num + 1, 0): This gets the length of the sequence that starts at num + 1 (if it exists) or returns 0 if num + 1 isn't part of a sequence.
                //             We add 1 for the current number num itself to form a sequence.
                //             The value of mp.put(num, ...) stores the length of the sequence that num is part of.


                // Step 4: Update the boundaries of the sequence in the map
                // Join the sequences by connecting `num` with the previous and next numbers
                mp.put(num - mp.getOrDefault(num-1, 0), mp.get(num)); // Update the left boundary of the sequence
                mp.put(num + mp.getOrDefault(num+1, 0), mp.get(num)); // Update the right boundary of the sequence

                // Step 5: Update the result with the maximum sequence length found so far
                res = Math.max(res, mp.get(num));
            }
        }
        // Step 6: Return the length of the longest consecutive sequence
        return res;
    }

    public static void main(String[] args){
        int[] nums = {2,20,4,10,3,4,5};
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        System.out.println(solution.longestSequence(nums));
    }

}
