
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tables extends JDialog {
    private JPanel tabel;
    private JButton BackBTN;
    private JTextArea tableValues;


    public Tables(JFrame parent, String[][] sb) {
        super(parent);
        setTitle("TABLES");
        setContentPane(tabel);
        setMinimumSize(new Dimension(600, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        for (String[] row : sb) {

            for (String value : row) {
                tableValues.append(value);
            }
            tableValues.append("\n");
        }

        tableValues.setEditable(false);

        BackBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LiverpoolFC liverpoolFC = new LiverpoolFC(null);
                liverpoolFC.setVisible(true);
            }

        });

    }
}

