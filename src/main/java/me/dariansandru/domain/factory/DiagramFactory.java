package me.dariansandru.domain.factory;

import me.dariansandru.domain.diagram.*;

public class DiagramFactory implements Factory<Diagram>{
    public DiagramFactory(){

    }

    @Override
    public Diagram getObject(String object) {
        return switch (object) {
            case "class" -> new ClassDiagram();
            case "interface" -> new InterfaceDiagram();
            case "abstract" -> new AbstractClassDiagram();
            case "enum" -> new EnumDiagram();
            default -> throw new IllegalArgumentException("Class " + object + " does not exist!");
        };
    }
}
