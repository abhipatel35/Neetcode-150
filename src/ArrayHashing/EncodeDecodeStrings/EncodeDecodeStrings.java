package ArrayHashing.EncodeDecodeStrings;

import java.util.*;

public class EncodeDecodeStrings {

//solution 1:
//    public String encode(List<String> strs) {
//
//        // If the input list is empty, return an empty string "".
//        if (strs.isEmpty()) return "";
//
//        //Initialize Required Variables
//        StringBuilder result = new StringBuilder(); //A StringBuilder to efficiently construct the encoded string.
//        List<Integer> sizes = new ArrayList<>(); // A list to store the length of each string.
//
//        // Iterates through each string in strs and stores its length in sizes.
//        for (String str : strs){
//            sizes.add(str.length());
//        }
//
//        //Iterates through sizes and appends each length to result, followed by a comma , .
//        for(int size : sizes){
//            result.append(size).append(',');
//            //Example: sizes = [4, 4, 4, 3] , result becomes: "4,4,4,3,"
//        }
//
//        //  Mark the End of Lengths with #
//        result.append('#'); // Example: res becomes: "4,4,4,3,#"
//
//        // Append All Strings to the Encoded String
//        for (String str : strs){
//            result.append(str);
//        }
//
//        //Return the Encoded String
//        return result.toString();
//
//
//        // For input : ["neet", "code", "love", "you"]
//        // Encoding Steps:
//        // Compute sizes: [4,4,4,3]
//        // Convert to string format: "4,4,4,3,#neetcodeloveyou"
//    }
//
//    public List<String> decode(String str)  { // Takes an encoded string as a input
//
//        //Step 1: Handle Empty Input
//        if(str.length() == 0){
//            return new ArrayList<>();
//        }
//
//        //Step 2: initialize variable
//        List<String> result = new ArrayList<>(); // stores Decoded Strings
//        List<Integer> sizes = new ArrayList<>(); // Stores the length of Original Sizes
//        int i = 0;
//
//        // Step 3: Extraxt String lengths
//        //Iterates through str until it finds #, indicating the end of the size section
//        while (str.charAt(i) != '#'){
//            StringBuilder cur = new StringBuilder(); // cur: A temporary String to store each extracted number.
//            //Reads characters until it find a comma , ; building a string representation of a number.
//            while (str.charAt(i) != ','){
//                cur.append(str.charAt(i));
//                i++;
//            }
//            sizes.add(Integer.parseInt(cur.toString()));
//            i++;
//        }
//        i++;
//        //Step 4:  Extract Original Strings
//        for (int size : sizes) {
//            result.add(str.substring(i, i + size));
//            i += size;
//        }
//        return result; // Return the Decoded List
//    }




//solution 2: optimal
//Method 1: Encoding
    public String encode (List<String> strs){
        //initializ StringBuilder to store Encoded String
        StringBuilder res = new StringBuilder();
        //Iterate through strs for each String
        for(String s : strs){
            // appendthe length of string to res then append # to mark end of length and start of string itself then append string s to res
            res.append(s.length()).append('#').append(s);
        }
        //return encoded string
        return res.toString();
    }
        // Example: strs : ["neet", "code",....] , first append : 4#neet,4#code... , final encode string: "4#neet4#code..."

        //Method 2: Decoding
    public List<String> decode (String str){
        //Intialize to store decoded String
        List<String> res = new ArrayList<>();

        //i to track current position in string
        int i =0;
        //wxract the length of each string
        while(i < str.length()){
            // j to find the '#' delimiter
            int j = i;
            //find position of '#' by moving j forward until find #.
            while(str.charAt(j) != '#'){
                j++;
            }
            //The substring from i to j represents the length of string, so convert substring to interger for length
            int length = Integer.parseInt(str.substring(i,j));
            //After the '#' the next length character form the original string
            i = j+1;
            j = i +length;
            //Append substring to res;
            res.add(str.substring(i,j));
            //update i;
            i = j;
        }
        //return decode string
        return res;
    }





    public static void main(String[] args){
        EncodeDecodeStrings solution = new EncodeDecodeStrings(); // Create an instance

        List<String> strs = Arrays.asList("neet", "code", "love", "you"); // Correctly define input
        String encodedString = solution.encode(strs);
        System.out.println("Encoded: " + encodedString);

        List<String> decodedList = solution.decode(encodedString);
        System.out.println("Decoded: " + decodedList);
    }
}
