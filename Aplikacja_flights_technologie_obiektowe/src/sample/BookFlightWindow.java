package sample;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

public class BookFlightWindow
{
    public BookFlightWindow()
    {
        book_flight_window.Set();
        book_flight_window.layout_grid.setAlignment(Pos.CENTER);
        book_flight_window.layout_grid.add(seatNumber_text, 0, 0);
        book_flight_window.layout_grid.add(seatNumberField, 1 ,0);
        book_flight_window.layout_grid.add(luggage_text, 0, 1);
        book_flight_window.layout_grid.add(checkBoxVBoxLuggage, 1, 1);
        book_flight_window.layout_grid.add(dataFlightIn_text, 0, 2);
        book_flight_window.layout_grid.add(checkBoxVBoxData, 1, 2);
        book_flight_window.layout_grid.add(placeFlightIn_text, 0, 3);
        book_flight_window.layout_grid.add(checkBoxVBoxMiejsce, 1, 3);
        book_flight_window.layout_grid.add(backButton, 0, 4);
        book_flight_window.layout_grid.add(bookButton, 1, 4);

        reserve();
    }

    Window book_flight_window = new Window(1, 800, 600, 5, 5, "Rezerwacja lotu");

    String rodzajBagazu;
    String dataWylotu;
    String dataPrzylotu;
    String miejsceWylotu;
    String miejscePrzylotu;


    //labels
    Label seatNumber_text = new Label("Numer siedzenia");
    Label luggage_text = new Label("Rodzaj bagazu");
    Label dataFlightIn_text = new Label("Data i godzina wylotu / przylotu");
    Label placeFlightIn_text = new Label("Miejsce wylotu - przylotu");

    //checkboxes
    CheckBox smallCheckBox = new CheckBox("maly (0 - 5 kg)");
    CheckBox averageCheckBox = new CheckBox("sredni (5 - 10 kg)");
    CheckBox bigCheckBox = new CheckBox("duzy (10 - 15 kg)");

    CheckBox data1 = new CheckBox("12-02-2021 15:00 / 12-02-2021 18:00");
    CheckBox data2 = new CheckBox("02-03-2021 6:00 / 02-03-2021 11:15");
    CheckBox data3 = new CheckBox("16-04-2021 23:30 / 17-04-2021 04:20");

    CheckBox miejsce1 = new CheckBox("Krakow - Londyn");
    CheckBox miejsce2 = new CheckBox("Warszawa - Dubaj");
    CheckBox miejsce3 = new CheckBox("Gdansk - Rzym");

    //dodanie kontrolek typu CheckBox do kontenera typu VBox
    VBox checkBoxVBoxLuggage = new VBox(10, smallCheckBox, averageCheckBox, bigCheckBox);

    VBox checkBoxVBoxData = new VBox(10, data1, data2, data3);

    VBox checkBoxVBoxMiejsce = new VBox(10, miejsce1, miejsce2, miejsce3);

    //textfield
    TextField seatNumberField = new TextField();

    //buttons
    Button bookButton = new Button("Zarezerwuj lot");
    Button backButton = new Button("Wroc do panelu uzytkownika");

    //reserve() - reakcja na przycisk
    public void reserve()
    {
        bookButton.setOnAction(e -> {
            //wyslanie danych do serwera i otwarcie UserPanel

            if (smallCheckBox.isSelected())
            {
                rodzajBagazu = "maly (0 - 5 kg)";
            }
            else if (averageCheckBox.isSelected())
            {
                rodzajBagazu = "sredni (5 - 10 kg)";
            }
            else if (bigCheckBox.isSelected())
            {
                rodzajBagazu = "duzy (10 - 15 kg)";
            }

            if (data1.isSelected())
            {
                dataWylotu = "12-02-2021 15:00";
                dataPrzylotu = "12-02-2021 18:00";
            }
            else if (data2.isSelected())
            {
                dataWylotu = "02-03-2021 6:00";
                dataPrzylotu = "02-03-2021 11:15";
            }
            else if (data3.isSelected())
            {
                dataWylotu = "16-04-2021 23:30";
                dataPrzylotu = "17-04-2021 04:20";
            }

            if (miejsce1.isSelected())
            {
                miejsceWylotu = "Krakow";
                miejscePrzylotu = "Londyn";
            }
            else if (miejsce2.isSelected())
            {
                miejsceWylotu = "Warszawa";
                miejscePrzylotu = "Dubaj";
            }
            else if (miejsce3.isSelected())
            {
                miejsceWylotu = "Gdansk";
                miejscePrzylotu = "Rzym";
            }

            int liczba2 = MyDatabase.insertReservation(seatNumberField.getText(), rodzajBagazu, dataWylotu, dataPrzylotu, miejsceWylotu, miejscePrzylotu);

            if (liczba2 == 1)
            {
                Platform.runLater( () -> {
                    Main.userPanel = new UserPanel();
                    Main.userPanel.show();
                });
            }
            else
            {
                Platform.runLater( () -> {
                    Main.notDoReservation = new NotDoReservation();
                    Main.notDoReservation.show();
                });
            }
        });

        backButton.setOnAction(e -> {
            //powrot do panelu uzytkownika
            Main.userPanel = new UserPanel();
            Main.userPanel.show();
        });
    }

    public void show()
    {
        Main.stage.setScene(book_flight_window.scene);
        Main.stage.setTitle("Rezerwacja lotu");
        Main.stage.show();
    }
}
