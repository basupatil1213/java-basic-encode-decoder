package com.basavarajpatil;

import com.basavarajpatil.interfaces.ReadFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements ReadFile{
    @Override
    public List<String> readFile(String filepath) throws IOException {
        File file = new File(filepath);
        return new ArrayList<>(Files.readAllLines(file.toPath()));
    }

    public List<String> tokenize(String text) {
        return List.of(text.split(" "));
    }
}
