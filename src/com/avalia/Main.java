package com.avalia;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //new Main().sortedWordCount("this is is is is new string with with rahul");
        new Main().sortedWordCount();

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
        WordCount[] wordCounts = countByWord(extract);
        WordCount[] sort = sort(wordCounts);
        print(sort);
    }

    private String[] extract(String str) {
        // TODO : will implement later
        String[] result = new String[10];
        char[] array = str.toCharArray();
        int intPos = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                result[intPos] = sb.toString();
                sb = new StringBuilder();
                intPos++;
            } else {
                sb.append(array[i]);
            }
        }
        result[intPos] = sb.toString();
        return result;
    }

    private WordCount[] countByWord(String[] arr) {
        WordCount[] result = new WordCount[10];
        int pos = 0;
        String word = "";
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            word = arr[i];
            if (word == null) {
                continue;
            }
            for (int j = i; j < arr.length; j++) {
                if (word.equals(arr[j])) {
                    arr[j] = null;
                    count++;
                }
            }

            result[pos] = new WordCount(word, count);
            pos++;
            word = "";
            count = 0;
        }

        return result;
    }

    private WordCount[] sort(WordCount[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                WordCount first = arr[i];
                WordCount second = arr[j];
                if (first == null || second == null) {
                    continue;
                }
                int comp = first.word.compareToIgnoreCase(second.word);
                if (comp < 0) {
                    WordCount temp;
                    temp = first;
                    arr[i] = second;
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private void print(WordCount[] arr) {
        for (WordCount s : arr) {
            System.out.println(s);
        }

    }
}
