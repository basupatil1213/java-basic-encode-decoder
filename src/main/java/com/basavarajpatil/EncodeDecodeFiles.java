package com.basavarajpatil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class EncodeDecodeFiles {

    public static void main(String[] args) throws IOException {
//        List<String> lines_lst = readFile("/Users/basavarajpatil/Desktop/clean up desktop/2025/courses/intro-to-ai-agents/assignment-1-encode-n-decode-input/src/main/resources/Moby Dick; Or, The Whale by Herman Melville");
        List<String> lines_lst = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lines_lst.add("My Name is Basavaraj Patil" + i);
        }

        System.out.println("Input Strings: " + lines_lst);
        List<String> encodedStrings = new ArrayList<>();
        lines_lst.forEach((line) -> {
            encodedStrings.add(tokenize(line));
        });

        System.out.println("Encoded String:    " + encodedStrings);

//        Decode

        List<String> decodedStrings = new ArrayList<>();

        encodedStrings.forEach((encodedString) -> {
            decodedStrings.add(new String(Base64.getDecoder().decode(encodedString)));
        });

        System.out.println("Decoded String: " + decodedStrings);

        System.out.println("Check for same content");

        if (isSameContent(lines_lst, decodedStrings)) {
            System.out.println("Same content");
        }
        else {
            System.out.println("Different content");
        }


    }

    public static boolean isSameContent(List<String> actualContent, List<String> expectedContent) {
        for (int i = 0; i < actualContent.size(); i++) {
            if (!actualContent.get(i).equals(expectedContent.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static List<String> readFile(String fileName) throws IOException {

        File file = new File(fileName);
        ;

        return new ArrayList<>(Files.readAllLines(file.toPath()));
    }

    public static String tokenize(String data){

        return Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }

    public static void encode(List<String> data_list){}

    public static void decode(List<String> data_list){}
}
