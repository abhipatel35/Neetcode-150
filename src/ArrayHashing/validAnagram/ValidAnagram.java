package ArrayHashing.validAnagram;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    //1. sorting

//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()){
//            return false;
//        }
//
//        char[] sCharArray = s.toCharArray();
//        char[] tCharArray = t.toCharArray();
//
//        Arrays.sort(sCharArray);
//        Arrays.sort(tCharArray);
//
//        return Arrays.equals(sCharArray, tCharArray);
//    }

    //2. Hash Table

    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for(int i=0; i< s.length(); i++){
            countS.put(s.charAt(i) , countS.getOrDefault(s.charAt(i),0) + 1);
            countT.put(t.charAt(i) , countT.getOrDefault(t.charAt(i),0) + 1);
        }
        return countS.equals(countT);
    }

    // Main Class
    public static void main(String[] args){
        String s = "racecar";
        String t = "carrace";
        System.out.println(isAnagram(s, t));
    }
}
