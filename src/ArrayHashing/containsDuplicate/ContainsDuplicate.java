package ArrayHashing.containsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ContainsDuplicate {


    // 1. Brute Force Algo:

//    public static boolean hasDuplicate(int[] nums) {
//        for (int i=0; i < nums.length; i++){
//            for (int j=i+1; j <nums.length; j++){
//                if(nums[i]==nums[j]){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    //2. Sorting

//    public static boolean hasDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        for(int i =1; i< nums.length; i++){
//            if(nums[i] == nums [i-1]){
//                return true;
//            }
//        }
//        return false;
//    }

    //3. HashSet

//    public static boolean hasDuplicate(int[] nums) {
//        Set<Integer> seen = new HashSet<>();
//        for (int num : nums){
//            if(seen.contains(num)){
//                return true;
//            }
//            seen.add(num);
//        }
//        return false;
//    }

    //4. Java's Streams API hash set length

    public static boolean hasDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    // Main Class
    public static void main(String[] args){
        int[] nums = {1,2,3,3};
        System.out.println(hasDuplicate(nums));
    }

}
