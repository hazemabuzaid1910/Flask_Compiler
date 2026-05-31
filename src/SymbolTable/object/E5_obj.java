package SymbolTable.object;

import java.util.*;

public class E5_obj {

    private Map<String, Set<String>> templateRequiredVariables;
    private Map<String, Set<String>> templatePassedVariables;

    public E5_obj() {

        templateRequiredVariables = new HashMap<>();
        templatePassedVariables = new HashMap<>();
    }

    public void addRequiredVariable(String template, String variable) {

        templateRequiredVariables
                .computeIfAbsent(template, k -> new HashSet<>())
                .add(variable);
    }

    public void addPassedVariable(String template, String variable) {

        templatePassedVariables
                .computeIfAbsent(template, k -> new HashSet<>())
                .add(variable);
    }

    public Map<String, Set<String>> getTemplateRequiredVariables() {
        return templateRequiredVariables;
    }

    public Map<String, Set<String>> getTemplatePassedVariables() {
        return templatePassedVariables;
    }
}