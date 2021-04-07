%{
#include<stdio.h>
%}
%%
auto|double|int|struct|break|else|long|switch|case|while|do|typedef|char|extern|return|for|signed|void|do|if|static|true|false  printf("Keyword");
[-,+]?[0-9]+ printf("Constants");
[,.'"]? printf("Punctuation Chars");
[{};,()]? printf("Separator");
[!@#$%^&*]? printf("Special Chars");
[+-/=!*%]? printf("Operator");
[a-zA-Z][a-zA-Z0-9_]*+ printf("Identifiers");
%%
main(){
	yylex();
}

int yywrap()
{
   return 1;
}