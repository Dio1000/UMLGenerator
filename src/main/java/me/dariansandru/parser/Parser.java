package me.dariansandru.parser;

import me.dariansandru.domain.diagram.ClassDiagram;
import me.dariansandru.domain.diagram.InterfaceDiagram;
import me.dariansandru.domain.factory.DiagramFactory;
import me.dariansandru.io.InputDevice;
import me.dariansandru.io.OutputDevice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Parser {

    InputDevice inputDevice = new InputDevice();
    OutputDevice outputDevice = new OutputDevice();

    public void generateClasses(List<String> lineList){
        List<String> classes = new ArrayList<>();
        List<String> interfaces = new ArrayList<>();

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

        displayInterfaces(interfaces, classAttributesDetails, classMethodsDetails);
        displayClasses(classes, classAttributesDetails, classMethodsDetails);
    }

    public void displayInterfaces(List<String> interfaces, Map<String, List<String>> classAttributesDetails,
                               Map<String, List<String>> classMethodsDetails){
        DiagramFactory diagramFactory = new DiagramFactory();

        for (String inf : interfaces){
            List<String> attributes = classAttributesDetails.get(inf);
            List<String> methods = classMethodsDetails.get(inf);

            InterfaceDiagram interfaceDiagram = (InterfaceDiagram) diagramFactory.getObject("interface");
            interfaceDiagram.setClassName(inf);

            for (String attribute : attributes){
                if (attribute.split(",").length != 3) continue;

                String name = attribute.split(",")[0].strip();
                String type = attribute.split(",")[1].strip();
                int modifier = (attribute.split(",")[2].strip().equals("1")) ? 1 : 0;

                interfaceDiagram.addTypedAttribute(name, type, modifier);
            }

            for (String method : methods){
                if (method.split(",").length != 3) continue;

                String name = method.split(",")[0].strip();
                String type = method.split(",")[1].strip();
                int modifier = (method.split(",")[2].strip().equals("1")) ? 1 : 0;

                interfaceDiagram.addMethod(name, type, modifier);
            }

            interfaceDiagram.display();
            System.out.println();
        }
    }

    public void displayClasses(List<String> classes, Map<String, List<String>> classAttributesDetails,
                               Map<String, List<String>> classMethodsDetails){
        DiagramFactory diagramFactory = new DiagramFactory();

        for (String cls : classes){
            List<String> attributes = classAttributesDetails.get(cls);
            List<String> methods = classMethodsDetails.get(cls);

            ClassDiagram classDiagram = (ClassDiagram) diagramFactory.getObject("class");
            classDiagram.setClassName(cls);

            for (String attribute : attributes){
                if (attribute.split(",").length != 3) continue;

                String name = attribute.split(",")[0].strip();
                String type = attribute.split(",")[1].strip();
                int modifier = (attribute.split(",")[2].strip().equals("1")) ? 1 : 0;

                classDiagram.addTypedAttribute(name, type, modifier);
            }

            for (String method : methods){
                if (method.split(",").length != 3) continue;

                String name = method.split(",")[0].strip();
                String type = method.split(",")[1].strip();
                int modifier = (method.split(",")[2].strip().equals("1")) ? 1 : 0;

                classDiagram.addMethod(name, type, modifier);
            }

            classDiagram.display();
            System.out.println();
        }
    }

}
