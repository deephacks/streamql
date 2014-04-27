grammar StreamQl;

@header {
    package deephacks.streamql;
}

parse: expression;

// enable any order for limit skip and order keywords
expression
  : (ID)? ('filter' or)? ('skip' skip)? ('limit' limit)? (ordering)?
  | (ID)? ('filter' or)? ('limit' limit)? ('skip' skip)? (ordering)?
  | (ID)? ('filter' or)? (ordering)? ('limit' limit)? ('skip' skip)?
  | (ID)? ('filter' or)? (ordering)? ('skip' skip)? ('limit' limit)?;

or: and (OR and)*;

and: not (AND not)*;

not: NOT filter | filter;

limit: NUMBER (',' NUMBER)?;

skip: NUMBER;

// either reversed or ordered, not both
ordering: (('ordered' ordered) | ('reversed' reversed))?;
ordered: (ID (',' ID)*)?;
reversed: (ID (',' ID)*)?;

filter
  : (ID)? operator value
  // enable parentheses around expressions
  | '(' or ')';

value: STRING | NUMBER | DECIMAL | NULL | TRUE | FALSE;

fragment QUOTE :   '\'' ;

// "hello"
STRING : QUOTE .*? QUOTE ;

// -3, 45
NUMBER:  '-'? INT;

 // 1.35, 0.3, -4.5
DECIMAL: '-'? INT '.' INT;

// no leading zeros
fragment INT : '0' | [1-9] [0-9]* ;

NULL:  'null';
TRUE:  'true';
FALSE:  'false';

AND : '&&';
OR  : '||';
NOT : '!';
EQ : '==';
NT_EQ : '!=';
LT_EQ : '<=';
GT_EQ : '>=';
GT : '>';
LT : '<';
CONTAINS : 'contains';
STARTS_WITH: 'startsWith';
ENDS_WITH: 'endsWith';
REGEXP: 'regExp';

operator : EQ | NT_EQ | LT | LT_EQ | GT | GT_EQ | CONTAINS | STARTS_WITH | ENDS_WITH | REGEXP;

ID : [a-zA-Z0-9\.\_\$]+;


// skip whitespace globally everywhere
WS : [ \t\r\n]+ -> skip ;