package me.dariansandru.io;

import java.io.*;
import java.util.List;

public class OutputDevice {
    public void writeToFile(List<String> list, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : list) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Could not write to file.");
        }
    }

    public void appendToFile(List<String> list, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (String line : list) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Could not write to file.");
        }
    }

    public void emptyFile(String fileName) {
        try{
            File file = new File(fileName);
            if (file.exists()){
                if (!file.delete()){
                    throw new IOException("Could not delete " + fileName);
                }
            }

            File parent = file.getParentFile();
            if (!parent.exists()){
                if (!parent.mkdirs()){
                    throw new IOException("Could not create directory for " + fileName);
                }
            }

            if (!file.createNewFile()) throw new IOException("Could not create empty file.");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
