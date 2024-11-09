package me.dariansandru.util;

public class Utils {

    public static final int offset = 5;

    public static void displayBorder(int length){
        System.out.print("+");
        for (int i = 1 ; i < length + 2 * offset - 1; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    public static void displayClassName(String className, int maxLength){
        int charCount = 1;

        System.out.print("|");
        for (int i = 1 ; i < offset + (maxLength - className.length()) / 2 ; i++){
            System.out.print(" ");
            charCount++;
        }
        System.out.print(className);
        charCount += className.length();

        while(charCount < maxLength + 2 * offset - 1){
            System.out.print(" ");
            charCount++;
        }
        System.out.println("|");
    }

    public static void displayInterfaceName(String interfaceName, int maxLength){
        int charCount = 1;

        System.out.print("|");
        for (int i = 1 ; i < offset + (maxLength - interfaceName.length()) / 2 ; i++){
            System.out.print(" ");
            charCount++;
        }
        System.out.print(interfaceName);
        charCount += interfaceName.length();

        while(charCount < maxLength + 2 * offset - 1){
            System.out.print(" ");
            charCount++;
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
