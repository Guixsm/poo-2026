public class Paladino extends Personagem{
    private int forcaFisica;
    
    public Paladino(String nome, int vida, int forcaFisica){
        super(nome, vida);
        this.forcaFisica = forcaFisica;
    }
    @Override
    public void atacar(){
        System.out.println(nome + " desfere uma investida pesada com força " + forcaFisica + "!");
    }
    @Override
    public String descricaoStatus(){
        return super.descricaoStatus() + "e força física " + forcaFisica + "!";
    }
}