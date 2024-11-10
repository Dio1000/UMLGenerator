package me.dariansandru.ui;

import me.dariansandru.domain.diagram.ClassDiagram;
import me.dariansandru.domain.diagram.EnumDiagram;
import me.dariansandru.domain.factory.DiagramFactory;

import java.util.List;
import java.util.Map;

public class EnumDisplay implements Displayable{
    @Override
    public void display(List<String> enums, Map<String, List<String>> classAttributesDetails, Map<String, List<String>> classMethodsDetails) {
        DiagramFactory diagramFactory = new DiagramFactory();

        for (String en : enums){
            List<String> attributes = classAttributesDetails.get(en);
            List<String> methods = classMethodsDetails.get(en);

            EnumDiagram enumDiagram = (EnumDiagram) diagramFactory.getObject("enum");
            enumDiagram.setClassName(en);

            for (String attribute : attributes){
                if (attribute.split(",").length != 3) continue;

                String name = attribute.split(",")[0].strip();
                String type = attribute.split(",")[1].strip();
                int modifier = (attribute.split(",")[2].strip().equals("1")) ? 1 : 0;

                enumDiagram.addTypedAttribute(name, type, modifier);
            }

            for (String method : methods){
                if (method.split(",").length != 3) continue;

                String name = method.split(",")[0].strip();
                String type = method.split(",")[1].strip();
                int modifier = (method.split(",")[2].strip().equals("1")) ? 1 : 0;

                enumDiagram.addMethod(name, type, modifier);
            }

            enumDiagram.display();
            System.out.println();
        }
    }

}
