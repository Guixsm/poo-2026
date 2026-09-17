package excecoesifquest;

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
    if (defesa < 0){
        throw new IllegalArgumentException("A defesa não pode ser negativa: " + defesa);
    } else {
        this.defesa = defesa;
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

@Override
public String habilidade(){
    return "golpe poderoso";
}
}