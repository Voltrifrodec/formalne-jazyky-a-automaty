package sk.umb.fpv.fja.zadanie_2;

// Metoda pre poskytovanie vstupnych operandov pre Parser, ktory ich neskor podla toho spracuje.
public class Parser {
    
    private Token symbol;
    private Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }


    // Metoda pre vypocet vyrazu.
    public int statement() {
        return expr();
    }

    // Metoda pre sucet a rozdiel retazca.
    private int expr() {
        int result = mul();

        Token nextToken;
        do {
            nextToken = lexer.nextToken();
            switch (nextToken) {
                case PLUS:
                    lexer.consume();
                    result += mul();
                    break;
                case MINUS:
                    lexer.consume();
                    result -= mul();
                    break;
                default:
                    return result;
            }
        } while (nextToken == Token.PLUS || nextToken == Token.MINUS);
        
        return result;
    }

    // Metoda pre pracu s nasobenim a delenim retazca s osetrenym delenim nulou.
    private int mul() {

        int value = term();
        
        Token operator;
        do {
            operator = lexer.nextToken();
            switch(operator) {
                case MUL:
                    lexer.consume();
                    value *= term();
                    break;
                case DIV:
                    lexer.consume();
                    int temp = term();
					if (temp == 0) {
						throw new ArithmeticException("Delenie nulou");
					}
					value /= temp;
                    break;
                default: {
                    return value;
                }
            }

        } while(operator == Token.MUL || operator == Token.DIV);

        return value;
    }

    // Metoda pre nacitanie aritmetickych vyrazov. Ak sa jedna o o cislo, vrati jeho hodnotu, inak ak sa jedna o zatvorku, tak sa rekurzivne vola metoda expr() pre vyhodnotenie podvyrazu a ozatvorkovania. 
    private int term() {

        Token nextToken = lexer.nextToken();
        int temp = 0;

        switch (nextToken) {
            case NUMBER:
                temp = lexer.getValue();
                lexer.consume();
                return temp;
            case LPAR:
                lexer.consume();
                temp = expr();
                match(Token.RPAR);
                lexer.consume();
                return temp;
            default:
                throw new CalculatorException("Unexpected Parser.term() token: " + nextToken);
        }
    }


    // Metoda pre kontrolu zatvoriek (vezme nasledujuci token a skontroluje, ci je to ukoncovacia zatvorka).
    private void match(Token expectedSymbol) {
        Token nextToken = lexer.nextToken();

        if (nextToken != expectedSymbol)
            throw new CalculatorException("Expected " + expectedSymbol + " but found " + symbol);
    }

}
