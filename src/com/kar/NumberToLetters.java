package com.kar;

import java.util.HashSet;
import java.util.Set;

public class NumberToLetters {
    public static void main(String[] args) {
        int num = 1234;
        Set<Integer> possibleStrings = findPossibleStrings(num);
        System.out.println(possibleStrings);

        // add 64 to the number to obtain the corresponding alphabetic character
        for(Integer number: possibleStrings)
            System.out.println((char) (number + 64));
    }

    private static Set<Integer> findPossibleStrings(int num) {
        Set<Integer> possibleStrings = new HashSet<>();
        String numStr = String.valueOf(num);
        findPossibleStrings(numStr, possibleStrings, 0, numStr.length());
        return possibleStrings;
    }

    private static void findPossibleStrings(String numStr, Set<Integer> possibleStrings, int start, int end) {
        if(start >= end)
            return;

        int choppedInt = Integer.parseInt(numStr.substring(start, end));

        if(choppedInt > 0 && choppedInt <= 26)
            possibleStrings.add(choppedInt);

        findPossibleStrings(numStr, possibleStrings, start+1, end);
        findPossibleStrings(numStr, possibleStrings, start, end-1);
    }
}
