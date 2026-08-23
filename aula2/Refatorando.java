
class Refatorando {
    
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
    if (nome == null || nome.isEmpty()){
        System.out.println("INVÁLIDO!");
    } else {
        this.nome = nome;
    }
}

public void setVida(int v){
    if (v >= 0 && v <= 100){
        this.vida = v;
    } else {
    System.out.println("INVÁLIDO!");
}
}

public void setNivel(int n){
    if (n >= 1){
        this.nivel = n;
    } else {
     System.out.println("INVÁLIDO!");
}
}

public static void main (String[] args){

Refatorando p = new Refatorando();

System.out.println("|===Demostração de valores inválidos===|\n");

p.setVida(-50);  // Valor inválido aceito diretamente
p.setNome("");   // Nome vazio aceito


System.out.println("Vida: " + p.getVida());
System.out.println("Nome: " + p.getNome());
}
}