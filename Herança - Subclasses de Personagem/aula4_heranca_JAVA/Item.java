package aula4_heranca_JAVA;

public class Item {

    private String nome;
    private int bonus;

public Item(String nome, int bonus){
    setNome(nome);
    setBonus(bonus);
}
public String getNome(){
    return nome;
}
public void setNome(String nome){
if (nome == null || nome.isEmpty()){
    System.err.println("Nome inválido");
}else{
    this.nome = nome;
}
}
public int getBonus(){
    return bonus;
}
public void setBonus(int b){
    if (b >= 0){
         this.bonus = b;
    } else {
       System.err.println("Bonus inválido");
    }
}
public String descricao() {
    return nome + " (+" + bonus + ")";
}
}




