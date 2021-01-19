package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UserDataWindow
{
    public UserDataWindow()
    {
        getData();

        user_data_window.Set();
        user_data_window.layout_grid.setAlignment(Pos.CENTER);
        user_data_window.layout_grid.add(name_Label, 0, 0);
        user_data_window.layout_grid.add(name_Label_content, 1, 0);
        user_data_window.layout_grid.add(surname_Label, 0, 1);
        user_data_window.layout_grid.add(surname_Label_content, 1, 1);
        user_data_window.layout_grid.add(pesel_Label, 0, 2);
        user_data_window.layout_grid.add(pesel_Label_content, 1, 2);
        user_data_window.layout_grid.add(phoneNumber_Label, 0, 3);
        user_data_window.layout_grid.add(phoneNumber_Label_content, 1, 3);
        user_data_window.layout_grid.add(mail_Label_, 0, 4);
        user_data_window.layout_grid.add(mail_Label_content, 1 ,4);
        user_data_window.layout_grid.add(addres_Label_, 0, 5);
        user_data_window.layout_grid.add(addres_Label_content, 1, 5);
        user_data_window.layout_grid.add(backButton, 1, 6);

        back();
    }

    Window user_data_window = new Window(1, 800, 600, 5, 5, "Moje dane");

    //zeby wiedziec kto jest zalogowany
    private String username;
    private String password;

    //Labels
    Label name_Label = new Label("Imie");
    Label surname_Label = new Label("Nazwisko");
    Label pesel_Label = new Label("Pesel");
    Label phoneNumber_Label = new Label("Telefon");
    Label mail_Label_ = new Label("Mail");
    Label addres_Label_ = new Label("Adres");

    Label name_Label_content;
    Label surname_Label_content;
    Label pesel_Label_content;
    Label phoneNumber_Label_content;
    Label mail_Label_content;
    Label addres_Label_content;

    //button
    Button backButton = new Button("Wroc do panelu uzytkownika");

    //metoda do pobrania danych z bazy z kolekcji Pasazer
    //musze wiedziec, jaki uzytkownik jest zalogowany (username, password)
    public void getData()
    {
        username = LoginWindow.getUsername();
        password = LoginWindow.getPassword();

        name_Label_content = new Label(MyDatabase.getName(username, password));
        surname_Label_content = new Label(MyDatabase.getSurname(username, password));
        pesel_Label_content = new Label(MyDatabase.getPesel(username, password));
        phoneNumber_Label_content = new Label(MyDatabase.getPhoneNumber(username, password));
        mail_Label_content = new Label(MyDatabase.getMail(username, password));
        addres_Label_content = new Label(MyDatabase.getAddres(username, password));
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
        Main.stage.setScene(user_data_window.scene);
        Main.stage.setTitle("Moje dane");
        Main.stage.show();
    }
}
