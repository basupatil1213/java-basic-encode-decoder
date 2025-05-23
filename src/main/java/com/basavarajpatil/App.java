package com.basavarajpatil;

import java.util.*;

public class App {

    private final EncoderDecoder encoderDecoder;

    public App(){
        this.encoderDecoder = new EncoderDecoder();
    }

    public static void main(String[] args) {

        App app = new App();

        app.train_data();

        app.encode_decoder();

    }

    public void train_data(){
        Tokenizer tokenizer = new Tokenizer();

        String[] filePaths = new String[]{"src/main/resources/Moby Dick; Or, The Whale by Herman Melville",
                "src/main/resources/The Blue Castle: a novel by L. M. Montgomery",
                "src/main/resources/Wake by Robert J. Sawyer"};

        Set<String> allTokens = new TreeSet<>();

        System.out.println("Reading and tokenizing pre-training files...");
        for (String filePath : filePaths) {
            String fileContent = FileOperator.readFile(filePath);
            List<String> tokens = tokenizer.createTokens(fileContent);
            allTokens.addAll(tokens);
        }

        System.out.println("Loaded " + allTokens.size() + " tokens from: " + Arrays.toString(filePaths));

        encoderDecoder.addToVocabulary(allTokens);

        System.out.println("Successfully Trained the model with the data");
    }

    public void encode_decoder(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Please Enter the Text to Encode: \n");

            String textInput = scanner.nextLine();

            String encodedText = encoderDecoder.encode(textInput);
            if (textInput.equalsIgnoreCase("/bye")) break;
            System.out.println("Encoded Text: \n" + encodedText);

            System.out.println("Please enter the text to decode: \n");

            String encodedTextInput = scanner.nextLine();

            if (encodedTextInput.equalsIgnoreCase("/bye")) break;

            String decodedText = encoderDecoder.decode(encodedTextInput);

            System.out.println("Decoded Text: \n" + decodedText);
        }
    }
}
