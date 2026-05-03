parser grammar HtmlParser;

options {
    tokenVocab = HtmlLexer;
}

htmlNode
    : DOCTYPE?
     htmlContent*
      EOF
    ;
htmlElement:htmlTag
           ;
htmlTag : htmlPairTag      #HtmlPairTagExp
        | htmlSingleTag    #HtmlSingleTagExp
        ;

htmlPairTag: '<'tagName  htmlAttribute*'>' htmlContent* '</'tagName'>' ;
htmlSingleTag:
             '<' tagName  htmlAttribute* '/>'   # HtmlSingleTagSelfClosing
             ;

tagName:IDENTIFIER
       ;
htmlAttribute: attributeKey '=' attributeValue;

attributeKey:IDENTIFIER;
attributeValue:STRING | IDENTIFIER | NUMBER;

htmlContent : htmlElement        #ElementHtml
            | jinjaStatement     #StatementJinja
            | jinjaExpression    #ExpressionJinja
            | cssClass+          #CssClassExpression
            | text               #TextExpression
            | IDENTIFIER         #IdentifierExpression


            ;

dottedName
    : IDENTIFIER (DOT (IDENTIFIER ))*
    ;
cssClass : (DOT? IDENTIFIER) LBRACE (cssDeclaration)* RBRACE ;
cssDeclaration : cssKey COLON cssValue+ SEMICOLON ;

cssKey : IDENTIFIER (DASH IDENTIFIER)* ;
cssValue : DIMENSION|IDENTIFIER | NUMBER | STRING | ANY_SYMBOL | DOT | DASH | SLASH ;
jinjaStatement : forBlock   #ForStatement
               | ifBlock    #IfStatement

               ;
jinjaExpression
    : LBRACE_DOUBLE dottedName RBRACE_DOUBLE
    ;
forBlock
    : LBRACE_PERCENT FOR IDENTIFIER IN IDENTIFIER RBRACE_PERCENT
      htmlContent*
      LBRACE_PERCENT ENDFOR RBRACE_PERCENT
    ;


ifBlock
    : LBRACE_PERCENT IF IDENTIFIER RBRACE_PERCENT
      htmlContent*
      LBRACE_PERCENT ENDIF RBRACE_PERCENT
    ;
        text : (IDENTIFIER | NUMBER | ANY_SYMBOL | DOT | DASH | COLON | SEMICOLON | SLASH | EQUALS)+ ;
