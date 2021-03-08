%option noyywrap
%{
#include <math.h>
%}
DIGIT    [0-9]
ID       [A-Za-z]
TT       [A-Za-z0-9._-]

%%
{ID}{TT}*"@"{ID}+"."*{ID}*"."{ID}+   {
            printf( "mail id  %s \n", yytext);
            }
.*           printf( "Unrecognized string %s \n", yytext );
%%
main( argc, argv )
int argc;
char **argv;
    {
    ++argv, --argc;  /* skip over program name */
    if ( argc > 0 )
            yyin = fopen( argv[0], "r" );
    else
            yyin = stdin;

    yylex();
    }




