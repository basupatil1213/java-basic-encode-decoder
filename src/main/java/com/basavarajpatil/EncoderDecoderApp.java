package com.basavarajpatil;

import com.basavarajpatil.interfaces.ReadFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EncoderDecoderApp {
    public static void main(String[] args) {


        read_and_tokenize();
        encode_and_decode();
    }

//    Task 1: Read and tokenize the input Files

    public static void read_and_tokenize() {
        String[] filePaths = new String[] {"src/main/resources/Moby Dick; Or, The Whale by Herman Melville","src/main/resources/The Blue Castle: a novel by L. M. Montgomery", "src/main/resources/Wake by Robert J. Sawyer"};
        FileReader fileReader = new FileReader();

        List<List<String>> tokens = new ArrayList<>();

        try {


            for (String filePath : filePaths) {
                for (String line : fileReader.readFile(filePath)) {
                    tokens.add(fileReader.tokenize(line));
                }

            }
        }
        catch (IOException e) {
            System.out.println("Exception occurred while reading file: " + e.getMessage());
        }

//        Print the tokenized file

        for (List<String> token : tokens) {
            System.out.println(token.toString());
        }
    }

    public static void encode_and_decode() {
        Scanner scanner = new Scanner(System.in);

        EncoderDecoder encoderDecoder = new EncoderDecoder();
        System.out.println("Enter the string to be encoded: \n");
        String input = scanner.nextLine();
        System.out.println("input: \n" + input);
        String encodedString = encoderDecoder.encode(input);

        System.out.println("Encoded string: \n" + encodedString);

        System.out.println("Enter the string to be decoded: ");
        input = scanner.nextLine();
        String decodedString = encoderDecoder.decode(input);
        System.out.println("Decoded string: \n" + decodedString);



    }
}
