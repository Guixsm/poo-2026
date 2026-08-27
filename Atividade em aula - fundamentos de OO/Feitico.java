/* Domínio: Sistema de magia RPG
Classes: Mago(nome, mana, vida, feitiço equipado) e Feitico(nome, custoDeMana)
Validações: 
1 - Referente à classe "Feitico" = Custo de mana e dano não poderão ser negativos.
2 - Referente à classe "Mago" = vida e mana não poderão ser negativos.
Tempo previsto:
| Feitico ~= (10 min) ; Mago ~= (20 min) ; Demonstracao ~=(10 min) ; Autoavaliação ~= (5 min) |
*/

public class Feitico{
    private String nome;
    private int CustoDeMana;
    private int dano;

    public Feitico(String nome, int CustoDeMana, int dano){
        this.nome = nome;
        setCustoDeMana(CustoDeMana);
        setDano(dano);
    }
    public String getNome(){
        return nome;
    } 
    public int getCustoDeMana(){
        return CustoDeMana;
    }
    public void setCustoDeMana(int CustoDeMana){
        if (CustoDeMana >= 0){
            this.CustoDeMana = CustoDeMana;
    } else {
        System.err.println("Mana insuficiente para castar o feitiço!");
    }
    }
    public int getDano(){
        return dano;
    }
    public void setDano(int dano){
        if (dano >= 0){
            this.dano = dano;
        } else {
            System.err.println("O feitiço foi ineficaz! não deu dano algum.");
        }
    }
}
