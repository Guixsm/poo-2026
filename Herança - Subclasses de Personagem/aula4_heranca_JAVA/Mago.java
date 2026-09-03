package aula4_heranca_JAVA;

public class Mago extends Personagem {
  
    private int mana;

    public Mago(String nome, int vida, int nivel){
    super(nome, vida, nivel);
    mana = 50;
}
public int getMana(){
    return mana;
}
public void setMana(int mana){
    if (mana >= 0){
        this.mana = mana;
    } else {
        System.err.println("Mana menor que 0, é inválida!");
    }
}
@Override
public String ficha() {
    return super.ficha() + "\nMana: " + mana;
}
}
