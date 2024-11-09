package me.dariansandru.domain.factory;

import me.dariansandru.domain.diagram.ClassDiagram;
import me.dariansandru.domain.diagram.Diagram;
import me.dariansandru.domain.diagram.InterfaceDiagram;

public class DiagramFactory implements Factory<Diagram>{
    public DiagramFactory(){

    }

    @Override
    public Diagram getObject(String object) {
        if (object.equals("class")) {
            return new ClassDiagram();
        }
        else if (object.equals("interface")){
            return new InterfaceDiagram();
        }
        else {
            throw new IllegalArgumentException("Class " + object + " does not exist!");
        }
    }
}
