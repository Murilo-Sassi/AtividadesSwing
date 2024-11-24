import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AplicativoNotas {
    private JTextField txtnota;
    private JButton btnadd;
    private JButton btnCalcularMedia;
    private JTextArea txtlista;
    private JPanel panelmain;
    private JLabel lblresultado;
    private ArrayList<Double> notas;

    public AplicativoNotas() {
        notas = new ArrayList<>();

        // Inicializando os componentes da interface gráfica
        txtnota = new JTextField(10); // Campo para inserir a nota
        btnadd = new JButton("Adicionar Nota"); // Botão para adicionar a nota
        btnCalcularMedia = new JButton("Calcular Média"); // Botão para calcular a média
        txtlista = new JTextArea(10, 30); // Área de texto para listar as notas
        lblresultado = new JLabel("Média: 0.0"); // Rótulo que exibirá a média
        panelmain = new JPanel(); // Painel principal

        // Tornando a área de texto somente leitura
        txtlista.setEditable(false);
        txtlista.setLineWrap(true);
        txtlista.setWrapStyleWord(true);

        // Adicionando componentes ao painel principal
        panelmain.setLayout(new BoxLayout(panelmain, BoxLayout.Y_AXIS));
        panelmain.add(new JLabel("Insira a nota:"));
        panelmain.add(txtnota);
        panelmain.add(btnadd);
        panelmain.add(btnCalcularMedia);
        panelmain.add(new JScrollPane(txtlista));
        panelmain.add(lblresultado);

        // Adicionando ação ao botão "Adicionar Nota"
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double nota = Double.parseDouble(txtnota.getText()); // Tenta converter para double
                    notas.add(nota); // Adiciona a nota à lista
                    txtnota.setText(""); // Limpa o campo de texto
                    atualizarListaNotas(); // Atualiza a lista de notas
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para a nota.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adicionando ação ao botão "Calcular Média"
        btnCalcularMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMedia();
            }
        });
    }

    private void atualizarListaNotas() {
        StringBuilder sb = new StringBuilder();
        for (Double nota : notas) {
            sb.append(nota).append("\n"); // Adiciona cada nota em uma nova linha
        }
        txtlista.setText(sb.toString()); // Atualiza a área de texto com a lista de notas
    }

    private void calcularMedia() {
        if (notas.size() > 0) {
            double soma = 0;
            for (Double nota : notas) {
                soma += nota; // Soma todas as notas
            }
            double media = soma / notas.size(); // Calcula a média
            String status = media >= 7.0 ? "Aprovado" : "Reprovado"; // Verifica o status de aprovação
            lblresultado.setText("Média: " + String.format("%.2f", media) + " - " + status);

            JOptionPane.showMessageDialog(null, status + " com média " + String.format("%.2f", media), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            lblresultado.setText("Média: 0.0"); // Caso não haja notas, exibe média 0.0
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Notas");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AplicativoNotas().panelmain);
        frame.setVisible(true);
    }
}