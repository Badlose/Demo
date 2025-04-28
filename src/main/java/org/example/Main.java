package org.example;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String palindrome = "skypro skyproorpyks orpyks";
        String notPalindrome = "skyproorpykss";

        System.out.println(checkViaStreamAPI(palindrome));
        System.out.println(checkViaStreamAPI(notPalindrome));

        System.out.println(checkViaCycle(palindrome));
        System.out.println(checkViaCycle(notPalindrome));

        System.out.println(checkReverseViaCycle(palindrome));
        System.out.println(checkReverseViaCycle(notPalindrome));

        System.out.println(checkReverseChecker(palindrome));
        System.out.println(checkReverseChecker(notPalindrome));

        System.out.println(checkViaRecursive(palindrome));
        System.out.println(checkViaRecursive(notPalindrome));

    }

    public static boolean checkViaStreamAPI(String s) {
        return IntStream
                .range(0, s.length() / 2)
                .allMatch(i -> s.charAt(i) == s.charAt(s.length() - i - 1));
    }

    public static boolean checkViaCycle(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean checkReverseViaCycle(String s) {
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return s.contentEquals(reversed);
    }

    public static boolean checkReverseChecker(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        String reversed = stringBuilder.reverse().toString();
        return s.equals(reversed);
    }

    public static boolean checkViaRecursive(int i, int j, String s) {
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        return checkViaRecursive(i + 1, j - 1, s);
    }

    public static boolean checkViaRecursive(String s) {
        return checkViaRecursive(0, s.length() - 1, s);
    }
}