package me.dariansandru.domain.diagram;

import me.dariansandru.io.OutputDevice;
import me.dariansandru.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterfaceDiagram implements Diagram{

    private String className;
    private int attributeNumber;
    private int methodNumber;

    private final List<String> attributes;
    private final Map<String, Integer> attributeModifierMap;
    private final Map<String, String> attributeTypeMap;

    private final List<String> methods;
    private final Map<String, Integer> methodModifierMap;
    private final Map<String, String> methodReturnTypeMap;

    private int longestName;

    public InterfaceDiagram(){
        this.className = "Interface";
        this.attributeNumber = 0;
        this.methodNumber = 0;
        this.longestName = className.length();

        attributes = new ArrayList<>();
        methods = new ArrayList<>();

        attributeModifierMap = new HashMap<>();
        attributeTypeMap = new HashMap<>();

        methodModifierMap = new HashMap<>();
        methodReturnTypeMap = new HashMap<>();
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;

        if (className.length() > longestName) longestName = className.length();
    }

    @Override
    public int getAttributeNumber() {
        return attributeNumber;
    }

    @Override
    public int getMethodNumber() {
        return methodNumber;
    }

    @Override
    public void addAttribute(String attribute, int modifier) {
        this.attributeNumber++;
        this.attributeModifierMap.put(attribute, modifier);
        this.attributeTypeMap.put(attribute, "");
        this.attributes.add(attribute);

        if (attribute.length() > longestName) longestName = attribute.length();
    }

    public void addTypedAttribute(String attribute, String type, int modifier){
        this.attributeNumber++;
        this.attributeModifierMap.put(attribute, modifier);
        this.attributeTypeMap.put(attribute, type);
        this.attributes.add(attribute);

        int currentLength = (attribute + ": " + attributeTypeMap.get(attribute)).length();
        if (currentLength > longestName) longestName = currentLength;
    }

    @Override
    public void addMethod(String method, String returnType, int modifier) {
        this.methodNumber++;
        this.methodModifierMap.put(method, modifier);
        this.methodReturnTypeMap.put(method, returnType);
        this.methods.add(method);

        int currentLength = (method + "(): " + methodReturnTypeMap.get(method)).length();
        if (currentLength > longestName) longestName = currentLength;
    }

    @Override
    public void display(){
        // Displays interface name with borders
        Utils.displayBorder(longestName);
        Utils.displayInterfaceName(className, longestName);
        Utils.displayBorder(longestName);

        // Displays attributes with borders
        for (String attribute : attributes){
            Utils.displayAttributeName(attribute + ": " + attributeTypeMap.get(attribute), attributeModifierMap.get(attribute), longestName);
        }
        Utils.displayBorder(longestName);

        // Displays methods with borders
        for (String method : methods){
            Utils.displayMethodName(method + "(): " + methodReturnTypeMap.get(method), methodModifierMap.get(method), longestName);
        }
        Utils.displayBorder(longestName);

        Utils.displayInterfaceName("<Interface>", longestName);
        Utils.displayBorder(longestName);
    }

    @Override
    public void displayToFile(String filePath) throws IOException {
        OutputDevice outputDevice = new OutputDevice();
        StringBuilder classDiagram = new StringBuilder();

        // Builds class name with borders
        classDiagram.append(Utils.getBorder(longestName)).append("\n").
                append(Utils.getClassName(className, longestName)).append("\n").
                append(Utils.getBorder(longestName)).append("\n");

        // Builds attributes with borders
        for (String attribute : attributes){
            classDiagram.append(Utils.getAttributeName(attribute + ": " + attributeTypeMap.get(attribute), attributeModifierMap.get(attribute), longestName)).append("\n");
        }
        classDiagram.append(Utils.getBorder(longestName)).append("\n");

        // Builds methods with borders
        for (String method : methods){
            classDiagram.append(Utils.getMethodName(method + ": " + methodReturnTypeMap.get(method), methodModifierMap.get(method), longestName)).append("\n");
        }
        classDiagram.append(Utils.getBorder(longestName)).append("\n");

        classDiagram.append(Utils.getClassName("<Interface>", longestName)).append("\n");
        classDiagram.append(Utils.getBorder(longestName)).append("\n");
        outputDevice.appendToFile(Utils.getLinesFromString(classDiagram.toString()), filePath);
    }
}
