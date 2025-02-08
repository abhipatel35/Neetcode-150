package ArrayHashing.TopKFrequentElements;

import java.util.*;

public class TopKFrequentElements {

    // 1. SORTING

//     public static int[] topKFrequent(int[] nums, int k) {
//
//         // Step 1: Count the frequency of each element
//         HashMap<Integer, Integer> countN = new HashMap<>();
//         for(int num : nums){
//             countN.put(num, countN.getOrDefault(num,0)+1);
//         }
//
//         //Step 2: Store Frequency-Number Pairs in a List
//         List<int[]> arr = new ArrayList<>();
//         // Map.Entry<K, V> is an interface in Java that represents a key-value pair from a Map.
//         // A HashMap stores key-value pairs (K → V), and entrySet() returns a Set of all entries (pairs).
//         for (Map.Entry<Integer, Integer> entry : countN.entrySet()){
//             arr.add(new int[] {entry.getValue()/*frequeny of the number*/, entry.getKey()/*the actual number*/});
//         }
//
//         //Step 3: Sort the List in Descending order by Frequency
//         arr.sort((a,b) -> b[0] - a[0]);
//
//         //Step 4: Extract the top K Frequent Elements
//         int[] result = new int[k]; //create an array result of size k.
//         for(int i=0; i<k; i++){
//             result[i] = arr.get(i)[1]; // contains the actual number, we store it in result
//         }
//         return result;
//     }


    //2. HEAP

     public static int[] topKFrequent(int[] nums, int k){

         //same step 1
         HashMap<Integer,Integer> countN = new HashMap<>();
         for (int num : nums){
             countN.put(num, countN.getOrDefault(num, 0) +1);
         }

         //Step 2: Use a Min-Heap (PriorityQueue) to Keep the Top k Frequent Elements
         PriorityQueue<int[]> heapQ = new PriorityQueue<>((a,b) -> a[0] -b[0]);// The comparator : ensures that the heap sorts elements by frequency in ascending order.
         for(Map.Entry<Integer, Integer> entry : countN.entrySet()){
             // push each (frequency, number) pair into the heap.
             heapQ.offer(new int[] {entry.getValue(), entry.getKey()});
             //If the heap size exceeds k, we remove (poll) the smallest element (lowest frequency).
             if (heapQ.size() > k){
                 heapQ.poll();
             }
         }

         //Step 3: create an array result of size k
         int[] result = new int[k];
         for (int i =0 ; i<k; i++){
             // Extract Elements from the Heap (removing the most frequent first)
             result[i] = heapQ.poll()[1]; // Since we stored elements as {frequency, number}, we return only number
         }
         return result;
     }


    //3. BUCKET SORT

//    public static int[] topKFrequent(int[] nums,  int k){
//
//        // same step 1
//        HashMap<Integer, Integer> countN = new HashMap();
//        for(int num : nums){
//            countN.put(num , countN.getOrDefault(num,0) +1);
//        }
//
//        // Step 2: Create a Bucket Array to Store Elements Based on Frequency
//        // We create an array of lists (freq) where freq[i] will store numbers that appear i times.
//        List<Integer>[] freq = new List[nums.length + 1]; // Since an element can appear at most nums.length times, we create an array of size nums.length + 1.
//        for(int i=0; i< freq.length; i++){
//            freq[i] = new ArrayList<>();
//        }
//
//        //Step 3:  Fill the Buckets Based on Frequency
//        for(Map.Entry<Integer, Integer> entry : countN.entrySet()){
//            freq[entry.getValue()].add(entry.getKey());
//        }
//
//        //Step 4: Collect the Top k Frequent Elements by creating an array result of size k.
//        int[] result = new int[k];
//        int index = 0;
//        for(int i = freq.length -1; i > 0 && index <k; i--){
//            for (int num : freq[i]){
//                result[index++] = num; // Adds the current number num to the result array res at position index. Increments index after adding n so the next number goes into the next position.
//                if (index == k){
//                    return result;
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args){
        int[] nums = {1,2,2,3,3,3}; int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

}
