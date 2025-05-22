package com.basavarajpatil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Tokenizer {


    public List<String> createTokens(String input) {

        return Arrays.stream(input.toLowerCase().split("[\\s\\p{Punct}]+"))
                .filter(token -> !token.isEmpty())
                .collect(Collectors.toList());

    }
}
