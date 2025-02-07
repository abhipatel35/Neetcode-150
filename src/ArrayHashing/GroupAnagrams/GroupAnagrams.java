package ArrayHashing.GroupAnagrams;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class GroupAnagrams {

    //1. sorting

//    //function returns a list of lists containing grouped anagrams.
//    public static List<List<String>> hasGroupAnagrams(String[] strs) {
//        //  HashMap <Key, Value>
//        HashMap<String, List<String>> sortingmap = new HashMap<>();
//        // loop through each word s in the given list of string strs.
//        for (String s : strs){
//
//            //Step 1: Sort each word:
//
//            // convert word into char array
//            char[] charArray = s.toCharArray();
//            // Sort the characters
//            Arrays.sort(charArray);
//            //convert back to a string
//            String sortedS = new String(charArray);
//
//
//            //Step 2: Storing Anagram Groups in HashMap
//
//            // If sortedS is not already a key in sortingmap HashMap then create a new list.
//            sortingmap.putIfAbsent(sortedS, new ArrayList<>());
//            // Add the original word s to the corresponding list.
//            sortingmap.get(sortedS).add(s);
//        }
//        return new ArrayList<>(sortingmap.values());
//    }

    //2. Hash Table (Character Frequency Count)

    public static List<List<String>> hasGroupAnagrams(String[] strs){
        HashMap<String, List<String>> map1 = new HashMap<>();

        for (String s : strs){
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);

            map1.putIfAbsent(key, new ArrayList<>());
            map1.get(key).add(s);
        }
        return new ArrayList<>(map1.values());
    }

    public static void main(String[] args){
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        System.out.println(hasGroupAnagrams(strs));
    }
}
