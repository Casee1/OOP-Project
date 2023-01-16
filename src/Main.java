public class Main {
    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.getUser();

        if (user != null) {
            System.out.println("Successful Authentification of: " + user.name);
            System.out.println("          Phone: " + user.phone);
            System.out.println("          Address: " + user.address);
        } else {
            System.out.println("Authentification canceled");
        }
    }
}
