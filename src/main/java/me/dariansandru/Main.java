package me.dariansandru;

import me.dariansandru.parser.Parser;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        List<String> lines = parser.readFile("files/classes");
        parser.generateClasses(lines);
    }
}

//TODO make Enum, AbstractClass diagrams