/* 
#Domínio: RPG de combate em turnos
#Superclasse: Personagem (String nome, int vida)
#Subclasses: Paladino(forcaFisica) // Sacerdote(mana)
#Método abstrado: atacar()
#método sobrescrito: descricaoStatus()
Uso de IA: Utilizado para a revisão de sintaxe e estruturação do código */

import java.util.ArrayList;
import java.util.List;

public class Demostracao {
    public static void main(String[] args) {
        List<Personagem> grupo = new ArrayList<>();
        grupo.add(new Paladino("Lauriel", 200, 50));
        grupo.add(new Sacerdote("Silfy", 100, 150));

        for(Personagem p : grupo){
            System.out.println(p.descricaoStatus());
            p.atacar();
         }
    }
}
