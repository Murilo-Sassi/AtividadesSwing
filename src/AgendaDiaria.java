import netscape.javascript.JSObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class AgendaDiaria {
    private JTextField txtcomp;
    private JSpinner sphora;
    private JButton btnadd;
    private JButton btnremover;
    private JTable table1;
    private JPanel mainpanel;

    public AgendaDiaria() {

        JFrame frame = new JFrame();
        frame.setTitle("Agenda Diária");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));

        panel.add(new JLabel("Compromisso"));
        txtcomp = new JTextField();
        panel.add(txtcomp);

        panel.add(new JLabel("Data/Hora"));
        sphora = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(sphora, "dd/MM/yyyy HH:mm");
        sphora.setEditor(editor);
        panel.add(sphora);

        btnadd = new JButton("Adicionar");
        btnremover = new JButton("Remover");
        panel.add(btnadd);
        panel.add(btnremover);

        frame.add(panel, BorderLayout.NORTH);

        table1 = new JTable();
        table1.setModel(new DefaultTableModel(new Object[]{"Data/Hora", "Descrição"}, 0));
        JScrollPane scrollPane = new JScrollPane(table1);
        frame.add(scrollPane, BorderLayout.CENTER);

        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descricao = txtcomp.getText();
                if (descricao.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um compromisso");
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String datahora = sdf.format(sphora.getValue());
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.addRow(new Object[]{datahora, descricao});
                txtcomp.setText("");
            }
        });

        btnremover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaselecionada = table1.getSelectedRow();
                if (linhaselecionada == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um compromisso");
                } else {
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.removeRow(linhaselecionada);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgendaDiaria());
    }
}
