import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JDialog {
    private JPanel loginPanel;
    private JTextField TFEmail;
    private JPasswordField PFPassword;
    private JButton BTNOK;
    private JButton BTNCancel;
    private User user;

    public LoginForm(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        BTNOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = TFEmail.getText();
                String password = String.valueOf(PFPassword.getPassword());

                user = loginUser(email, password);

                if (user != null) {
                    dispose();
                    HomePage preamierLeague = new HomePage(null);
                    preamierLeague.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            Messages.Invalid_Credention_Message,
                            Messages.Invalid_Credention_Title,
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        BTNCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
        setVisible(true);
    }

    private User loginUser(String email, String password) {
        User user = null;

        try {
            Connection conn = DriverManager.getConnection(ConfigurationSetings.DB_URL_LOGIN,
                    ConfigurationSetings.USERNAME_LOGIN,
                    ConfigurationSetings.PASSWORD_LOGIN);

            PreparedStatement preparedStatement = conn.prepareStatement(ConfigurationSetings.SQL_LOGIN);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("address");
                user.password = resultSet.getString("password");
            }

            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;

    }

    public User getUser() {
        return user;
    }
}
