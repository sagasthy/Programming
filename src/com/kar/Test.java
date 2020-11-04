package com.kar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Karthik", 30);
        map.put("Surekha", 27);
        System.out.println(sortMapByValues(map));
    }

    private static Map<String, Integer> sortMapByValues(Map<String, Integer> map){
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1,o2) -> o2.getValue().compareTo(o1.getValue()));
        Map<String, Integer> resultMap = new HashMap<>();
        for(Map.Entry<String, Integer> entry: entries)
            resultMap.put(entry.getKey(), entry.getValue());
        return resultMap;
    }

    private static boolean searchStringInFile(String inputFilePath, String searchWord) throws IOException {
        return Files.lines(Paths.get(inputFilePath)).parallel()
                .anyMatch(line -> line.contains(searchWord));
    }

    private static int getSecondHighestNum(int[] arr) {
        int result = 0;
        int highest = 0;
        for(int n: arr) {
            if (n > highest) {
                result = highest;
                highest = n;
            } else if(n == highest){
                // do nothing
            } else if(n > result){
                result = n;
            }
        }
        return result;
    }

    private static boolean compareArrays(int[] a, int[] b){
        Set<Integer> nums = Arrays.stream(a)
                            .boxed()
                            .collect(Collectors.toSet());

        for(int num: b)
            if(nums.add(num))
                return false;

        return true;

    }

    private static String reverse(String s) {
        char[] input = s.toCharArray();
        char[] output = new char[input.length];

        for(int i=0;i<input.length;i++)
            output[i] = input[input.length - 1 - i];

        return new String(output);
    }

    private static boolean isPrime(int num){
        if(num == 1)
            return false;

        for(int i=2; i*i<num; i++)
            if(num%i == 0)
                return false;

        return true;
    }

    private static int fibonacci(int num){
        if(num <= 1)
            return num;

        return fibonacci(num-1) + fibonacci(num-2);
    }

    private static boolean isPalindrome(String s){
        s = s.toLowerCase();
        char[] letters = s.toCharArray();

        for(int i=0; i<letters.length; i++)
            if(letters[i] != letters[letters.length - 1 - i])
                return false;

        return true;
    }

    private static String removeWhitespaces(String s){
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        for(char c: chars)
            if(c != ' ')
                sb.append(c);

        return sb.toString();
    }
}
