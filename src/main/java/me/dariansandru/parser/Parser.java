package me.dariansandru.parser;

import me.dariansandru.domain.diagram.AbstractClassDiagram;
import me.dariansandru.domain.diagram.ClassDiagram;
import me.dariansandru.domain.diagram.InterfaceDiagram;
import me.dariansandru.domain.factory.DiagramFactory;
import me.dariansandru.io.InputDevice;
import me.dariansandru.io.OutputDevice;
import me.dariansandru.ui.AbstractClassDisplay;
import me.dariansandru.ui.ClassDisplay;
import me.dariansandru.ui.EnumDisplay;
import me.dariansandru.ui.InterfaceDisplay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Parser {

    InputDevice inputDevice = new InputDevice();
    OutputDevice outputDevice = new OutputDevice();

    public void generateClasses(List<String> lineList){
        List<String> classes = new ArrayList<>();
        List<String> interfaces = new ArrayList<>();
        List<String> abstractClasses = new ArrayList<>();
        List<String> enums = new ArrayList<>();

        Map<String, List<String>> classAttributesDetails = new HashMap<>();
        Map<String, List<String>> classMethodsDetails = new HashMap<>();

        List<String> warnings = new ArrayList<>();

        boolean attributeState = false;
        boolean methodState = false;
        String lastReadClass = null;

        int index = 0;
        while (index < lineList.size()){
            String line = lineList.get(index);
            line = line.strip();
            line = line.trim().replace(":", "");

            if (line.equalsIgnoreCase("Interface")){
                interfaces.add(lineList.get(index + 1));
                lastReadClass = lineList.get(index + 1);

                classAttributesDetails.put(lastReadClass, new ArrayList<>());
                classMethodsDetails.put(lastReadClass, new ArrayList<>());

                index++;
                continue;
            }

            if (line.equalsIgnoreCase("Class")){
                classes.add(lineList.get(index + 1));
                lastReadClass = lineList.get(index + 1);

                classAttributesDetails.put(lastReadClass, new ArrayList<>());
                classMethodsDetails.put(lastReadClass, new ArrayList<>());

                index++;
                continue;
            }

            if (line.equalsIgnoreCase("Abstract Class")){
                abstractClasses.add(lineList.get(index + 1));
                lastReadClass = lineList.get(index + 1);

                classAttributesDetails.put(lastReadClass, new ArrayList<>());
                classMethodsDetails.put(lastReadClass, new ArrayList<>());

                index++;
                continue;
            }

            if (line.equalsIgnoreCase("Enum")){
                enums.add(lineList.get(index + 1));
                lastReadClass = lineList.get(index + 1);

                classAttributesDetails.put(lastReadClass, new ArrayList<>());
                classMethodsDetails.put(lastReadClass, new ArrayList<>());

                index++;
                continue;
            }

            if (line.equalsIgnoreCase("Attributes")){
                attributeState = true;
                methodState = false;

                index++;
                continue;
            }
            else if (line.equalsIgnoreCase("Methods")){
                methodState = true;
                attributeState = false;

                index++;
                continue;
            }

            if (attributeState) classAttributesDetails.get(lastReadClass).add(line);
            else if (methodState) classMethodsDetails.get(lastReadClass).add(line);

            index++;
        }

        InterfaceDisplay interfaceDisplay = new InterfaceDisplay();
        interfaceDisplay.display(interfaces, classAttributesDetails, classMethodsDetails);

        ClassDisplay classDisplay = new ClassDisplay();
        classDisplay.display(classes, classAttributesDetails, classMethodsDetails);

        AbstractClassDisplay abstractClassDisplay = new AbstractClassDisplay();
        abstractClassDisplay.display(abstractClasses, classAttributesDetails, classMethodsDetails);

        EnumDisplay enumDisplay = new EnumDisplay();
        enumDisplay.display(enums, classAttributesDetails, classMethodsDetails);
    }

    public void generateClassesToFile(List<String> lineList, String filePath){
        List<String> classes = new ArrayList<>();
        List<String> interfaces = new ArrayList<>();
        List<String> abstractClasses = new ArrayList<>();
        List<String> enums = new ArrayList<>();

        Map<String, List<String>> classAttributesDetails = new HashMap<>();
        Map<String, List<String>> classMethodsDetails = new HashMap<>();

        List<String> warnings = new ArrayList<>();

        boolean attributeState = false;
        boolean methodState = false;
        String lastReadClass = null;

        int index = 0;
        while (index < lineList.size()){
            String line = lineList.get(index);
            line = line.strip();
            line = line.trim().replace(":", "");

            if (line.equalsIgnoreCase("Interface")){
                interfaces.add(lineList.get(index + 1));
                lastReadClass = lineList.get(index + 1);

                classAttributesDetails.put(lastReadClass, new ArrayList<>());
                classMethodsDetails.put(lastReadClass, new ArrayList<>());

                index++;
                continue;
            }

            if (line.equalsIgnoreCase("Class")){
                classes.add(lineList.get(index + 1));
                lastReadClass = lineList.get(index + 1);

                classAttributesDetails.put(lastReadClass, new ArrayList<>());
                classMethodsDetails.put(lastReadClass, new ArrayList<>());

                index++;
                continue;
            }

            if (line.equalsIgnoreCase("Abstract Class")){
                abstractClasses.add(lineList.get(index + 1));
                lastReadClass = lineList.get(index + 1);

                classAttributesDetails.put(lastReadClass, new ArrayList<>());
                classMethodsDetails.put(lastReadClass, new ArrayList<>());

                index++;
                continue;
            }

            if (line.equalsIgnoreCase("Enum")){
                enums.add(lineList.get(index + 1));
                lastReadClass = lineList.get(index + 1);

                classAttributesDetails.put(lastReadClass, new ArrayList<>());
                classMethodsDetails.put(lastReadClass, new ArrayList<>());

                index++;
                continue;
            }

            if (line.equalsIgnoreCase("Attributes")){
                attributeState = true;
                methodState = false;

                index++;
                continue;
            }
            else if (line.equalsIgnoreCase("Methods")){
                methodState = true;
                attributeState = false;

                index++;
                continue;
            }

            if (attributeState) classAttributesDetails.get(lastReadClass).add(line);
            else if (methodState) classMethodsDetails.get(lastReadClass).add(line);

            index++;
        }

        InterfaceDisplay interfaceDisplay = new InterfaceDisplay();
        interfaceDisplay.displayToFile(interfaces, classAttributesDetails, classMethodsDetails, filePath);

        ClassDisplay classDisplay = new ClassDisplay();
        classDisplay.displayToFile(classes, classAttributesDetails, classMethodsDetails, filePath);

        AbstractClassDisplay abstractClassDisplay = new AbstractClassDisplay();
        abstractClassDisplay.displayToFile(abstractClasses, classAttributesDetails, classMethodsDetails, filePath);

        EnumDisplay enumDisplay = new EnumDisplay();
        enumDisplay.displayToFile(enums, classAttributesDetails, classMethodsDetails, filePath);
    }

}
