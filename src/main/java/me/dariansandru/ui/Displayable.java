package me.dariansandru.ui;

import me.dariansandru.io.InputDevice;
import me.dariansandru.io.OutputDevice;

import java.util.List;
import java.util.Map;

public interface Displayable {
    public void display(List<String> classes, Map<String, List<String>> classAttributesDetails,
                        Map<String, List<String>> classMethodsDetails);

    public void displayToFile(List<String> classes, Map<String, List<String>> classAttributesDetails,
                              Map<String, List<String>> classMethodsDetails, String filePath);
}
