package Aula05_Polimorfismo_java;

public class Chefe extends Personagem {

    private int forca;

    public Chefe(String nome){
        super(nome, 200, 10);
        this.forca = 20;
    }

    public int getForca(){
        return forca;
    }

    @Override
    public String habilidade(){
        return "ataque devastador";
    }

    @Override
    public String ficha(){
        return "[CHEFE] " + super.ficha() + "\nForça: " + forca;
    }
}