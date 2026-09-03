public class Mago {
    private String nome;
    private int mana;
    private int vida;
    private Feitico feitico;

    public Mago(String nome, int mana, int vida, Feitico feitico){
        this.nome = nome;
        setMana(mana);
        setVida(vida);
        this.feitico = feitico;
    }
    public Mago(String nome, int mana, int vida){
        this(nome, mana, vida, new Feitico("Estalactite de Gelo", 50, 100));
    }
    public String getNome(){
        return nome;
    }
    public int getMana(){
        return mana;
    }
    public void setMana(int mana){
        if (mana >=0 ){
            this.mana = mana;
        } else {
            System.err.println("Você não possui mana para usar o feitiço!");
        }
    }
    public int getVida(){
        return vida;
    }
    public void setVida(int vida){
        if (vida >= 0){
            this.vida = vida;
        } else {
            System.err.println("Você está morto! nunca vi cadavér usar feitiço (ao menos que você seja um necromante)");
        }
    }
    public Feitico getFeitico(){
        return feitico;
    }
}
