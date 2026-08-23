public class Personagem {
    private String nome;
    private int vida;
    private int forca;

    public Personagem(){
        this.nome = "Frieren";
        this.vida = 100;
        this.forca = 10;
    }

    public Personagem(String nome, int vida, int forca){
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
    }
        public void receberDano(int dano){
            this.vida -= dano;
            if (this.vida < 0){
                this.vida = 0;
            }
        }
        public boolean estaVivo(){
            return this.vida > 0;
            }
        public void ficha(){
            System.out.println("Nome: " + this.nome);
            System.out.println("Vida: " + this.vida);
            System.out.println("Força: " + this.forca);
        }
        public void atacar(Personagem alvo){
            alvo.receberDano(this.forca);
        }
        public void atacar(){
            System.out.println(this.nome + " atacou o alvo, "+ this.forca + " de dano infligido!");
        }
        public void atacar(int dano){
            System.out.println(this.nome + " atacou o alvo, " + dano + " de dano infligido! ");
        }
        public static void main(String[] args){

              Personagem heroi = new Personagem("Herói", 100, 10);
              Personagem chefe = new Personagem("Chefe", 150, 15);
              Personagem frieren = new Personagem();

              System.out.println("\n|===Teste de sobrecarga de métodos===|\n");
              frieren.atacar();
              System.out.println();
              frieren.atacar(25);




              System.out.println("\n|-----Ficha dos Personagens-----|\n");
              heroi.ficha();
              System.out.println();
              chefe.ficha();

              while (heroi.estaVivo() && chefe.estaVivo()) {
                heroi.atacar(chefe);
                if (chefe.estaVivo()){
                    chefe.atacar(heroi);
                }
            }

            System.out.println("\n|=== Depois da batalha ===|\n");
               heroi.ficha();
               System.out.println();
               chefe.ficha();
               if (heroi.estaVivo()){
               System.out.println("\nO herói venceu!");
               } else {
               System.out.println("\nO chefe venceu!");
            }
            }   
}
