/*
 * Aula 6 P2 - Interface Gráfica com OO: A Tela de Criação de Herói
 *
 * Uso de IA: usei o Claude (Anthropic) para aprender o conceito de
 * JFrame e layout managers do Swing, e ajudar a estruturar da tela.
 * Validei manualmente executando o programa e conferindo a janela e
 * a saída no console.
 */

import javax.swing.*;
import java.awt.*;

public class TelaCriacaoHeroi extends JFrame {

    private JLabel rotuloTitulo;
    private JTextField campoNome;
    private JTextField campoVida;
    private JTextField campoClasse;
    private JButton botaoCriar;

    public TelaCriacaoHeroi() {

        super("IF Quest");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        rotuloTitulo = new JLabel("Novo Herói", SwingConstants.CENTER);
        add(rotuloTitulo, BorderLayout.NORTH);

        JPanel painelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));

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

        botaoCriar = new JButton("Criar Herói");

        botaoCriar.setEnabled(false);
        add(botaoCriar, BorderLayout.SOUTH);

        rotuloTitulo.setText("Criação de Herói");
        campoNome.setText("Digite o nome aqui");
        System.out.println("Texto atual do campo nome: " + campoNome.getText());
    }

    public static void main(String[] args) {
        TelaCriacaoHeroi tela = new TelaCriacaoHeroi();
        tela.setVisible(true);
    }
}