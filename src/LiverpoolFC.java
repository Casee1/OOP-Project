import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;


public class LiverpoolFC extends JDialog {
    private JPanel liverpoolFC;
    private JTextField THISISANFIELDTextField;
    private JButton SquadBTN;
    private JButton CompetitionsBTN;
    private JButton GamesBTN;
    private JButton TeamsBTN;
    private JButton RefereesBTN;
    private JButton HymnBTN;
    private JButton LocationBTN;
    private JButton JuniorBTN;
    private JButton CancelBTN;
    private JButton Insert;
    private JButton Delete;
    private JTextField NUME;
    private JTextField TRICOU;
    private JTextField POZITIE;
    private JButton uploadBTN;
    private JLabel NumeLABEL;
    private JButton backButton;

    public LiverpoolFC(JFrame parent) {
        super(parent);
        setTitle("LIVERPOOL");
        setContentPane(liverpoolFC);
        setMinimumSize(new Dimension(600, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        THISISANFIELDTextField.setEditable(false);

        HymnBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String youtubeLink = "https://www.youtube.com/watch?v=OV5_LQArLa0&ab_channel=GerryPacemakers";
                try {
                    Desktop.getDesktop().browse(new URI(youtubeLink));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        CancelBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        SquadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[][] sb = null;
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);

                    Connection connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_MENIU, ConfigurationSetings.USERNAME_MENIU, ConfigurationSetings.PASSWORD_MENIU);
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


                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
                Tables table = new Tables(null, sb);
                table.setVisible(true);
            }
        });
        CompetitionsBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[][] sb = null;
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);
                    Connection connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_MENIU, ConfigurationSetings.USERNAME_MENIU, ConfigurationSetings.PASSWORD_MENIU);
                    Statement stn = connection.createStatement();
                    sb = new String[30][10];
                    ResultSet r = stn.executeQuery("SELECT * FROM competitions");
                    int rows = 0;
                    while (r.next()) {

                        sb[rows][0] = r.getString("COMPETITION") + "  ";
                        rows++;

                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
                Tables table = new Tables(null, sb);
                table.setVisible(true);
            }
        });
        TeamsBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[][] sb = null;
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);
                    Connection connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_MENIU, ConfigurationSetings.USERNAME_MENIU, ConfigurationSetings.PASSWORD_MENIU);
                    Statement stn = connection.createStatement();
                    sb = new String[30][10];
                    ResultSet r = stn.executeQuery("SELECT * FROM opponents");
                    int rows = 0;
                    while (r.next()) {
                        sb[rows][0] = r.getString("NUME") + "      ";
                        sb[rows][1] = r.getString("ANTRENOR");
                        rows++;
                    }


                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
                Tables table = new Tables(null, sb);
                table.setVisible(true);
            }
        });
        LocationBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] sb = null;
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);
                    Connection connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_MENIU, ConfigurationSetings.USERNAME_MENIU, ConfigurationSetings.PASSWORD_MENIU);
                    Statement stn = connection.createStatement();
                    sb = new String[30][10];
                    ResultSet r = stn.executeQuery("SELECT * FROM location");
                    int rows = 0;
                    while (r.next()) {
                        sb[rows][0] = r.getString("NUME") + "       ";
                        sb[rows][1] = r.getString("LOCATIE") + "      ";
                        sb[rows][2] = r.getString("ECHIPA_CARE_JOACA");
                        rows++;

                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
                Tables table = new Tables(null, sb);
                table.setVisible(true);
            }
        });
        RefereesBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] sb = null;
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);
                    Connection connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_MENIU, ConfigurationSetings.USERNAME_MENIU, ConfigurationSetings.PASSWORD_MENIU);
                    Statement stn = connection.createStatement();
                    sb = new String[30][10];
                    ResultSet r = stn.executeQuery("SELECT * FROM referees");
                    int rows = 0;
                    while (r.next()) {
                        sb[rows][0] = r.getString("NUME") + "      ";
                        sb[rows][1] = r.getString("COMPETITIE");
                        rows++;

                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
                Tables table = new Tables(null, sb);
                table.setVisible(true);
            }
        });
        GamesBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] sb = null;
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);
                    Connection connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_MENIU, ConfigurationSetings.USERNAME_MENIU, ConfigurationSetings.PASSWORD_MENIU);
                    Statement stn = connection.createStatement();
                    sb = new String[30][10];
                    ResultSet r = stn.executeQuery("SELECT * FROM games");
                    int rows = 0;
                    while (r.next()) {
                        sb[rows][0] = r.getString("MECI") + "      ";
                        sb[rows][1] = r.getString("COMPETITIE") + "       ";
                        sb[rows][2] = r.getString("DATA");
                        rows++;

                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
                Tables table = new Tables(null, sb);
                table.setVisible(true);
            }
        });
        JuniorBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] sb = null;
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);
                    Connection connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_MENIU, ConfigurationSetings.USERNAME_MENIU, ConfigurationSetings.PASSWORD_MENIU);
                    Statement stn = connection.createStatement();
                    sb = new String[30][10];
                    ResultSet r = stn.executeQuery("SELECT * FROM junior");
                    int rows = 0;
                    while (r.next()) {
                        sb[rows][0] = r.getString("NUME") + "      ";
                        sb[rows][1] = r.getString("AGE");
                        rows++;

                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
                Tables table = new Tables(null, sb);
                table.setVisible(true);
            }
        });

        Insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(NUME.getText().equals("") || TRICOU.getText().equals("") || POZITIE.getText().equals(""))) {

                    try {
                        Class.forName(ConfigurationSetings.DRIVER_MENU);
                        Connection connection = null;
                        try {
                            connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_MENIU, ConfigurationSetings.USERNAME_MENIU, ConfigurationSetings.PASSWORD_MENIU);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        Statement stn = connection.createStatement();
                        stn.execute("INSERT INTO squad VALUES(default, '" + NUME.getText() + "', " + TRICOU.getText() + ", '" + POZITIE.getText() + "') ");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

        });
        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!NUME.getText().equals("")) {
                    try {
                        Class.forName(ConfigurationSetings.DRIVER_MENU);
                        Connection connection = null;
                        try {
                            connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_MENIU, ConfigurationSetings.USERNAME_MENIU, ConfigurationSetings.PASSWORD_MENIU);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        Statement stn = connection.createStatement();
                        stn.execute("DELETE FROM squad WHERE nume='" + NUME.getText() + "' ");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        uploadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName(ConfigurationSetings.DRIVER_MENU);
                    Connection connection = null;
                    try {
                        connection = DriverManager.getConnection(ConfigurationSetings.DB_URL_MENIU, ConfigurationSetings.USERNAME_MENIU, ConfigurationSetings.PASSWORD_MENIU);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    Statement stn = connection.createStatement();
                    stn.execute("UPDATE games SET data = '" + NUME.getText() + "' WHERE meci ='" + TRICOU.getText() + "'  ");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
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
}