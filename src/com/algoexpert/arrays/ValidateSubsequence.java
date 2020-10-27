package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {

    public static void main(String[] args) {
        // Input array, sequence; Output: true
        List<Integer> array = Arrays.asList(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = Arrays.asList(1,6,-1,10);

        boolean isValidSubsequence = isValidSubsequence(array, sequence);

        System.out.println(isValidSubsequence);
    }

    // O(n) time, O(1) space
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrIndex = 0;
        int seqIndex = 0;

        while(arrIndex < array.size() && seqIndex < sequence.size()){
            if(array.get(arrIndex).equals(sequence.get(seqIndex))){
                seqIndex++;
            }
            arrIndex++;
        }

        return seqIndex == sequence.size();
    }

    // O(n) time, O(1) space
    public static boolean isValidSubsequencev2(List<Integer> array, List<Integer> sequence) {
        int sequenceIndex = 0;

        for(Integer num: array){
            if(sequenceIndex == sequence.size())
                break;

            if(sequence.get(sequenceIndex).equals(num))
                sequenceIndex++;
        }

        return sequenceIndex == sequence.size();
    }
}
