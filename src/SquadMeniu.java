import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SquadMeniu extends JDialog {
    private JPanel squadMeniu;
    private JButton gamesButton;
    private JTextArea valuesTextArea;
    private JButton squadButton;
    private JButton backButton;

    public SquadMeniu(JFrame parent) {
        super(parent);
        setTitle("CHELSEA");
        setContentPane(squadMeniu);
        setMinimumSize(new Dimension(600, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        valuesTextArea.setEditable(false);


        squadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] sb = null;
                refresh();
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);
                    Connection connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_CHELSEA, ConfigurationSetings.USERNAME_CHELSEA, ConfigurationSetings.PASSWORD_CHELSEA);
                    Statement stn = connection.createStatement();
                    sb = new String[30][10];
                    ResultSet r = stn.executeQuery("SELECT * FROM squad");
                    int rows = 0;
                    while (r.next()) {
                        sb[rows][0] = r.getString("NUME") + "       ";
                        sb[rows][1] = r.getString("NR_TRICOU") + "      ";
                        sb[rows][2] = r.getString("POZITIE");
                        rows++;
                    }

                    for (String row[] : sb) {
                        for (String value : row) {
                            valuesTextArea.append(value);
                        }
                        valuesTextArea.append("\n");
                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        gamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] sb = null;
                refresh();
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);
                    Connection connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_CHELSEA, ConfigurationSetings.USERNAME_CHELSEA, ConfigurationSetings.PASSWORD_CHELSEA);
                    Statement stn = connection.createStatement();
                    sb = new String[30][10];
                    ResultSet r = stn.executeQuery("SELECT * FROM games");
                    int rows = 0;
                    while (r.next()) {
                        sb[rows][0] = r.getString("meci") + "       ";
                        sb[rows][1] = r.getString("data") + "      ";
                        rows++;
                    }

                    for (String row[] : sb) {
                        for (String value : row) {
                            valuesTextArea.append(value);
                        }
                        valuesTextArea.append("\n");
                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                HomePage homePage = new HomePage(null);
                homePage.setVisible(true);
            }
        });
    }

    public void refresh() {
        valuesTextArea.setText(null);
    }
}

