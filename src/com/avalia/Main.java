package com.avalia;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        new Main().sortedWordCount("this is is is is new string with with rahul is is is rahul java code new scala c++ and");
        //new Main().sortedWordCount();

    }


    public void sortedWordCount() {
        sortedWordCount(input());
    }

    private String input() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    public void sortedWordCount(String str) {
        String[] extract = extract(str);
        Map<String,Integer> wordCounts = countByWord(extract);
        print(wordCounts);
    }

    private String[] extract(String str) {
        return str.split(" ");
    }


    private Map<String, Integer> countByWord(String[] arr) {
        Map<String, Integer> result = new TreeMap<>();

        for (String s : arr) {
            Integer count = result.get(s);
            if (count == null) {
                result.put(s, 1);
            } else {
                result.put(s, count + 1);
            }
        }
        return result;
    }



    private void print(Map<String,Integer> map) {
        for (Map.Entry s : map.entrySet()) {
            System.out.println(s.getKey()+"->"+s.getValue());
        }

    }
}
