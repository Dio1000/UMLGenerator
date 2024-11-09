package me.dariansandru.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputDevice {
    public List<String> readFile(String file) {
        List<String> lineList = new ArrayList<>();

        try {
            File myFile = new File(file);
            Scanner reader = new Scanner(myFile);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (!data.isEmpty()) lineList.add(data);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return lineList;
    }
}
