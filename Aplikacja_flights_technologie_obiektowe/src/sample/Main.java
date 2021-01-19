package sample;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
    //plotno
    public static Stage stage;

    //windows
    public static StartWindow startWindow;
    public static LoginWindow loginWindow;
    public static RegisterWindow registerWindow;
    public static UserPanel userPanel;
    public static BookFlightWindow bookFlightWindow;
    public static UserDataWindow userDataWindow;
    public static ReservationWindow reservationWindow;
    public static LogOutWindow logOutWindow;
    public static ErrorLogInWindow errorLogInWindow;
    public static ErrorRegisterWindow errorRegisterWindow;
    public static ErrorReservationWindow errorReservationWindow;
    public static NotDoReservation notDoReservation;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
       stage = primaryStage;

       startWindow = new StartWindow();
       startWindow.show();
    }


    public static void main(String[] args) throws Exception
    {
        //make a connection
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        //access a database
        MongoDatabase database = mongoClient.getDatabase("FlightsApp");

        launch(args);
    }
}