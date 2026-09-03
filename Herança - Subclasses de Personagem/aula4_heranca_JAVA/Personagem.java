package aula4_heranca_JAVA;
import java.util.ArrayList;

public class Personagem {
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
        System.out.println("ERRO DE VALIDAÇAO!");
    } else{
        this.nome = nome;
        }
}
public void setVida(int v){
    if(v >= 0 && v <= 100){
        this.vida = v; 
    } else {
        System.out.println("ERRO DE VALIDAÇAO!");
    }
}
public void setNivel(int n){
    if(n < 1){
        System.out.println("ERRO DE VALIDAÇAO!");
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
}