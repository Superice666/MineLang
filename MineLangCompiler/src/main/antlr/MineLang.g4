grammar MineLang;

program: expr*
  EOF
  ;

callArgs: LB expr? (COMMA expr)* COMMA? RB;

expr: SEMICOLON #split
    |(INT | DEC | STRING | BOOL | NONE | NAN | UNDEFINED) #literalExpr
    | ID #varUseExpr
    | expr DOT ID #getExpr
    | expr callArgs #funcCallExpr
    | FUNC ID LB (ID COMMA)* ID? RB expr #funcDefineExpr
    | NOT expr #notExpr
    | expr (MULTIPLY | DIVIDE | REMAIN) expr #multiplyDivideRemainExpr
    | expr (PLUS | MINUS) expr #plusMinusExpr
    | (PLUS | MINUS) expr #positiveNegativeExpr
    | expr (EQ | NEQ) expr #isEqExpr
    | expr (GTR | GTREQ | LWR | LWREQ) expr #compareExpr
    | expr ((AND AND) | (OR OR)) expr #logicExpr
    | ID SET expr #varSetExpr
    | BREAK expr? #breakExpr
    | CONTINUE #continueExpr
    | RETURN expr? #returnExpr
    | LB expr RB #bracketExpr
    | IF expr expr (ELIF expr expr)* (ELSE expr)? #ifelseExpr
    | LOOP expr #endlessLoopExpr
    | START expr* END #blockExpr
    | GLOBAL ID? (COMMA ID)* #globalExpr
    ;

WS: [ \n\r\t] -> channel(HIDDEN);
COMMENT: '//'~[\n]* -> channel(HIDDEN);
MUTICOMMENT: '/*'.*?'*/' -> channel(HIDDEN);

FUNC: 'func';
RETURN: 'return';
USING: 'using';
IN: 'in';
IF: 'if';
ELIF: 'elif' | 'else' ' '* 'if';
ELSE: 'else';
LOOP: 'loop';
BREAK: 'break';
CONTINUE: 'continue';
GLOBAL: 'global';
COMMA: ',';
SEMICOLON: ';'+;
LB: '(';
RB: ')';
LA: '[';
RA: ']';
START: '{';
END: '}';
DOT: '.';
EQ: '==';
NEQ: '!=';
SET: '=';
PLUS: '+';
MINUS: '-';
MULTIPLY: '*';
DIVIDE: '/';
REMAIN: '%';
NOT: '!';
AND: '&';
OR: '|';
GTR: '>';
GTREQ: '>=';
LWR: '<';
LWREQ: '<=';

fragment STRCHAR: ~["] | '\\"';
fragment INTEGER: [0-9]+;
fragment ESCAPECHAR: '\\'. ;
STRING: '"' (ESCAPECHAR | ~('"' | '\\'))* '"' | '\'' (ESCAPECHAR | ~('\'' | '\\'))* '\'';
INT: INTEGER;
DEC: INTEGER'.'INTEGER;
BOOL: 'true' | 'false';
NONE: 'none';
NAN: 'nan';
UNDEFINED: 'undefined';

fragment IDStart: ~[0-9 @[\]\-+=()*&^%!~`?<>,.:;"'\\|！#【】{}：。“”‘’/？《》，、·￥…（）；\r\n\t];
fragment IDPart: ~[ @[\]\-+=()*&^%!~`?<>,.:;"'\\|！#【】{}：。“”‘’/？《》，、·￥…（）；\r\n\t];
ID: IDStart IDPart*;