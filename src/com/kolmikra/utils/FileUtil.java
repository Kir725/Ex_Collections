package com.kolmikra.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileUtil {
    private static Map<String,Integer> wordsContainer = new TreeMap<>();
    private static Map<String,List<String>> linesContainer = new HashMap<>();
    private static Set<String> wordsSet = new HashSet<>();

    public static Map<String,Integer> countFrequency(String path)  {
        String contents = "";
        try {
            contents = Files.readString(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!"".equals(contents)){
            String[] words = contents.toLowerCase().split("\\PL+");
            for(String word : words){
                wordsContainer.merge(word , 1, Integer::sum);
            }
        }
        return wordsContainer;
    }
    public static Map<String,List<String>> getLinesForWords(String path) {
        String contents = "";
        try {
            contents = Files.readString(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!"".equals(contents)) {
            String[] words = contents.toLowerCase().split("\\PL+");
            wordsSet.addAll(Arrays.asList(words));
            for(String word: wordsSet){
                linesContainer.put(word,getLines(word,contents));
            }

        }
        return linesContainer;
    }
    private static List<String> getLines(String word,String contents){
        List<String> linesWithWord = new ArrayList<>();
        String[] lines = contents.toLowerCase().split(System.getProperty("line.separator"));
        for (String line:lines){
            if(line.contains(word))
                linesWithWord.add(line);
        }
        return linesWithWord;
    }
}

