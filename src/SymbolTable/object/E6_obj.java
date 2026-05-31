package SymbolTable.object;

import AST.flask.LiteralType;

import java.util.HashMap;
import java.util.Map;

public class E6_obj {

    // variable name -> type
    private Map<String, LiteralType> variables;

    // builtin function name -> return type
    private Map<String, LiteralType> builtinFunctions;

    public E6_obj() {

        variables = new HashMap<>();

        builtinFunctions = new HashMap<>();

        // ===== Builtin functions =====
        addBuiltinFunction(
                "json.load",
                LiteralType.ARRAY
        );

        addBuiltinFunction(
                "load_products",
                LiteralType.ARRAY
        );
    }

    // ===============================
    // Variables
    // ===============================

    // إضافة متغير جديد
    public void addVariable(
            String name,
            LiteralType type
    ) {

        variables.put(name, type);
    }

    // تحديث نوع متغير
    public void updateVariable(
            String name,
            LiteralType type
    ) {

        variables.put(name, type);
    }

    // جلب نوع متغير
    public LiteralType getType(String name) {

        return variables.get(name);
    }

    // التحقق من وجود متغير
    public boolean contains(String name) {

        return variables.containsKey(name);
    }

    // حذف متغير
    public void removeVariable(String name) {

        variables.remove(name);
    }

    // الحصول على جميع المتغيرات
    public Map<String, LiteralType> getVariables() {

        return variables;
    }

    // ===============================
    // Builtin Functions
    // ===============================

    public void addBuiltinFunction(
            String name,
            LiteralType type
    ) {

        builtinFunctions.put(name, type);
    }

    public LiteralType getBuiltinFunctionType(
            String name
    ) {

        return builtinFunctions.get(name);
    }


}