package me.dariansandru.domain.diagram;

public interface Diagram {

    public String getClassName();
    public void setClassName(String className);

    public int getAttributeNumber();
    public int getMethodNumber();

    public void addAttribute(String attribute, int modifier);
    public void addMethod(String method, String returnType, int modifier);

    public void display();
}
