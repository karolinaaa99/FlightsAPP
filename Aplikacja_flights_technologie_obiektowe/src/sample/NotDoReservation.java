package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NotDoReservation
{
    public NotDoReservation()
    {
        not_do_reservation.Set();
        not_do_reservation.layout_grid.setAlignment(Pos.CENTER);
        not_do_reservation.layout_grid.add(infoText, 0, 0);
        not_do_reservation.layout_grid.add(imageView, 0, 1);
        not_do_reservation.layout_grid.add(backButton, 1, 2);

        react();
    }

    Window not_do_reservation = new Window(1, 800, 600, 5, 5, "Blad rezerwacji");

    //label
    Label infoText = new Label("Nie udalo sie zrealizowac rezerwacji");

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
        Main.stage.setScene(not_do_reservation.scene);
        Main.stage.setTitle("Brak rezerwacji");
        Main.stage.show();
    }
}
