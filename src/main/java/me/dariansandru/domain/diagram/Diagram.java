package me.dariansandru.domain.diagram;

import java.io.IOException;

public interface Diagram {

    public String getClassName();
    public void setClassName(String className);

    public int getAttributeNumber();
    public int getMethodNumber();

    public void addAttribute(String attribute, int modifier);
    public void addMethod(String method, String returnType, int modifier);

    public void display();
    public void displayToFile(String filePath) throws IOException;
}
