/*
 * Uso de IA:
 * Ferramenta utilizada: ChatGPT.
 * Finalidade: esclarecer minhas dúvidas sobre os conceitos de herança,
 * composição e sobrescrita de métodos, além de auxiliar na revisão
 * do código que desenvolvi.
 *
 * Desenvolvi e implementei o código manualmente. Utilizei a IA como
 * apoio para tirar dúvidas e revisar minha implementação. Realizei
 * os testes e as validações manualmente.
 */
package aula4_heranca_JAVA;
public class Demonstracao {
    public static void main(String[] args) {

    Item espada = new Item("Espada de Aço", 3);
    System.out.println(espada.descricao());
    System.out.println();

    Mago frieren = new Mago("Frieren", 100, 5);
    System.out.println(frieren.ficha());
    System.out.println();
    frieren.setMana(-10);
    System.out.println("Mana após tentativa: " +  frieren.getMana());
    System.out.println();
    frieren.pegar(espada);
    System.out.println(frieren.ficha());
    System.out.println();

    Guerreiro darkin = new Guerreiro("Darkin", 100, 10);
    System.out.println(darkin.ficha());
    System.out.println();
    darkin.receberDano(8);
    System.out.println("Vida após tomar 8 de dano: " + darkin.getVida());
}
}