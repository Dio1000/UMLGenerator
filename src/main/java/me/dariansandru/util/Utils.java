package me.dariansandru.util;

public class Utils {

    public static final int offset = 10;

    public static void displayBorder(int length){
        System.out.print("|");
        for (int i = 1 ; i < length + 2 * offset - 1; i++){
            System.out.print("-");
        }
        System.out.println("|");
    }

    public static void displayClassName(String className, int maxLength){
        System.out.print("|");
        for (int i = 1 ; i < offset + (maxLength - className.length()) / 2 ; i++){
            System.out.print(" ");
        }
        System.out.print(className);

        for (int i = 1 ; i < offset + (maxLength - className.length()) / 2 ; i++){
            System.out.print(" ");
        }
        System.out.println("|");
    }

    public static void displayAttributeName(String attributeName, int modifier, int maxLength){
        System.out.print("|");

        if (modifier == 1) System.out.print(" +" + attributeName);
        else if (modifier == 0) System.out.print(" -" + attributeName);

        for (int i = 2 ; i < 2 * offset + (maxLength - attributeName.length()) - 2 ; i++){
            System.out.print(" ");
        }
        System.out.println("|");
    }

    public static void displayMethodName(String methodName, int modifier, int maxLength){
        System.out.print("|");

        if (modifier == 1) System.out.print(" +" + methodName);
        else if (modifier == 0) System.out.print(" -" + methodName);

        for (int i = 2 ; i < 2 * offset + (maxLength - methodName.length()) - 2 ; i++){
            System.out.print(" ");
        }
        System.out.println("|");
    }
}
