lexer grammar FlaskLexer;

tokens { INDENT, DEDENT }
@header{import java.util.*;}
@lexer::members {

    private Stack<Integer> indents = new Stack<>() {{ push(0); }};
    private Queue<Token> queue = new LinkedList<>();

    // يمنع احتساب indentation داخل الأقواس
    private int opened = 0;

    // (اختياري) debug
    private boolean debug = false;

    @Override
    public Token nextToken() {

        // إذا في tokens مولّدة مسبقاً (INDENT / DEDENT / NEWLINE)
        if (!queue.isEmpty())
            return queue.poll();

        Token t = super.nextToken();
if (t.getType() == EOF) {
        // طالما أن الستاك فيه مستويات إزاحة أكثر من المستوى الابتدائي (0)
        while (indents.size() > 1) {
            indents.pop();
            queue.add(createToken(DEDENT, "")); // أضف DEDENT لكل مستوى
        }
        queue.add(t); // أضف الـ EOF في النهاية
        return queue.poll();
    }
        // تتبع الأقواس حتى لا نحسب indent داخلها
        if (t.getType() == LPAREN || t.getType() == LBRACK || t.getType() == LBRACE)
            opened++;

        if (t.getType() == RPAREN || t.getType() == RBRACK || t.getType() == RBRACE)
            opened--;

      if (t.getType() == NEWLINE) {

          queue.add(t);

          int spaces = 0;
          int i = 1;
          int la = _input.LA(i);

          // ⬅️ قراءة المسافات الحقيقية بعد السطر
          while (la == ' ' || la == '\t') {
              spaces += (la == '\t') ? 4 : 1;
              i++;
              la = _input.LA(i);
          }

          int current = indents.peek();

          if (debug) {
              System.out.println("SPACES = " + spaces + " CURRENT = " + current);
          }

          if (opened == 0) {

              if (spaces > current) {
                  indents.push(spaces);

                  //System.out.println(">>> INDENT = " + spaces);

                  queue.add(createToken(INDENT, String.valueOf(spaces))); // 👈 مهم
              }

              else if (spaces < current) {
                  while (indents.size() > 1 && indents.peek() > spaces) {
                      indents.pop();

                      //System.out.println(">>> DEDENT = " + spaces);

                      queue.add(createToken(DEDENT, String.valueOf(spaces))); // 👈 مهم
                  }
              }
          }

          return queue.poll();
      }
        return t;
    }

    // إنشاء token يدوي (INDENT / DEDENT)
    private Token createToken(int type, String text) {
        CommonToken token = new CommonToken(_tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, -1, -1);
        token.setText(text);
        return token;
    }
}
NEWLINE
    : ('\r'? '\n')+
    ;

// في قسم القواعد
fragment SPACE : ' ' | '\t' | '\u00A0';
WS : SPACE+ ->skip;
COMMENT : '#' ~[\r\n]* -> skip ;

// الكلمات المحجوزة
DEF     : 'def';
IF      : 'if';
ELIF    : 'elif';
ELSE    : 'else';
RETURN  : 'return';
FOR     : 'for';
IN      : 'in';
FROM    : 'from';
IMPORT  : 'import';
NONE    : 'None';
TRUE    : 'True';
FALSE   : 'False';
WITH    : 'with';
AS      : 'as';
AND     : 'and';
OR      : 'or';
NOT     : 'not';
ROUTE   : 'route';

// الرموز
EQEQ    : '==';
NEQ     : '!=';
LE      : '<=';
GE      : '>=';
LT      : '<';
GT      : '>';
PLUS    : '+';
MINUS   : '-';
MUL     : '*';
DIV     : '/';
MOD     : '%';
ASSIGN  : '=';
AT      : '@';
DOT     : '.';
LPAREN  : '(';
RPAREN  : ')';
LBRACK  : '[';
RBRACK  : ']';
LBRACE  : '{';
RBRACE  : '}';
COMMA   : ',';
COLON   : ':';
SEMICOLON : ';';

IDENTIFIER : [_a-zA-Z][_a-zA-Z0-9]* ;

STRING : '"' (~["\\\r\n] | '\\' .)* '"'
       | '\'' (~['\\\r\n] | '\\' .)* '\''
       ;

NUMBER : [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)? ;