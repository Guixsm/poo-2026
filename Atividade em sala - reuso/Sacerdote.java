public class Sacerdote extends Personagem{
    private int mana;

    public Sacerdote(String nome, int vida, int mana){
        super(nome, vida);
        this.mana = mana;
    }
    @Override
    public void atacar(){
    System.out.println(nome + " lançou cura milagrosa utilizando " + mana + "!");
    }
    @Override
    public String descricaoStatus(){
        return super.descricaoStatus() + "e mana " + mana + "!";
    }
}