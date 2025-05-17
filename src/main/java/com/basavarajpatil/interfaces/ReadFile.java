package com.basavarajpatil.interfaces;

import java.io.IOException;
import java.util.List;

public interface ReadFile {

    public List<String> readFile(String fileName) throws IOException;
}
