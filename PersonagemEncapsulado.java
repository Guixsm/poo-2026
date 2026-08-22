public class PersonagemEncapsulado{
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
        System.out.println("Erro de Validação!");
 } else {
    this.nome = nome;
 }
}
 public void setVida(int v){
if ( v >= 0 && v <= 100){
    this.vida = v;
} else {
    System.out.println("Erro de Validação!");
}
 }
 public void setNivel(int n){
    if(n < 1){
        System.out.println("Erro de Validação!");
} else {
    this.nivel = n;
}
 }
public static void main (String[] args){

PersonagemEncapsulado p = new PersonagemEncapsulado();


System.out.println("===|Valores Válidos:==|\n");

p.setNome("Frieren");
p.setVida(100);
p.setNivel(50);

System.out.println("Nome: " + p.getNome());
System.out.println("Vida: " + p.getVida());
System.out.println("Nível: " + p.getNivel());

System.out.println("\n===|Valores Inválidos:|===\n");

p.setNome("");
p.setVida(150);
p.setNivel(0);
}
}