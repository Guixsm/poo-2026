
public class Personagem {
    private String nome;
    private int vida;
    private int forca;

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
        public static void main(String[] args){
              Personagem heroi = new Personagem("Herói", 100, 10);
              Personagem chefe = new Personagem("Chefe", 150, 15);

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

            System.out.println("\n|=== Depois da batalha ===\n");
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
