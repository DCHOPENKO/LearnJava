package homeworks.reflection;

import homeworks.reflection.Animals.Dog;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectionTest {

    public static void main(String[] args) {
        Dog dog = new Dog("Rocky", 6);
        try {
            Class dogClass = Class.forName("homeworks.reflection.Animals.Dog");
            printDataAboutClass(dogClass);

            System.out.println("Change public field out of ClassMethods");
            Field fieldName = dogClass.getField("nickName");
            printFieldValue(fieldName, dog);
            fieldName.set(dog, "newName");
            printFieldValue(fieldName, dog);

            System.out.println("Change private field out of ClassMethods");
            Field fieldAge = dogClass.getDeclaredField("age");
            fieldAge.setAccessible(true);
            printFieldValue(fieldAge, dog);
            fieldAge.setInt(dog, -999);
            printFieldValue(fieldAge, dog);

        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException  e) {
            e.printStackTrace();
        }
    }

    private static void printDataAboutClass(Class className) {
        System.out.println("\nShow full class name (with package) --> " + className.getName() +
                "\nShow short class name --> " + className.getSimpleName() +
                "\nShow parent class name --> " + className.getSuperclass().getSimpleName() +
                "\nShow implemented interfaces --> " + getInterfacesToString(className) +
                "\nShow detail info about Fields ---> " + getFieldsDataToString(className) +
                "\nShow detail info about Methods ---> " + getMethodsDataToString(className));
    }

    private static String getInterfacesToString(Class className) {
        Class[] interfaces = className.getInterfaces();
        String result = "";
        for (int i = 0; i < interfaces.length; i++) {
            String interfaceName = interfaces[i].getSimpleName();
            if (i == interfaces.length - 1) {
                result += interfaceName + ".";
                break;
            }
            result += interfaceName + ", ";
        }
        return result;
    }

    private static String getFieldsDataToString(Class className) {
        Field[] fields = className.getDeclaredFields();
        String result = "\n";
        for (int i = 0; i < fields.length; i++) {
            result += "Field № " + (i + 1) + ".  Modificator is - " + Modifier.toString(fields[i].getModifiers()) +
                    ", Type is - " + fields[i].getType().getSimpleName() + ", Name is - " + fields[i].getName() + "\n";
        }
        return result;
    }

    private static String getMethodsDataToString(Class className) {
        Method[] methods = className.getDeclaredMethods();
        String result = "\n";
        for (int i = 0; i < methods.length; i++) {
            result += "Method № " + (i + 1) + ".  Modificator is - " + Modifier.toString(methods[i].getModifiers()) +
                    ", Type is - " + methods[i].getReturnType().getSimpleName() + ", Name is - " +
                    methods[i].getName() + ", Method Parameters: " + getParametersForMethodToString(methods[i]);
        }
        return result;
    }

    private static String getParametersForMethodToString(Method method) {
        String result = "\n";
        Parameter[] parameters = method.getParameters();
        if (parameters.length == 0) {
            result += "    Method without parameters \n";
            return result;
        }
        for (int i = 0; i < parameters.length; i++) {
            result += "    Parameter № " + (i + 1) + ", Type is - " + parameters[i].getType().getSimpleName() + ". \n";
        }
        return result;
    }

    private static void printFieldValue(Field fieldName, Object objectName) {
        try {
            System.out.println(fieldName.get(objectName));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}



