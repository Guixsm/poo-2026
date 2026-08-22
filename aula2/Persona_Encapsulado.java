public class Persona_Encapsulado{
    private String nome;
    private int vida;
    private int nivel; 

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
public static void main(String[] args){
    Persona_Encapsulado p = new Persona_Encapsulado();

System.out.println("|===Valores Válidos===|\n");

        p.setNome("Fer");
        p.setVida(100);
        p.setNivel(50);

        System.out.println("Nome: " + p.getNome());
        System.out.println("Vida: " + p.getVida());
        System.out.println("Nível: " + p.getNivel());

        System.out.println("\n|===Valores Inválidos===|\n");

        p.setNome("");
        p.setVida(150);
        p.setNivel(0);
}
}