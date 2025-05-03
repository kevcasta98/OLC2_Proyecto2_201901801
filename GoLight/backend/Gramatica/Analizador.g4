grammar Analizador;

options {
	caseInsensitive = false;
}

NEWLINE: [ \r\n\t]+ -> channel(HIDDEN);
COMENTARIO_LINEA: '//' ~[\r\n]* -> channel(HIDDEN);
COMENTARIO_MULTILINEA: '/*' .*? '*/' -> channel(HIDDEN);

program: dcl*;

dcl:
	'fmt.Println(' expr (',' expr)* ')' ';'?	# PrintStmt
	| 'if'  expr  block ('else' (dcl|block) )?	    # IfStmt
	| 'for' '('? expr ')'? block				# WhileStmt
	| 'for' '('? forID expr ';' expr ')' block	# ForStmt
	//| 'for' '(' forID expr ';' expr ')' stmt	  # ForStmt
	| 'switch' expr '{' caseList '}'	    # SwitchStmt
	| 'func' ID '(' parametros? ')' tipo? block	# FuncDeclStmt
	| 'return' expr ';'?						# ReturnStmt
	| varCall ';'?								# FuncCallStmt
	| varAsign									# AsignStmt
	| varDcl									# VarDeclStmt	
	| '{' dcl* '}'								# BlockStmt
	| expr ';'?							# ExprStmt					
;

forID: varDcl | expr ';';
caseList: caseStmt+;  
caseStmt: 'case' expr ':' dcl*  // Cada case puede tener varias sentencias
    | 'default' ':' dcl*        // Default solo puede tener una sentencia
;

block: '{' dcl* '}';

varDcl: 'var' ID tipo (IGUAL expr)? ';'? | ID ':=' expr ';'?;

varAsign: ID '=' expr ';'?;

varCall: ID '(' args? ')';

parametros: param (',' param)*;
param: ID tipo;

args: expr (',' expr)*;

expr:
	'!' expr						# Not
	| '-' expr									# Negate
	| ID op = ('++' | '--')						# IncrementoDecremento
	| expr op = ('*' | '/' | '%') expr			# MulDivMod
	| expr op = ('+' | '-') expr				# AddSub
	| expr op = ('<' | '<=' | '>' | '>=') expr	# Relational
	| expr op = ('==' | '!=') expr				# IgualDesigual
	| ID op = ('+=' | '-=') expr				# AsigAddSub
	| expr op = '&&' expr						# And
	| expr op = '||' expr						# Or

	| INT							# ExpInteger
	| DECIMAL						# ExpDouble
	| CADENA						# ExpString
	| BOOLEANO						# ExpBoolean
	| CARACTER						# ExpChar
	| ID							# Identifier
	| varCall						# FuncCallExpr
	| '(' expr ')'					# Parens
	| '[' expr ']'					# Corchetes;

tipo: 'int' | 'float64' | 'string' | 'bool' | 'rune' | 'void';
INT: [0-9]+;
DECIMAL: [0-9]+ '.' [0-9]+;
BOOLEANO: 'true' | 'false';
CARACTER: '\'' ~["'\r\n] '\'';
CADENA: ('"' | '\'') (~["\r\n] | '""')* ('"' | '\'');
ID: [a-zA-Z]+ ('_')? ([0-9]+)?;
MODULO: '%';

IGUAL: '=';
DOSPUNTOS_IGUAL: ':=';
PARENTESIS_ABRE: '(';
PARENTESIS_CIERRA: ')';

/*
 program: dcl*;
 
 dcl: varDcl | funciones | classDcl | stmt;
 
 varDcl: 'var' ID tipo (IGUAL expr)? ';'? | ID ':=' (('[' ']')+ tipo)? expr ';'?; // ID := [] tipo
 {}; var ID tipo = [] classDcl: 'class' ID '{' classbody* '}';
 
 classbody: varDcl | funciones;
 
 funciones: 'func' ID '(' params? ')' tipo? '{' dcl* '}';
 
 params: ID tipo (',' ID tipo)*;
 
 stmt: expr ';'? # ExprStmt | 'fmt.Println(' expr (',' expr)* ')' ';'? # PrintStmt | '{' dcl* '}' #
 BlockStmt | 'if' expr stmt ('else' stmt)? # IfStmt | 'switch' expr '{' caseList '}' # SwitchStmt |
 'for' '('? forID expr ';' expr ')'? stmt # ForStmt | 'for' expr stmt # ForStmt2 | 'break' ';'? #
 Break | 'continue' ';'? # Continue | 'return' expr? ';'? # Return;
 
 forID: varDcl | expr ';';
 
 caseList: caseStmt+; caseStmt: 'case' expr ':' stmt* // Cada case puede tener varias sentencias |
 'default' ':' stmt* ; // Default solo puede tener una sentencia
 
 tipo: 'int' | 'float64' | 'string' | 'bool' | 'rune';
 
 expr: '(' expr ')' # Parens | '[' expr ']' # Corchetes | '!' expr # NegacionUnariaBooleano | '-'
 expr # NegacionUnariaNumerica //| expr '[' expr ']' '=' expr ';'? # AsignacionSlice | expr call+ #
 Callee | expr op = ('*' | '/' | '%') expr # MulDivMod | ID op = ('++' | '--') #
 IncrementoDecremento | expr op = ('+' | '-') expr # AddSub | expr op = ('<' | '<=' | '>' | '>=')
 expr # Relational | expr op = ('==' | '!=') expr # IgualDesigual | expr op = '&&' expr # And | expr
 op = '||' expr # Or | ID op = ('+=' | '-=') expr # AsigAddSub | 'var' ID tipo (IGUAL expr)? ';'? #
 VarDcl1 | ID DOSPUNTOS_IGUAL expr ';'? # Asignacion
 
 | expr '=' expr ';'? # Reasignacion | 'fmt.Println(' expr (',' expr)* ')' ';'? # PrintStmt1 | '{'
 args? '}' # slice | BOOLEANO # BooleanExpresion | INT # Number | 'new' ID '(' args? ')' # New |
 CADENA # CadenaExpresion | ID # Identifier | CARACTER # CaracterExpresion | DECIMAL #
 DecimalExpresion;
 
 call: '(' args? ')' # FuncCall | '[' expr ']' # AccesoSlice | '.' ID # Get;
 
 args: expr (',' expr)*;
 */