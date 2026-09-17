/*
 * Aula 6 P1 - Tratamento de Exceções no IF Quest
 *
 * Uso de IA: usei o Claude (Anthropic) para entender a diferença
 * entre exceções checked e unchecked, revisar erros de sintaxe
 * (chaves, ponto e vírgula, nomes de classe/anotação errados) e
 * para desenhar o método agir() como alternativa ao instanceof
 * dentro do laço da batalha. Validei manualmente rodando o programa
 * e conferindo cada mensagem de erro capturada no console.
 */
package excecoesifquest;
import java.util.ArrayList;
import java.util.List;

public class Demonstracao {
    public static void main(String[] args) {

        
        try {
            Personagem heroi = new Mago("Arthemis", -100, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar personagem: " + e.getMessage());
        }

        try {
            Personagem heroi2 = new Guerreiro("Zyrian", 100, 6);
        } catch (IllegalArgumentException e) {
            System.out.println("erro ao criar personagem: " + e.getMessage());
        }

        List<Personagem> herois = new ArrayList<>();
        Mago elara = new Mago("Frieren", 80, 5);
        Guerreiro thalos = new Guerreiro("Darkin", 90, 6);
        herois.add(elara);
        herois.add(thalos);

        Chefe reiLich = new Chefe("Rei Lich");


        for (Personagem heroi : herois) {
            System.out.println(heroi.ficha());
            System.out.println(heroi.getNome() + " usa " + heroi.habilidade());

            try {
                heroi.agir(reiLich);
            } catch (SemManaException e) {
                System.out.println(heroi.getNome() + " tentou lançar magia mas ficou sem mana: " + e.getMessage());
                System.out.println(heroi.getNome() + " perde o turno!");
            } finally {
                System.out.println("Fim do turno de " + heroi.getNome() + ".");
            }
            System.out.println("---");
        }

        System.out.println(reiLich.ficha());

        
        System.out.println("\n-- Testando Mago sem mana suficiente --");
        elara.setMana(5);
        try {
            elara.agir(reiLich);
        } catch (SemManaException e) {
            System.out.println(elara.getNome() + " tentou lançar magia mas ficou sem mana: " + e.getMessage());
            System.out.println(elara.getNome() + " perde o turno! " + thalos.getNome() + " ataca no lugar dele.");
            try {
                thalos.agir(reiLich);
            } catch (SemManaException ignorada) {
                
            }
        } finally {
            System.out.println("Fim do turno.");
        }

        System.out.println("\n-- Consulta de mana dos magos --");
        for (Personagem heroi : herois) {
            if (heroi instanceof Mago) {
                Mago mago = (Mago) heroi;
                System.out.println(mago.getNome() + " tem " + mago.getMana() + " de mana.\n");
            }
        }

        System.out.println("Teste de exceção: tentando criar um item com bônus negativo...");
        try {
            Item itemInvalido = new Item("Espada celestial", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar item: " + e.getMessage());
        }

        // Desafio A: catch direto, dois casos (item que o herói tem e um que não tem)
thalos.pegar(new Item("Poção de cura", 10));
try {
    System.out.println(thalos.usarItem("Poção de cura"));
} catch (ItemNaoEncontradoException e) {
    System.out.println("Erro: " + e.getMessage());
}
try {
    System.out.println(thalos.usarItem("Espada Lendária"));
} catch (ItemNaoEncontradoException e) {
    System.out.println("Erro: " + e.getMessage());
}

try {
    iniciarTurnoComItem(elara, "Cajado Arcano");
} catch (ItemNaoEncontradoException e) {
    System.out.println("Erro (via repasse do método): " + e.getMessage());
}
    }
private static void iniciarTurnoComItem(Personagem heroi, String nomeItem) throws ItemNaoEncontradoException {
    System.out.println(heroi.getNome() + " tenta usar o item: " + nomeItem);
    String resultado = heroi.usarItem(nomeItem);
    System.out.println(resultado);
}
}