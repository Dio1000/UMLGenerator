package me.dariansandru.ui;

import me.dariansandru.domain.diagram.AbstractClassDiagram;
import me.dariansandru.domain.diagram.ClassDiagram;
import me.dariansandru.domain.factory.DiagramFactory;

import java.util.List;
import java.util.Map;

public class AbstractClassDisplay implements Displayable {
    @Override
    public void display(List<String> abstractClasses, Map<String, List<String>> classAttributesDetails, Map<String, List<String>> classMethodsDetails) {
        DiagramFactory diagramFactory = new DiagramFactory();

        for (String cls : abstractClasses){
            List<String> attributes = classAttributesDetails.get(cls);
            List<String> methods = classMethodsDetails.get(cls);

            AbstractClassDiagram abstractClassDiagram = (AbstractClassDiagram) diagramFactory.getObject("abstract");
            abstractClassDiagram.setClassName(cls);

            for (String attribute : attributes){
                if (attribute.split(",").length != 3) continue;

                String name = attribute.split(",")[0].strip();
                String type = attribute.split(",")[1].strip();
                int modifier = (attribute.split(",")[2].strip().equals("1")) ? 1 : 0;

                abstractClassDiagram.addTypedAttribute(name, type, modifier);
            }

            for (String method : methods){
                if (method.split(",").length != 3) continue;

                String name = method.split(",")[0].strip();
                String type = method.split(",")[1].strip();
                int modifier = (method.split(",")[2].strip().equals("1")) ? 1 : 0;

                abstractClassDiagram.addMethod(name, type, modifier);
            }

            abstractClassDiagram.display();
            System.out.println();
        }
    }
}
