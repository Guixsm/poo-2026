package excecoesifquest;

public class ItemNaoEncontradoException extends Exception {
    public ItemNaoEncontradoException(String nomeItem) {
        super("Item não encontrado no inventário: " + nomeItem);
    }
}