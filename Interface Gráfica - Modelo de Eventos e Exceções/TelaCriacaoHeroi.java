/*
 * Aula 7 P1 - Interface Gráfica: Modelo de Eventos e Exceções
 *
 * Uso de IA: utilizei ChatGPT para
 * compreender o modelo de eventos do Swing, o uso de ActionListener,
 * o tratamento de exceções e a integração da interface gráfica
 * com as classes Guerreiro e Personagem.
 *
 * As ferramentas de IA também foram utilizadas para auxiliar na
 * estruturação e revisão do código. A implementação foi modificada
 * e validada manualmente, incluindo a execução do programa e os
 * testes de entradas válidas e inválidas, do clique do botão e
 * da tecla Enter.
 */

import javax.swing.*;
import java.awt.*;
import excecoesifquest.Guerreiro;

public class TelaCriacaoHeroi extends JFrame {

    private JLabel rotuloTitulo;
    private JTextField campoNome;
    private JTextField campoVida;
    private JTextField campoClasse;
    private JButton botaoCriar;
    private JLabel rotuloResultado;

    public TelaCriacaoHeroi() {

        super("IF Quest");

        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        rotuloTitulo = new JLabel(
                "Criação de Herói",
                SwingConstants.CENTER
        );

        add(rotuloTitulo, BorderLayout.NORTH);

        JPanel painelFormulario =
                new JPanel(new GridLayout(3, 2, 5, 5));

        painelFormulario.add(new JLabel("Nome:"));

        campoNome = new JTextField();
        painelFormulario.add(campoNome);

        painelFormulario.add(new JLabel("Vida inicial:"));

        campoVida = new JTextField();
        painelFormulario.add(campoVida);

        painelFormulario.add(new JLabel("Classe (Mago/Guerreiro):"));

        campoClasse = new JTextField();
        painelFormulario.add(campoClasse);

        add(painelFormulario, BorderLayout.CENTER);

        JPanel painelInferior =
                new JPanel(new GridLayout(2, 1));

        rotuloResultado = new JLabel(
                "Preencha os dados e crie o herói.",
                SwingConstants.CENTER
        );

        painelInferior.add(rotuloResultado);

        botaoCriar = new JButton("Criar Herói");

        botaoCriar.addActionListener(e -> criarHeroi());

        painelInferior.add(botaoCriar);

        add(painelInferior, BorderLayout.SOUTH);

        campoVida.addActionListener(e -> criarHeroi());
    }
    private void criarHeroi() {

        try {

            String nome = campoNome.getText();

            String textoVida = campoVida.getText();

            int vida = Integer.parseInt(textoVida);

            Guerreiro guerreiro =
                    new Guerreiro(nome, 0, 1);

            guerreiro.setVida(vida);

            rotuloResultado.setText(
                    "Herói criado: "
                    + guerreiro.getNome()
                    + " - Vida: "
                    + guerreiro.getVida()
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vida deve ser um número!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (IllegalArgumentException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        TelaCriacaoHeroi tela =
                new TelaCriacaoHeroi();

        tela.setVisible(true);
    }
}