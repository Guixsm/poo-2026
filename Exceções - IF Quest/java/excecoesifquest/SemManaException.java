package excecoesifquest;

public class SemManaException extends Exception {

public SemManaException (int mana){
    super("O personagem não possui mana suficiente para realizar a ação. Mana atual: " + mana);
}
}
