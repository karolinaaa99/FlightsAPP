package sample;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterWindow
{
    public RegisterWindow()
    {
        register_window.Set();
        register_window.layout_grid.setAlignment(Pos.CENTER);
        register_window.layout_grid.add(username_text, 0,0);
        register_window.layout_grid.add(usernameField, 1,0);
        register_window.layout_grid.add(password_text, 0, 1);
        register_window.layout_grid.add(passwordField, 1, 1);
        register_window.layout_grid.add(name_text, 0, 2);
        register_window.layout_grid.add(nameField, 1, 2);
        register_window.layout_grid.add(surname_text, 0, 3);
        register_window.layout_grid.add(surnameField, 1, 3);
        register_window.layout_grid.add(pesel_text, 0, 4);
        register_window.layout_grid.add(peselField, 1, 4);
        register_window.layout_grid.add(phoneNumber_text, 0, 5);
        register_window.layout_grid.add(phoneNumberField, 1, 5);
        register_window.layout_grid.add(mail_text, 0, 6);
        register_window.layout_grid.add(mailField, 1, 6);
        register_window.layout_grid.add(addres_text, 0, 7);
        register_window.layout_grid.add(addresField, 1, 7);
        register_window.layout_grid.add(registerButton, 1, 8);

        Sign_up();
    }

    Window register_window = new Window(1, 800, 600, 5, 5, "Rejestracja");

    //labels
    Label username_text = new Label("Nazwa uzytkownika");
    Label password_text = new Label("Haslo");
    Label name_text = new Label("Imie");
    Label surname_text = new Label("Nazwisko");
    Label pesel_text = new Label("Pesel");
    Label phoneNumber_text = new Label("Telefon");
    Label mail_text = new Label("Mail");
    Label addres_text = new Label("Adres");

    //textfields and passwordfields
    TextField usernameField = new TextField();
    PasswordField passwordField = new PasswordField();
    TextField nameField = new TextField();
    TextField surnameField = new TextField();
    TextField peselField = new TextField();
    TextField phoneNumberField = new TextField();
    TextField mailField = new TextField();
    TextField addresField = new TextField();

    //button
    Button registerButton = new Button("Rejestracja");

    //sign up - rejestracja
    public void Sign_up ()
    {
        registerButton.setOnAction(e -> {
            //wyslanie danych do serwera i sprawdzenie ich poprawnosci
            //jezeli sa poprawne, to otwarcie LoginWindow
            //jezeli sa bledne (konto o podanych danych juz istnieje), to okienko z informacja

            int liczba = MyDatabase.insertPassenger(usernameField.getText(), passwordField.getText(), nameField.getText(), surnameField.getText(), peselField.getText(), phoneNumberField.getText(), mailField.getText(), addresField.getText());

            if(liczba == 1)
            {
                Platform.runLater( () -> {
                    //otwarcie LoginWindow
                    Main.loginWindow = new LoginWindow();
                    Main.loginWindow.show();
                });
            }
            else
            {
                Platform.runLater( () -> {
                    //konto o podanych danych juz istnieje
                    Main.errorRegisterWindow = new ErrorRegisterWindow();
                    Main.errorRegisterWindow.show();
                });
            }
        });
    }

    public void show()
    {
        Main.stage.setScene(register_window.scene);
        Main.stage.setTitle("Rejestracja");
        Main.stage.show();
    }
}
