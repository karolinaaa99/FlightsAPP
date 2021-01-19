package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ErrorReservationWindow
{
    public ErrorReservationWindow()
    {
        error_reservation_window.Set();
        error_reservation_window.layout_grid.setAlignment(Pos.CENTER);
        error_reservation_window.layout_grid.add(infoText, 0, 0);
        error_reservation_window.layout_grid.add(imageView, 0, 1);
        error_reservation_window.layout_grid.add(backButton, 0, 2);

        react();
    }

    Window error_reservation_window = new Window(1, 800, 600, 5, 5, "Brak rezerwacji");

    //label
    Label infoText = new Label("Nie masz jeszcze zadnych rezerwacji!");

    //button
    Button backButton = new Button("Wroc do panelu uzytkownika");

    //utworzenie obiektu typu Image - do pobrania obrazka
    Image image = new Image("smutnaBuzka.jpg");

    //utworzenie obiektu typu ImageView - do wyswietlenia obrazka
    ImageView imageView = new ImageView(image);

    //react() - reakcja na przycisk
    public void react()
    {
        backButton.setOnAction(e -> {
            //powrot do panelu uzytkownika
            Main.userPanel = new UserPanel();
            Main.userPanel.show();
        });
    }

    public void show()
    {
        Main.stage.setScene(error_reservation_window.scene);
        Main.stage.setTitle("Brak rezerwacji");
        Main.stage.show();
    }
}
