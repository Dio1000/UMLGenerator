package me.dariansandru;

import me.dariansandru.io.InputDevice;
import me.dariansandru.io.OutputDevice;
import me.dariansandru.parser.Parser;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) throw new IllegalStateException("Not enough arguments provided!");

        InputDevice inputDevice = new InputDevice();
        OutputDevice outputDevice = new OutputDevice();

        if (Objects.equals(args[0], "parse") && args.length == 2){
            try{
                Parser parser = new Parser();
                List<String> lines = inputDevice.readFile(args[1]);
                parser.generateClasses(lines);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else if (Objects.equals(args[0], "parse") && args.length == 3){
            try{
                Parser parser = new Parser();
                List<String> lines = inputDevice.readFile(args[1]);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            throw new IllegalStateException("Could not find command: " + args[0]);
        }
    }
}

//TODO make Enum, AbstractClass diagrams