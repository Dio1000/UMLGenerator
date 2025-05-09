package me.dariansandru.ui;

import me.dariansandru.domain.diagram.ClassDiagram;
import me.dariansandru.domain.factory.DiagramFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ClassDisplay implements Displayable {
    @Override
    public void display(List<String> classes, Map<String, List<String>> classAttributesDetails,
                        Map<String, List<String>> classMethodsDetails) {
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

    @Override
    public void displayToFile(List<String> classes, Map<String, List<String>> classAttributesDetails,
                              Map<String, List<String>> classMethodsDetails, String filePath) throws IOException {
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

            classDiagram.displayToFile(filePath);
        }
    }
}
