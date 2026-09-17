package excecoesifquest;


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
    throw new IllegalArgumentException("O nome não pode estar vazio!");
}else{
    this.nome = nome;
}
}
public int getBonus(){
    return bonus;
}
public void setBonus(int b){
    if (b < 0){
        throw new IllegalArgumentException("O bônus não pode ser negativo: " + b);
    } else {
        this.bonus = b;
    }
}
public String descricao() {
    return nome + " (+" + bonus + ")";
}
}




