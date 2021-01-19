package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ErrorLogInWindow
{
    public ErrorLogInWindow()
    {
        error_login_window.Set();
        error_login_window.layout_grid.setAlignment(Pos.CENTER);
        error_login_window.layout_grid.add(infoText, 0, 0);
        error_login_window.layout_grid.add(imageView, 0, 1);
    }

    Window error_login_window = new Window(1, 800, 600, 5, 5, "Blad logowania");

    //label
    Label infoText = new Label("Konto o podanych danych nie istnieje!");

    //utworzenie obiektu typu Image - do pobrania obrazka
    Image image = new Image("smutnaBuzka.jpg");

    //utworzenie obiektu typu ImageView - do wyswietlenia obrazka
    ImageView imageView = new ImageView(image);

    //zmiana wielkosci obrazu z zachowaniem proporcji
    //imageView.setFitWidth(200);
    //imageView.setPreserveRatio(true);

    public void show()
    {
        Main.stage.setScene(error_login_window.scene);
        Main.stage.setTitle("Blad logowania");
        Main.stage.show();
    }
}
