package SymbolTable;

import MainApp.Error_Type;
import MainApp.Main;
import MainApp.Symantic_Error;
import SymbolTable.object.E2_obj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E3_symbolTable extends symbolTable<E2_obj>{

    public void insert() {
        if (stack != null) {
            E2_obj newscope = new E2_obj();
            stack.add(newscope);
        } else {
            System.out.println("Stack not allocated yet!");
        }
    }


    private Map<String, Set<String>> objectProperties = new HashMap<>();

    private Map<String, String> objectReferences = new HashMap<>();

    private Map<String, String> objectTypes = new HashMap<>();

    public void addProperty(String objectName, String propertyName) {
        objectProperties.computeIfAbsent(objectName, k -> new HashSet<>()).add(propertyName);
    }


    public void addObjectReference(String fromObject, String toObject) {
        objectReferences.put(fromObject, toObject);
    }


    public void setObjectType(String objectName, String type) {
        objectTypes.put(objectName, type);
    }

    public boolean hasProperty(String objectName, String propertyName) {
        if (objectProperties.containsKey(objectName) &&
                objectProperties.get(objectName).contains(propertyName)) {
            return true;
        }

        if (objectReferences.containsKey(objectName)) {
            String referencedObject = objectReferences.get(objectName);
            return hasProperty(referencedObject, propertyName);
        }

        if (isArrayObject(objectName) && isNumericProperty(propertyName)) {
            return true;
        }

        return false;
    }


    private boolean isArrayObject(String objectName) {
        String type = objectTypes.get(objectName);
        return "array".equals(type);
    }

    private boolean isNumericProperty(String propertyName) {
        if (propertyName == null) return false;
        try {
            Integer.parseInt(propertyName);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public void check_E3(String objectName, String propertyName, int lineNumber) {
        if (objectName == null || propertyName == null) {
            return;
        }

        if (isNumericProperty(propertyName)) {
            if (isArrayObject(objectName) || hasArrayType(objectName)) {
                return;
            }
        }

        if (!hasProperty(objectName, propertyName)) {
            Symantic_Error error = new Symantic_Error();
            error.addError(Error_Type.UNDECLARED_PROPERTY,
                    "The Property '" + propertyName + "' is Undeclared on object '" + objectName + "'",
                    String.valueOf(lineNumber));
            Main.errors.add(error);
        }
    }

    private boolean hasArrayType(String objectName) {
        if ("array".equals(objectTypes.get(objectName))) {
            return true;
        }
        if (objectReferences.containsKey(objectName)) {
            return hasArrayType(objectReferences.get(objectName));
        }
        return false;
    }

    public void copyProperties(String fromObject, String toObject) {
        Set<String> props = objectProperties.get(fromObject);
        if (props != null && !props.isEmpty()) {
            for (String prop : props) {
                addProperty(toObject, prop);
            }
        }

        String ref = objectReferences.get(fromObject);
        if (ref != null) {
            addObjectReference(toObject, ref);
            Set<String> refProps = objectProperties.get(ref);
            if (refProps != null && !refProps.isEmpty()) {
                for (String prop : refProps) {
                    addProperty(toObject, prop);
                }
            }
        }

        if (isArrayObject(fromObject)) {
            setObjectType(toObject, "array");
        }
    }

    public Set<String> getObjectProperties(String objectName) {
        return objectProperties.get(objectName);
    }

}