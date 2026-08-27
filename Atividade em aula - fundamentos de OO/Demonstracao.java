public class Demonstracao{
    public static void main (String[] args){
        
        Feitico BolaDeFogo = new Feitico("BolaDeFogo", 20, 50);
        Mago Frieren = new Mago("Frieren", 100, 150, BolaDeFogo);

        System.out.println("Mago criado: " + Frieren.getNome()
        + "| Mana: " + Frieren.getMana()
        + "| Vida: " + Frieren.getVida()
        + "|Feitiço: " + Frieren.getFeitico().getNome());

        Mago Teste = new Mago("", -50, 100, BolaDeFogo);

            System.out.println("Mana após tentativa inválida: " + Teste.getMana());
    

        Mago Fer = new Mago("Fer", 80, 100);

            System.out.println("Mago criado com o segundo construtor: " + Fer.getNome() + "| Feitiço padrão: " + Fer.getFeitico().getNome());
        }
    }
/* Autoavaliação: Todos os critérios foram atingidos. A única problemática foi na organização do tempo, principalmente durante a implementação das classes.
A parte que mais me gerou dificuldade foi apenas em  saber como funcionava a sintaxe de algumas estruturas da linguagem, sendo resolvido após uma breve revisada no meu bloco de anotações.*/
