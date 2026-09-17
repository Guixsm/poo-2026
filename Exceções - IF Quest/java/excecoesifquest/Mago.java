package excecoesifquest;

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
    if (mana < 0){
        throw new IllegalArgumentException("A mana não pode ser negativa: " + mana);
    } else {
        this.mana = mana;
    }
}
@Override
public String ficha() {
    return super.ficha() + "\nMana: " + mana;
}

@Override
public String habilidade(){
    return "rajada arcana";
}

public String lancarMagia(int custo) throws SemManaException {
    if (custo > mana){
        throw new SemManaException(mana);
    } else {
        mana -= custo;
        return "Magia lançada com sucesso! custo: " + custo + ", mana restante: " + mana;
    }
}

@Override
public void agir(Personagem alvo) throws SemManaException {
    String resultado = lancarMagia(20);
    System.out.println(resultado);
    int dano = getNivel() * 15;
    alvo.receberDano(dano);
    System.out.println(getNome() + " atinge " + alvo.getNome() + " com magia causando " + dano + " de dano!");
}
}