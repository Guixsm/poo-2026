/*
 * Aula 5 P1 - Polimorfismo: A Batalha Final do IF Quest
 *
 * Uso de IA: usei o Claude (Anthropic) para me auxiliar em aplicar o método
 * abstrato habilidade() nas subclasses, implementar o instanceof e
 * montar o laço da batalha final, a partir das minhas classes
 * Personagem/Item/Mago/Guerreiro já prontas. Validei manualmente
 * rodando o programa e conferindo a ficha do Chefe e as habilidades
 * exibidas no console. 
 */
package Aula05_Polimorfismo_java;
import java.util.ArrayList;
import java.util.List;

public class Demonstracao {
    public static void main(String[] args) {

        List<Personagem> herois = new ArrayList<>();
        Mago elara = new Mago("Frieren", 80, 5);
        Guerreiro thalos = new Guerreiro("Darkin", 90, 6);
        herois.add(elara);
        herois.add(thalos);

        Chefe reiLich = new Chefe("Rei Lich");

        for (Personagem heroi : herois) {
            System.out.println(heroi.ficha());
            System.out.println(heroi.getNome() + " usa " + heroi.habilidade());

            int dano = heroi.getNivel() * 10;
            reiLich.receberDano(dano);
            System.out.println(heroi.getNome() + " ataca o Rei Lich causando " + dano + " de dano!");
            System.out.println("---");
        }

        System.out.println(reiLich.ficha());

        // Usar o instanceof aqui é aceitável porque é uma checagem específica,
        // avulsa, que não repete comportamento genérico. Dentro do
        // laço da batalha isso não seria aceitável, porque ali o
        // objetivo é justamente tratar todos os heróis de forma
        // uniforme através do mesmo comando (ficha(), habilidade());
        // usar instanceof lá quebraria o polimorfismo.

        System.out.println("\n-- Consulta de mana dos magos --");
        for (Personagem heroi : herois) {
            if (heroi instanceof Mago) {
                Mago mago = (Mago) heroi;
                System.out.println(mago.getNome() + " tem " + mago.getMana() + " de mana.");
            }
        }
    }
}