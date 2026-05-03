parser grammar FlaskParser;

options {
    tokenVocab = FlaskLexer;
}

program
    : (NEWLINE | statement)* EOF
    ;

statement
    : functionDef            # StmtFunction
    | ifStatement            # StmtIf
    | forStatement           # StmtFor
    | withStatement          # StmtWith
    | decoratedFunction      # StmtDecorator
    | importStatement        # StmtImport
    | returnStatement        # StmtReturn
    | assignmentStatement    # StmtAssign
    | expression             # StmtExpression
    ;

block
    : NEWLINE INDENT (statement | NEWLINE)+ DEDENT
    ;

decoratedFunction
    : decorator NEWLINE functionDef
    ;

assignmentStatement
    : primary '=' expression
    ;

importStatement
    : IMPORT importAlias (',' importAlias)*                      # ImportSimple
    | FROM dottedName IMPORT importAlias (',' importAlias)*      # ImportFrom
    ;

importAlias
    : IDENTIFIER (AS IDENTIFIER)?
    ;

dottedName
    : IDENTIFIER (DOT (IDENTIFIER | ROUTE))*
    ;

returnStatement
    : RETURN expression?
    ;

functionDef
    : DEF IDENTIFIER '(' parameterList? ')' ':' block
    ;

parameterList
    : parameterFunction (',' parameterFunction)*
    ;

parameterFunction
    : IDENTIFIER      # ParamIdentifier
    | expression      # ParamExpression
    ;

decorator
    : AT dottedName '(' argumentList? ')'
    ;

ifStatement
    : IF expression ':' block (elseClause)?
    ;

elseClause
    : ELSE ':' block
    ;

forStatement
    : FOR IDENTIFIER IN expression ':' block
    ;

withStatement
    : WITH expression (AS IDENTIFIER)? ':' block
    ;

// ==================== EXPRESSIONS ====================
expression
    : comparison
    | IDENTIFIER
    ;

comparison
    : logicalOr (compOp logicalOr)*
    ;

logicalOr
    : logicalAnd ('or' logicalAnd)*
    ;

logicalAnd
    : additive ('and' additive)*
    ;

additive
    : multiplicative (('+' | '-') multiplicative)*
    ;

multiplicative
    : unary (('*' | '/') unary)*
    ;

unary
    : primary
    ;

compOp
    : EQEQ
    | NEQ
    | LT
    | GT
    | LE
    | GE
    ;

primary
    : atom postfix*
    ;

atom
    : IDENTIFIER              # IdentifierAtom
    | literal                 # LiteralAtom
    | '(' expression ')'      # ParenAtom
    | objectLiteral           # ObjectAtom
    | arrayLiteral            # ArrayAtom
    | listComprehension       # ListComprehensionAtom
    ;

postfix
    : '.' IDENTIFIER          # MemberAccess
    | '[' expression ']'      # IndexAccess
    | '(' argumentList? ')'   # Call
    ;

literal
    : STRING
    | NUMBER
    | NONE
    | TRUE
    | FALSE
    ;

listComprehension
    : '[' expression FOR IDENTIFIER IN expression (IF expression)? ']'
    ;

argument
    : expression                  # ArgExpression
    | IDENTIFIER '=' expression   # ArgAssignment
    ;

argumentList
    : argument (',' argument)*
    ;

arrayLiteral
    : '[' NEWLINE*(expression  ( ',' NEWLINE* expression)*)? NEWLINE* ']'
    ;

objectLiteral
    : '{' NEWLINE? (pair (',' NEWLINE? pair)*)? NEWLINE? '}'
    ;

pair
    : (STRING | IDENTIFIER) ':' expression
    ;