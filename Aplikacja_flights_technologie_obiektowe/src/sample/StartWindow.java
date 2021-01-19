package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StartWindow
{
    public StartWindow()
    {
        start_window.Set();
        start_window.layout_grid.setAlignment(Pos.CENTER);
        start_window.layout_grid.add(helloLabel, 0,0);
        start_window.layout_grid.add(haveAccountLabel, 0,1);
        start_window.layout_grid.add(logButton, 0,2);
        start_window.layout_grid.add(notHaveAccountLabel, 0,3);
        start_window.layout_grid.add(registerButton, 0,4);
        start_window.layout_grid.add(imageView, 0, 5);

        choice();
    }

    Window start_window = new Window(1, 800, 600, 5, 5, "Strona startowa");

    //labels and buttons
    Label helloLabel = new Label("Witaj w aplikacji wspomagajacej rezerwacje lotow!");
    Label haveAccountLabel = new Label("Masz juz konto? Zaloguj sie!");
    Button logButton = new Button("Logowanie");
    Label notHaveAccountLabel = new Label("Nie masz jeszcze konta? Zarejestruj sie!");
    Button registerButton = new Button("Rejestracja");

    //utworzenie obiektu typu Image - do pobrania obrazka
    Image image = new Image("samolot.jpg");

    //utworzenie obiektu typu ImageView - do wyswietlenia obrazka
    ImageView imageView = new ImageView(image);

    //zmiana wielkosci obrazu z zachowaniem proporcji
    //imageView.setFitWidth(200)
    //imageView.setPreserveRatio(true);

    public void choice()
    {
        logButton.setOnAction(e -> {
            //otwarcie LoginWindow
            Main.loginWindow = new LoginWindow();
            Main.loginWindow.show();
        });

        registerButton.setOnAction(e -> {
            //otwarcie RegisterWindow
            Main.registerWindow = new RegisterWindow();
            Main.registerWindow.show();
        });
    }

    public void show()
    {
        Main.stage.setScene(start_window.scene);
        Main.stage.setTitle("Strona startowa");
        Main.stage.show();
    }
}
