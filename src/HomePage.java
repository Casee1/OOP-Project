import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JDialog {
    private JPanel homePage;
    private JButton liverpoolButton;
    private JLabel iconLabel;
    private JButton chelseaButton;
    private JButton manchesterCityButton;
    private JButton newcastleButton;
    private JButton arsenalButton;
    private JButton manchesterUnitedButton;
    private JButton cancelButton;

    public HomePage(JFrame parent) {
        super(parent);
        setTitle("PREMIER LEAGUE");
        setContentPane(homePage);
        setMinimumSize(new Dimension(600, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        liverpoolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LiverpoolFC liverpoolFC = new LiverpoolFC(null);
                liverpoolFC.setVisible(true);
            }
        });

        chelseaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SquadMeniu squadMeniu = new SquadMeniu(null);
                squadMeniu.setVisible(true);

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        arsenalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SquadMeniuArsenal squadMeniuArsenal = new SquadMeniuArsenal(null);
                squadMeniuArsenal.setVisible(true);

            }
        });
        newcastleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SquadMeniuNewcastle squadMeniuNewcastle = new SquadMeniuNewcastle(null);
                squadMeniuNewcastle.setVisible(true);
            }
        });
        manchesterCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SquadMeniuManchesterCity squadMeniuManchesterCity = new SquadMeniuManchesterCity(null);
                squadMeniuManchesterCity.setVisible(true);
            }
        });
        manchesterUnitedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SquadMeniuManchesterUnited squadMeniuManchesterUnited = new SquadMeniuManchesterUnited(null);
                squadMeniuManchesterUnited.setVisible(true);
            }
        });
    }
}
