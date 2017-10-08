package com.example.starlitya.onlineassement.practice;


/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

 */
public class Valid_Palindrome_Jerry {

    private static final int LETTER_CASE_BIAS = ('A' - 'a');

    public boolean isPalindrome(String s) {
        //Assume empty string as valid
        if (s == null || s.isEmpty()) {
            return true;
        }

        char [] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while(left < right) {
            if (!isValidChar(chars[left])) {
                left++;
                continue;
            } else if (!isValidChar(chars[right])) {
                right--;
                continue;
            } else {
                char c1 = chars[left];
                char c2 = chars[right];
                if(isLetter(c1) && isLetter(c2)) {
                    boolean isSame = ( c1 == c2 || c1+LETTER_CASE_BIAS == c2
                            || c2 +LETTER_CASE_BIAS == c1);
                    if (!isSame) {
                        return false;
                    }
                } else {
                    if (c1 != c2) {
                        return false;
                    }
                }
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isValidChar(char c) {
        if(isNum(c) || isLetter(c)) {
            return true;
        }

        return false;
    }

    private boolean isNum(char c) {
        if ('0' <= c && c <= '9') {
            return true;
        }
        return false;
    }

    private boolean isLetter(char c) {
        if ('a' <= c && c <= 'z') {
            return true;
        }
        else if ('A' <= c && c <= 'Z') {
            return true;
        }
        return false;
    }

}