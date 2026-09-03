public abstract class Personagem{
    protected String nome;
    protected int vida;

    public Personagem(String nome, int vida){
        this.nome = nome;
        this.vida = vida;
    }
    public void atacar(){
        System.out.println(nome +"Não usou o cerébro e atacou de qualquer jeito");
    }
    public String descricaoStatus(){
        return nome + " tem " + vida + " de vida ";
    }
}
