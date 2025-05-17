package com.basavarajpatil;

import com.basavarajpatil.interfaces.Decoder;
import com.basavarajpatil.interfaces.Encoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncoderDecoder implements Encoder, Decoder {
    @Override
    public String encode(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String decode(String data) {
        return new String(Base64.getDecoder().decode(data));
    }
}
