package com.basavarajpatil;

import java.util.*;

public class EncoderDecoder implements Encoder, Decoder {

    private final Map<String, String> idToTokenMap = new  HashMap<>();
    private final Map<String, String> tokenToIdMap = new  HashMap<>();
    private final String SEPARATOR = " ";


    @Override
    public String decode(String input) {
        StringBuilder output = new StringBuilder();
        for (String tokenId : input.split(SEPARATOR)) {
            String token = this.idToTokenMap.getOrDefault(tokenId, "|unk|");
            if (Objects.equals(token, "|end|")) break;
            output.append(token).append(SEPARATOR);
        }

        return output.toString();
    }

    @Override
    public String encode(String data) {

        Tokenizer tokenizer = new Tokenizer();
        StringBuilder encoded = new StringBuilder();

        List<String> tokens = tokenizer.createTokens(data.toLowerCase());
        for (String token : tokens) {
            if (this.tokenToIdMap.containsKey(token)) {
            encoded.append(this.tokenToIdMap.get(token));
            }else {
                encoded.append(this.tokenToIdMap.get("|unk|"));
            }
            encoded.append(SEPARATOR);
        }
        encoded.append(this.tokenToIdMap.get("|end|"));

        return encoded.toString();
    }

    public void addToVocabulary(Set<String> tokens) {

        Set<String> vocabularyTokens = new HashSet<>(tokens);

        int vocabularyId = this.idToTokenMap.size();

        for (String token : vocabularyTokens) {
            if (!this.tokenToIdMap.containsKey(token)) {
                idToTokenMap.put(String.valueOf(vocabularyId), token);
                tokenToIdMap.put(token, String.valueOf(vocabularyId));
                vocabularyId++;
            }
        }

        String[] defaultVals = new String[]{"|unk|", "|end|"};

        for (String vals : defaultVals) {

            if (!this.tokenToIdMap.containsKey(vals)) {
                idToTokenMap.put(String.valueOf(vocabularyId), vals);
                tokenToIdMap.put(vals, String.valueOf(vocabularyId));
                vocabularyId++;
            }
        }
    }
}
