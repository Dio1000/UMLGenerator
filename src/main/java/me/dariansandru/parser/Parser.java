package me.dariansandru.parser;

import me.dariansandru.domain.diagram.ClassDiagram;
import me.dariansandru.domain.factory.DiagramFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Parser {

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

    public void generateClasses(List<String> lineList){
        List<String> classes = new ArrayList<>();
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

            if (line.length() >= 5 && Objects.equals(line.substring(0, 5), "Class")){
                classes.add(lineList.get(index + 1));
                lastReadClass = lineList.get(index + 1);

                classAttributesDetails.put(lastReadClass, new ArrayList<>());
                classMethodsDetails.put(lastReadClass, new ArrayList<>());

                index++;
                continue;
            }

            if (line.length() >= 10 && Objects.equals(line.substring(0, 10), "Attributes")){
                attributeState = true;
                methodState = false;

                index++;
                continue;
            }
            else if (line.length() >= 7 && Objects.equals(line.substring(0, 7), "Methods")){
                methodState = true;
                attributeState = false;

                index++;
                continue;
            }

            if (attributeState) classAttributesDetails.get(lastReadClass).add(line);
            else if (methodState) classMethodsDetails.get(lastReadClass).add(line);

            index++;
        }

        displayClasses(classes, classAttributesDetails, classMethodsDetails);
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
