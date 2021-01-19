package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LogOutWindow
{
    public LogOutWindow()
    {
        log_out_window.Set();
        log_out_window.layout_grid.setAlignment(Pos.CENTER);
        log_out_window.layout_grid.add(infoText, 0, 0);
        log_out_window.layout_grid.add(imageView, 0, 1);
    }

    Window log_out_window = new Window(1, 800, 600, 5, 5, "Wylogowanie");

    //label
    Label infoText = new Label("Dziekujemy za skorzystanie z naszej aplikacji! :-)");

    //utworzenie obiektu typu Image - do pobrania obrazka
    Image image = new Image("dziekujemy.jpg");

    //utworzenie obiektu typu ImageView - do wyswietlenia obrazka
    ImageView imageView = new ImageView(image);

    //zmiana wielkosci obrazu z zachowaniem proporcji
    //imageView.setFitWidth(200);
    //imageView.setPreserveRatio(true);

    public void show()
    {
        Main.stage.setScene(log_out_window.scene);
        Main.stage.setTitle("Wylogowanie");
        Main.stage.show();
    }
}
