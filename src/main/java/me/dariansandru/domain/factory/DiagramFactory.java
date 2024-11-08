package me.dariansandru.domain.factory;

import me.dariansandru.domain.diagram.ClassDiagram;
import me.dariansandru.domain.diagram.Diagram;

public class DiagramFactory implements Factory<Diagram>{
    public DiagramFactory(){

    }

    @Override
    public Diagram getObject(String object) {
        if (object.equals("class")) {
            return new ClassDiagram();
        }
        else {
            throw new IllegalArgumentException("Class " + object + " does not exist!");
        }
    }
}
