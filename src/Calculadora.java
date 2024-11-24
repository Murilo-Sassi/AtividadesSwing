import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//a
    public class Calculadora {
        private JTextField txtValor;
        private JButton btn9;
        private JButton btn2;
        private JButton btn3;
        private JButton btn4;
        private JButton btn1;
        private JButton btnVezes;
        private JButton btn0;
        private JButton btn6;
        private JButton btn7;
        private JButton btn8;
        private JButton btnSoma;
        private JButton btnMenos;
        private JButton btnIgual;
        private JButton btnClear;
        private JButton btn5;
        private JButton btnDiv;
        private JPanel panelMain;

        private int primeiroValor;
        private int segundoValor;
        private String operacao;

        public Calculadora() {
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtValor.setText(txtValor.getText() + "1");
                }
            });
            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtValor.setText(txtValor.getText() + "2");
                }
            });
            btn3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtValor.setText(txtValor.getText() + "3");
                }
            });
            btn4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtValor.setText(txtValor.getText() + "4");
                }
            });
            btn5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtValor.setText(txtValor.getText() + "5");
                }
            });
            btn6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtValor.setText(txtValor.getText() + "6");
                }
            });
            btn7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtValor.setText(txtValor.getText() + "7");
                }
            });
            btn8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtValor.setText(txtValor.getText() + "8");
                }
            });
            btn9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtValor.setText(txtValor.getText() + "9");
                }
            });
            btn0.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtValor.setText(txtValor.getText() + "0");
                }
            });

            btnClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtValor.setText("");
                    primeiroValor = 0;
                    segundoValor = 0;
                    operacao = "";
                }
            });

            btnDiv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    primeiroValor = Integer.parseInt(txtValor.getText());
                    operacao = "/";
                    txtValor.setText("");
                }
            });

            btnVezes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    primeiroValor = Integer.parseInt(txtValor.getText());
                    operacao = "*";
                    txtValor.setText("");
                }
            });

            btnMenos.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    primeiroValor = Integer.parseInt(txtValor.getText());
                    operacao = "-";
                    txtValor.setText("");
                }
            });

            btnSoma.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    primeiroValor = Integer.parseInt(txtValor.getText());
                    operacao = "+";
                    txtValor.setText("");
                }
            });

            btnIgual.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    segundoValor = Integer.parseInt(txtValor.getText());
                    int resultado = 0;

                    switch (operacao) {
                        case "+":
                            resultado = primeiroValor + segundoValor;
                            break;
                        case "-":
                            resultado = primeiroValor - segundoValor;
                            break;
                        case "*":
                            resultado = primeiroValor * segundoValor;
                            break;
                        case "/":
                            if (segundoValor != 0) {
                                resultado = primeiroValor / segundoValor;
                            } else {
                                JOptionPane.showMessageDialog(null, "Divisão por zero não é permitida.");
                                resultado = 0;
                            }
                            break;
                    }

                    txtValor.setText(String.valueOf(resultado));
                }
            });
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Calculadora");
            frame.setContentPane(new Calculadora().panelMain);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }
