package aula4_heranca_JAVA;

public class Guerreiro extends Personagem{

        private int defesa;

public Guerreiro(String nome, int vida, int nivel){
    super(nome, vida, nivel);
    defesa = 5;
}
public int getDefesa(){
    return defesa;
}
public void setDefesa(int defesa){
    if (defesa >= 0){
        this.defesa = defesa;
    } else {
        System.err.println("Defesa inválida");
    }
}
@Override
public void receberDano(int dano){
    super.receberDano(Math.max(0, dano - defesa));
}
@Override
public String ficha(){
    return super.ficha() + "\nDefesa: " + defesa;
}
}