package sample;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ReservationWindow
{
    public ReservationWindow()
    {
        getData();

        reservation_window.Set();
        reservation_window.layout_grid.setAlignment(Pos.CENTER);
        reservation_window.layout_grid.add(seatNumber_Label, 0, 0);
        reservation_window.layout_grid.add(seatNumber_Label_content, 1, 0);
        reservation_window.layout_grid.add(luggage_Label, 0, 1);
        reservation_window.layout_grid.add(luggage_Label_content, 1, 1);
        reservation_window.layout_grid.add(dataFlightIn_Label, 0, 2);
        reservation_window.layout_grid.add(dataFlightIn_Label_content, 1, 2);
        reservation_window.layout_grid.add(dataFlightOut_Label, 0, 3);
        reservation_window.layout_grid.add(dataFlightOut_Label_content, 1, 3);
        reservation_window.layout_grid.add(placeFlightIn_Label, 0, 4);
        reservation_window.layout_grid.add(placeFlightIn_Label_content, 1, 4);
        reservation_window.layout_grid.add(placeFlightOut_Label, 0, 5);
        reservation_window.layout_grid.add(placeFlightOut_Label_content, 1, 5);
        reservation_window.layout_grid.add(producentAirplane_Label, 0, 6);
        reservation_window.layout_grid.add(producentAirplane_Label_content, 1, 6);
        reservation_window.layout_grid.add(typeAirplane_Label, 0, 7);
        reservation_window.layout_grid.add(typeAirplane_Label_content, 1 ,7);
        reservation_window.layout_grid.add(quantitySeatsAirplane_Label, 0, 8);
        reservation_window.layout_grid.add(quantitySeatsAirplane_Label_content, 1, 8);
        reservation_window.layout_grid.add(backButton, 1, 9);

        back();
    }

    Window reservation_window = new Window(1, 800, 600, 5, 5, "Moje rezerwacje");

    //zeby wiedziec kto jest zalogowany
    private String username;
    private String password;

    //Labels
    Label seatNumber_Label = new Label("Numer siedzenia");
    Label luggage_Label = new Label("Rodzaj bagazu");
    Label dataFlightIn_Label =  new Label("Data i godzina wylotu");
    Label dataFlightOut_Label = new Label("Data i godzina przylotu");
    Label placeFlightIn_Label = new Label("Miejsce wylotu");
    Label placeFlightOut_Label = new Label("Miejsce przylotu");
    Label producentAirplane_Label = new Label("Producent samolotu");
    Label typeAirplane_Label = new Label("Typ samolotu");
    Label quantitySeatsAirplane_Label = new Label("Liczba miejsc w samolocie:");

    Label seatNumber_Label_content;
    Label luggage_Label_content;
    Label dataFlightIn_Label_content;
    Label dataFlightOut_Label_content;
    Label placeFlightIn_Label_content;
    Label placeFlightOut_Label_content;
    Label producentAirplane_Label_content;
    Label typeAirplane_Label_content;
    Label quantitySeatsAirplane_Label_content;

    //button
    Button backButton = new Button("Wroc do panelu uzytkownika");

    //metoda do pobrania danych z bazy z kolekcji Rezerwacja
    //musze wiedziec, jaki uzytkownik jest zalogowany (username, password)
    public void getData()
    {
        username = LoginWindow.getUsername();
        password = LoginWindow.getPassword();

        //i teraz trzeba pobrac dane z bazy
        //lub jesli nie było żadnej rezerwacji to otwarcie okienka z informacją.
        //numer siedzenia, ... itd

        if (MyDatabase.getSeatNumber(username, password).equals(""))
        {
            Platform.runLater( () -> {
                //brak rezerwacji
                Main.errorReservationWindow = new ErrorReservationWindow();
                Main.errorReservationWindow.show();
            });
        }

        seatNumber_Label_content = new Label(MyDatabase.getSeatNumber(username, password));
        luggage_Label_content = new Label(MyDatabase.getLuggage(username, password));
        dataFlightIn_Label_content =  new Label(MyDatabase.getDataWylotu(username, password));
        dataFlightOut_Label_content = new Label(MyDatabase.getDataPrzylotu(username, password));
        placeFlightIn_Label_content = new Label(MyDatabase.getMiejsceWylotu(username, password));
        placeFlightOut_Label_content = new Label(MyDatabase.getMiejscePrzylotu(username, password));
        producentAirplane_Label_content = new Label(MyDatabase.getProducentSamolotu(username, password));
        typeAirplane_Label_content = new Label(MyDatabase.getTypSamolotu(username, password));
        quantitySeatsAirplane_Label_content = new Label(MyDatabase.getLiczbaMiejsc(username, password));
    }

    //back() - reakcja na przycisk
    public void back()
    {
        backButton.setOnAction(e -> {
            //powrot do panelu uzytkownika
            Main.userPanel = new UserPanel();
            Main.userPanel.show();
        });
    }

    public void show()
    {
        Main.stage.setScene(reservation_window.scene);
        Main.stage.setTitle("Moje rezerwacje");
        Main.stage.show();
    }
}
