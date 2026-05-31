package SymbolTable;

import MainApp.Error_Type;
import MainApp.Main;
import MainApp.Symantic_Error;
import SymbolTable.object.E5_obj;

import java.util.Set;

public class E5_symbolTable extends symbolTable<E5_obj> {

    public void insert() {
        if (stack != null) {
            E5_obj newscope = new E5_obj();
            stack.push(newscope);
        }
    }

    // HTML/Jinja
    public void addRequired(String template, String variable) {

        if (!stack.isEmpty()) {
            stack.peek().addRequiredVariable(template, variable);
        }
    }

    // Flask render_template
    public void addPassed(String template, String variable) {

        if (!stack.isEmpty()) {
            stack.peek().addPassedVariable(template, variable);
        }
    }

    public void check_E5() {

        if (stack.isEmpty()) return;

        E5_obj data = stack.peek();

        data.getTemplateRequiredVariables().forEach((template, requiredVars) -> {

            Set<String> passedVars =
                    data.getTemplatePassedVariables().get(template);

            for (String var : requiredVars) {

                if (passedVars == null || !passedVars.contains(var)) {

                    Symantic_Error error = new Symantic_Error();
                    error.addError(
                            Error_Type.MISSING_FLASK_VARIABLE,
                            "The variable " + var + " is  Missing Flask Variable",
                            String.valueOf(template)
                    );

                    Main.errors.add(error);
                }
            }
        });
    }
}