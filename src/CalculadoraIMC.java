import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC {
    private JTextField txtpeso;
    private JTextField txtaltura;
    private JButton btnsomar;
    private JLabel lblresultado;
    private JLabel lblcategoria;
    private JPanel panelmain;

    public CalculadoraIMC() {
        btnsomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double peso = Double.valueOf(txtpeso.getText());
                    double altura = Double.valueOf(txtaltura.getText());

                    if (peso <= 0 || altura <= 0) {
                        lblresultado.setText("Peso e altura devem ser maiores que zero.");
                        lblcategoria.setText("");
                        return;
                    }
                    double imc = peso / (altura * altura);

                    if (imc < 18.5) {
                        lblcategoria.setText("Baixo peso");
                    } else if (imc < 24.9) {
                        lblcategoria.setText("Peso normal");
                    } else if (imc < 29.9) {
                        lblcategoria.setText("Sobrepeso");
                    } else {
                        lblcategoria.setText("Obesidade");
                    }

                    lblresultado.setText("IMC: " + String.format("%.2f", imc));
                } catch (NumberFormatException ex) {
                    lblresultado.setText("Insira valores numéricos válidos.");
                    lblcategoria.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame tela = new JFrame("Calculadora IMC");
        tela.setContentPane(new CalculadoraIMC().panelmain);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.pack();
        tela.setVisible(true);
        tela.setSize(300, 259);
        tela.setLocationRelativeTo(null); // Centraliza a janela na tela
    }
}
