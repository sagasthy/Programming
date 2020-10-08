package com.kar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseNumber {

    public static void main(String[] args) {
        int n = 793;
        System.out.println(reverseWithoutAPI(n));
    }

    private static int reverseWithoutAPI(int n) {
        int temp = n;
        int reverse = 0;

        while(temp != 0){
            reverse = reverse*10 + temp%10;
            temp /= 10;
        }
        return reverse;
    }

    private static int reverseUsingStreams(int n) {

        // convert the int to String
        // split it into chars
        // convert each character to corresponding int using character - '0'
        // collect into a list
        List<Integer> digits = Integer.toString(n)
                .chars()
                .map(character -> character - '0')
                .boxed()
                .collect(Collectors.toList());

        // reverse the elements of the list
        Collections.reverse(digits);

        // convert the integer list to a string, then to a numeric value and return it
        return Integer.parseInt(
                    digits.stream()
                    .map(digit -> new String(String.valueOf(digit)))
                    .collect(Collectors.joining())
                );
    }
}
