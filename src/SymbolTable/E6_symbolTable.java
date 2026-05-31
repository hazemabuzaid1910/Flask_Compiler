package SymbolTable;

import AST.flask.LiteralType;
import MainApp.Error_Type;
import MainApp.Main;
import MainApp.Symantic_Error;
import SymbolTable.object.E6_obj;

public class E6_symbolTable extends symbolTable<E6_obj> {

    // ===============================
    // إنشاء Scope جديد
    // ===============================

    public void insert() {

        if (stack != null) {

            stack.push(new E6_obj());
        }
    }

    // ===============================
    // حذف Scope
    // ===============================

    public void remove() {

        if (!stack.isEmpty()) {

            stack.pop();
        }
    }

    // ===============================
    // Builtin Functions
    // ===============================

    public void addBuiltinFunction(
            String name,
            LiteralType type
    ) {

        if (stack.isEmpty()) {
            return;
        }

        stack.peek().addBuiltinFunction(
                name,
                type
        );
    }

    public LiteralType getBuiltinFunctionType(
            String name
    ) {

        for (int i = stack.size() - 1; i >= 0; i--) {

            E6_obj scope = stack.get(i);

            LiteralType type =
                    scope.getBuiltinFunctionType(name);

            if (type != null) {

                return type;
            }
        }

        return null;
    }

    // ===============================
    // Variables
    // ===============================

    // إضافة متغير جديد
    public void addVariable(
            String name,
            LiteralType type
    ) {

        if (stack.isEmpty()) {

            return;
        }

        E6_obj currentScope = stack.peek();

        currentScope.addVariable(name, type);
    }

    // تحديث نوع متغير موجود
    public void updateVariable(
            String name,
            LiteralType type
    ) {

        for (int i = stack.size() - 1; i >= 0; i--) {

            E6_obj scope = stack.get(i);

            if (scope.contains(name)) {

                scope.updateVariable(name, type);

                return;
            }
        }

        // إذا المتغير غير موجود أضفه في الـ scope الحالي
        addVariable(name, type);
    }

    // جلب نوع متغير
    public LiteralType getType(String name) {

        for (int i = stack.size() - 1; i >= 0; i--) {

            E6_obj scope = stack.get(i);

            LiteralType type = scope.getType(name);

            if (type != null) {

                return type;
            }
        }

        return null;
    }

    // ===============================
    // Check Variable Exists
    // ===============================

    public void checkVariableExists(
            String name,
            int line
    ) {

        LiteralType type = getType(name);

        if (type == null) {

            Symantic_Error error = new Symantic_Error();

            error.addError(
                    Error_Type.VAR_NOT_EXIST,
                    "Variable '" + name + "' is not defined",
                    String.valueOf(line)
            );

            Main.errors.add(error);
        }
    }

    // ===============================
    // Type Checking
    // ===============================

    public void checkOperation(
            LiteralType left,
            LiteralType right,
            String op,
            int line
    ) {

        if (left == null || right == null) {

            return;
        }

        switch (op) {

            // ===== PLUS =====
            case "+" -> {

                // number + number
                if (left == LiteralType.NUMBER &&
                        right == LiteralType.NUMBER) {
                    return;
                }

                // string + string
                if (left == LiteralType.STRING &&
                        right == LiteralType.STRING) {
                    return;
                }
            }

            // ===== MINUS =====
            case "-" -> {

                // number - number
                if (left == LiteralType.NUMBER &&
                        right == LiteralType.NUMBER) {
                    return;
                }
            }

            // ===== MULTIPLICATION =====
            case "*" -> {

                // number * number
                if (left == LiteralType.NUMBER &&
                        right == LiteralType.NUMBER) {
                    return;
                }

                // string * number
                if (left == LiteralType.STRING &&
                        right == LiteralType.NUMBER) {
                    return;
                }

                // number * string
                if (left == LiteralType.NUMBER &&
                        right == LiteralType.STRING) {
                    return;
                }
            }

            // ===== DIVISION =====
            case "/" -> {

                // number / number
                if (left == LiteralType.NUMBER &&
                        right == LiteralType.NUMBER) {
                    return;
                }
            }
        }

        // ===== TYPE ERROR =====

        Symantic_Error error = new Symantic_Error();

        error.addError(
                Error_Type.TYPE_ERROR,
                "Unsupported operand types for '" +
                        op +
                        "': '" +
                        left +
                        "' and '" +
                        right + "'",
                String.valueOf(line)
        );

        Main.errors.add(error);
    }
}