package sample;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginWindow
{
    public LoginWindow()
    {
        login_window.Set();
        login_window.layout_grid.setAlignment(Pos.CENTER);
        login_window.layout_grid.add(username_text, 0,0);
        login_window.layout_grid.add(usernameField, 1,0);
        login_window.layout_grid.add(password_text, 0,1);
        login_window.layout_grid.add(passwordField, 1,1);
        login_window.layout_grid.add(logButton, 1,2);

        Sign_in();
    }

    //zeby wiedziec jaki uzytkownik jest zalogowany
    private static String username;
    private static String password;
    private static long liczba;

    Window login_window = new Window(1, 800, 600, 5, 5, "Logowanie");

    //button
    Button logButton = new Button("Logowanie");

    //textfields and passwordfields
    TextField usernameField = new TextField();
    PasswordField passwordField = new PasswordField();

    //labels
    Label username_text = new Label("Nazwa uzytkownika");
    Label password_text = new Label("Haslo");

    //sign in - logowanie
    public void Sign_in ()
    {
        logButton.setOnAction(e -> {
            //wyslanie danych do serwera, sprawdzenie ich poprawnosci i otwarcie UserPanel
            //w przypadku poprawnych danych lub otwarcie okienka z informacje
            //o blednym logowaniu - podane konto nie istnieje

            username = usernameField.getText();
            password = passwordField.getText();

            liczba = MyDatabase.checkPassenger(usernameField.getText(), passwordField.getText());

            if (liczba != -1)
            {
                Platform.runLater( () -> {
                    //jesli zalogowano
                    Main.userPanel = new UserPanel();
                    Main.userPanel.show();
                });
            }
            else
            {
                Platform.runLater( () -> {
                    //jesli podane konto nie istnieje
                    Main.errorLogInWindow = new ErrorLogInWindow();
                    Main.errorLogInWindow.show();
                });
            }
        });
    }

    //zwraca nazwe zalogowanego uzytkownika
    public static String getUsername()
    {
        return username;
    }

    //zwraca haslo zalogowanego uzytkownika
    public static String getPassword()
    {
        return password;
    }

    //zwraca index zalogowanego uzytkownika
    public static String getUserIndex()
    {
        return Long.toString(liczba);
    }

    public void show()
    {
        Main.stage.setScene(login_window.scene);
        Main.stage.setTitle("Logowanie");
        Main.stage.show();
    }
}
