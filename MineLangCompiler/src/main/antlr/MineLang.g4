grammar MineLang;

program: expr*
  EOF
  ;

callArgs: LB expr? (COMMA expr)* COMMA? RB;

expr: (INT | DEC | STRING | BOOL | NONE | NAN) #literalExpr
    | ID SET expr #varSetExpr
    | ID #varUseExpr
    | expr DOT ID #getExpr
    | expr callArgs #funcCallExpr
    | expr NOT #notExpr
    | expr (MUTIPLY | DEVIDE | REMAIN) expr #mutiplyDevideRemainExpr
    | expr (PLUS | MINUS) expr #plusMinusExpr
    | expr (EQ | NEQ) expr #isEqExpr
    | expr (GTR | GTREQ | LWR | LWREQ) expr #compareExpr
    | BREAK expr #breakExpr
    | LB expr RB #bracketExpr
    | IF expr expr (ELIF expr expr)* (ELSE expr)? #ifelseExpr
    | LOOP expr #endlessLoopExpr
    | START expr* END #blockExpr
    ;

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
COMMA: ',';
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
MUTIPLY: '*';
DEVIDE: '/';
REMAIN: '%';
NOT: '!';
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

fragment IDStart: ~[0-9 @[\]\-+=()*&^%!~`?<>,.:;"'\\|！#【】{}：。“”‘’/？《》，、·￥…（）；\r\n];
fragment IDPart: ~[ @[\]\-+=()*&^%!~`?<>,.:;"'\\|！#【】{}：。“”‘’/？《》，、·￥…（）；\r\n];
ID: IDStart IDPart*;

WS: [ \n\r\t] -> channel(HIDDEN);
COMMENT: '//'~[\n]* -> channel(HIDDEN);
MUTICOMMENT: '/*'.*?'*/' -> channel(HIDDEN);