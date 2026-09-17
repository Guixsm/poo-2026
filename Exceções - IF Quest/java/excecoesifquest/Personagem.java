package excecoesifquest;
import java.util.ArrayList;

public abstract class Personagem {
    private String nome;
    private int vida;
    private int nivel; 
    private ArrayList<Item> inventario;
    
public Personagem(String nome, int vida, int nivel){
    setNome(nome);
    setVida(vida);
    setNivel(nivel);
    inventario = new ArrayList<>();
}
public String getNome(){
   return nome;
}
public int getVida(){
    return vida;
}
public int getNivel(){
    return nivel;
}
public void setNome(String nome){
    if(nome == null || nome.isEmpty()){
        throw new IllegalArgumentException("O nome não pode estar vazio!");
    } else {
        this.nome = nome;
    }
}
public void setVida(int v){
    if(v < 0 ||v > 200){
        throw new IllegalArgumentException("A vida deve estar entre 0 e 200. Valor fornecido: " + v);
    } else {
        this.vida = v;
    }
}
public void setNivel(int n){
    if(n < 1){
        throw new IllegalArgumentException("O nível deve ser maior ou igual a 1. Valor fornecido: " + n);
    } else {
        this.nivel = n;
    }
}
public String ficha() {
    String resultado = "Nome: " + nome + "\n" + 
    "Vida: " + vida +"\n" +
    "Nível: " + nivel + "\n" + 
    "Inventário: "; 
    for (Item item : inventario) {
    resultado += "\n- " + item.descricao();
    }
    return resultado;
}
public void receberDano(int dano){
    vida -= dano;
}
public void pegar(Item item) {
    inventario.add(item);
}
public String usarItem(String nomeItem) throws ItemNaoEncontradoException {
    for (Item item : inventario) {
        if (item.getNome().equalsIgnoreCase(nomeItem)) {
            return getNome() + " usa " + item.descricao() + "!";
        }
    }
    throw new ItemNaoEncontradoException(nomeItem);
}

public abstract String habilidade();

public void agir(Personagem alvo) throws SemManaException {
    int dano = getNivel() * 10;
    alvo.receberDano(dano);
    System.out.println(getNome() + " ataca " + alvo.getNome() + " causando " + dano + " de dano!");
}
}