import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SquadMeniuManchesterUnited extends JDialog {
    private JPanel manchesterUnited;
    private JButton SQUADButton;
    private JButton GAMESButton;
    private JButton BACKButton;
    private JTextArea valuesTextArea;

    public SquadMeniuManchesterUnited(JFrame parent){
        super(parent);
        setTitle("MANCHESTER UNITED");
        setContentPane(manchesterUnited);
        setMinimumSize(new Dimension(600, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                HomePage homePage = new HomePage(null);
                homePage.setVisible(true);
            }
        });


        SQUADButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] sb = null;
                refresh();
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);
                    Connection connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_UNITED, ConfigurationSetings.USERNAME_UNITED, ConfigurationSetings.PASSWORD_UNITED);
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
        GAMESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] sb = null;
                refresh();
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);
                    Connection connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_UNITED, ConfigurationSetings.USERNAME_UNITED, ConfigurationSetings.PASSWORD_UNITED);
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
    }

    public void refresh(){
        valuesTextArea.setText(null);
    }
}
