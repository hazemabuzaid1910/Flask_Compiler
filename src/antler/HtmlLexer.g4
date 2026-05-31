lexer grammar HtmlLexer;
DOCTYPE : '<!' [dD][oO][cC][tT][yY][p|P][eE] [ \t]+ [hH][tT][mM][lL] '>' ;
// القواعد الأساسية لـ Jinja2

FOR        : 'for';
ENDFOR     : 'endfor';
IF         : 'if';
ENDIF      : 'endif';
IN         : 'in';
LBRACE_PERCENT: '{%';

RBRACE_PERCENT: '%}';
LBRACE_DOUBLE : '{{' ;
RBRACE_DOUBLE : '}}' ;

// رموز HTML الأساسية
OPEN_TAG_SLASH : '</' ;
OPEN_TAG       : '<' ;
CLOSE_TAG      : '>' ;
SLASH_CLOSE    : '/>' ;
EQUALS         : '=' ;
LBRACE : '{' ;
RBRACE : '}' ;
COLON  : ':';
SEMICOLON  : ';';
LBRACE_Q :'"';

// الرموز النصية والخاصة داخل المحتوى
DOT    : '.' ;
DASH   : '-' ;
SLASH      : '/';

// المعرفات (لأسماء التاجات والخصائص والمتغيرات)
IDENTIFIER : [a-zA-Z] [a-zA-Z0-9_]* ;


// النصوص (لقيم الخصائص مثل "box" أو "index.html")
STRING : '"' (~["\\\r\n] | '\\' .)* '"'
       | '\'' (~['\\\r\n] | '\\' .)* '\'' ;
NUMBER : [0-9]+ ('.' [0-9]+)?;
DIMENSION : NUMBER ('px'|'em'|'rem'|'%'|'vh'|'vw');
ANY_SYMBOL : ~[a-zA-Z0-9 \t\r\n<>{}:;.\-/] ;// تجاهل المسافات والأسطر الجديدة في HTML
// في HTML المسافات لا تؤثر على المنطق البرمجي عكس بايثون

WS : [ \t\r\n]+ -> channel(HIDDEN);

// التعليقات في HTML
HTML_COMMENT : '//' -> skip ;
EMOJI
    : [\u2600-\u27BF]
    ;