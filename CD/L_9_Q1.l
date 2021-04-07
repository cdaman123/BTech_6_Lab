%{
#include"y.tab.h"
extern char * yytext;
%}
%%
[A-Za-z0-9]+  { return NUM;}
\n      return 0;
.       return *yytext;
%%

int yywrap(){
    return 1;
}