import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrodeContato {
    private JPanel mainpanel;
    private JLabel ablcadastro;
    private JTextField txtnome;
    private JTextField txttelefone;
    private JTextField txtemail;
    private JLabel ablemail;
    private JLabel abltelefone;
    private JLabel ablnome;
    private JButton btnadd;
    private JButton btnremover;
    private JList<String> listcontatos;
    private DefaultListModel<String> listModel;

    public CadastrodeContato() {
        listModel = new DefaultListModel<>();
        listcontatos.setModel(listModel);

        // Adiciona funcionalidade ao botãoo 'Adicionar'
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtnome.getText();
                String telefone = txttelefone.getText();
                String email = txtemail.getText();

                if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String contato = "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email;
                listModel.addElement(contato);

                txtnome.setText("");
                txttelefone.setText("");
                txtemail.setText("");
            }
        });

        // Adiciona funcionalidade ao botão 'Remover'
        btnremover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listcontatos.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um contato para remover.", "Erro de Seleção", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new CadastrodeContato().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
