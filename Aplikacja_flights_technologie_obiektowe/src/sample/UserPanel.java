package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class UserPanel
{
    public UserPanel()
    {
        user_panel.Set();
        user_panel.layout_grid.setAlignment(Pos.CENTER);
        user_panel.layout_grid.add(bookFlightButton, 0, 0);
        user_panel.layout_grid.add(userDataButton, 0, 1);
        user_panel.layout_grid.add(userReservationsButton, 0, 2);
        user_panel.layout_grid.add(logOutButton, 0, 3);

        actionsOnButtons();
    }

    Window user_panel = new Window(1, 800, 600, 5, 5, "Panel uzytkownika");

    //buttons
    Button bookFlightButton = new Button("Zarezerwuj lot");
    Button userDataButton = new Button("Moje dane");
    Button userReservationsButton = new Button("Moje rezerwacje");
    Button logOutButton = new Button("Wyloguj");

    //actionsOnButtons - reagowanie na przyciski
    public void actionsOnButtons()
    {
        bookFlightButton.setOnAction(e -> {
            //otwarcie BookFlightWindow
            Main.bookFlightWindow = new BookFlightWindow();
            Main.bookFlightWindow.show();
        });

        userDataButton.setOnAction(e -> {
            //otwarcie UserDataWindow
            Main.userDataWindow = new UserDataWindow();
            Main.userDataWindow.show();
        });

        userReservationsButton.setOnAction(e -> {
            //otwarcie ReservationWindow
            Main.reservationWindow = new ReservationWindow();
            Main.reservationWindow.show();
        });

        logOutButton.setOnAction(e -> {
            //otwarcie LogOutWindow
            Main.logOutWindow = new LogOutWindow();
            Main.logOutWindow.show();
        });
    }

    public void show()
    {
        Main.stage.setScene(user_panel.scene);
        Main.stage.setTitle("Panel uzytkownika");
        Main.stage.show();
    }
}
