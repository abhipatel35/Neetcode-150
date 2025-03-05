package TwoPointers.ValidPalindrome;

import ArrayHashing.ValidSudoku.ValidSudoku;

public class ValidPalindrome {

//Solution 1; Reverse String
//    public boolean isPalindrome(String s){
//        // Step 1: Create a StringBuilder to store the filtered characters
//        StringBuilder newStr = new StringBuilder();
//
//        // Step 2: Iterate through each character in the input string
//        for(char c : s.toCharArray()){
//            // Step 3: Check if the character is alphanumeric (letter or digit)
//            if(Character.isLetterOrDigit(c)){
//                // Step 4: Convert the character to lowercase and append it to newStr
//                newStr.append(Character.toLowerCase(c));
//            }
//        }
//        // Step 5: Compare the original filtered string with its reverse
//        return newStr.toString().equals(newStr.reverse().toString());
//    }




//Solution 2: Two Pointers

    public boolean isPalindrome(String s){
        // Step 1: Initialize two pointers: left (l) at start, right (r) at end
        int left = 0;
        int right = s.length() -1;

        while(left < right){
            //Step 2: Move left pointer forward if current character is NOT alphanumeric , we have created helper function alphaNum
            while(left < right && !alphaNum(s.charAt(left))){
                left++;
            }
            //Step 3: Move right pointer backward if current character is NOT alphanumeric
            while(right > left && !alphaNum(s.charAt(right))){
                right--;
            }
            //Step 4: Compare lowercase versions of characters at left and right
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false; // Not a palindrome
            }
            //Step 5: Move both pointers toward the center
            left++;
            right--;
        }
        return true; // If loop completes, it's a palindrome
    }
    // Helper function to check if a character is alphanumeric
    public boolean alphaNum(char c){
        return (c >= 'A' && c<= 'Z' ||   // Uppercase letters
                c >= 'a' && c<= 'z' ||   // Lowercase letters
                c >= '0' && c<= '9');    // Digits
    }


    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
//        String s = "tab a cat";
        ValidPalindrome solution = new ValidPalindrome();
        System.out.println(solution.isPalindrome(s));
    }
}
