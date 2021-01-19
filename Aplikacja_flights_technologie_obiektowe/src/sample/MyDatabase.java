package sample;

import java.util.Random;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MyDatabase
{
    //make a connection
    private static final MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

    //access a database
    private static final MongoDatabase database = mongoClient.getDatabase("FlightsApp");

    /**public static String imie;
    public static String nazwisko;
    public static String pesel;
    public static String telefon;
    public static String mail;
    public static String adres;**/

    //metoda do rejestracji pasazera/uzytkownika aplikacji
    public static int insertPassenger(String username, String password, String name, String surname, String pesel, String phoneNumber, String mail, String addres)
    {
        //get a collection from database
        MongoCollection<Document> collection = database.getCollection("Pasazer");

        System.out.println("Collection selected successfully");

        Document document = new Document()
                .append("nazwaUzytkownika", username)
                .append("haslo", password)
                .append("imie", name)
                .append("nazwisko", surname)
                .append("pesel", pesel)
                .append("numerTelefonu", phoneNumber)
                .append("mail", mail)
                .append("adres", addres)
                .append("index", collection.count() + 1);

        collection.insertOne(document);

        System.out.println("Dodano nowego pasazera!");

        return 1;
    }

    //metoda do logowania pasazera/uzytkownika aplikacji
    public static long checkPassenger(String username, String password)
    {
        MongoCollection<Document> collection2 = database.getCollection("Pasazer");

        FindIterable<Document> iterDoc = collection2.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getLong("index");
            }
        }

        return  (long) -1;
    }

    //metoda zwracajaca imie zalogowanego uzytkownika
    public static String getName(String username, String password)
    {
        MongoCollection<Document> collection3 = database.getCollection("Pasazer");

        FindIterable<Document> iterDoc = collection3.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("imie");
            }
        }
        return "";
    }

    //metoda zwracajaca nazwisko zalogowanego uzytkownika
    public static String getSurname(String username, String password)
    {
        MongoCollection<Document> collection4 = database.getCollection("Pasazer");

        FindIterable<Document> iterDoc = collection4.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("nazwisko");
            }
        }
        return "";
    }

    //metoda zwracajaca pesel zalogowanego uzytkownika
    public static String getPesel(String username, String password)
    {
        MongoCollection<Document> collection5 = database.getCollection("Pasazer");

        FindIterable<Document> iterDoc = collection5.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("pesel");
            }
        }
        return "";
    }

    //metoda zwracajaca numer telefonu zalogowanego uzytkownika
    public static String getPhoneNumber(String username, String password)
    {
        MongoCollection<Document> collection6 = database.getCollection("Pasazer");

        FindIterable<Document> iterDoc = collection6.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("numerTelefonu");
            }
        }
        return "";
    }

    //metoda zwracajaca maila zalogowanego uzytkownika
    public static String getMail(String username, String password)
    {
        MongoCollection<Document> collection7 = database.getCollection("Pasazer");

        FindIterable<Document> iterDoc = collection7.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("mail");
            }
        }
        return "";
    }

    //metoda zwracajaca adres zalogowanego uzytkownika
    public static String getAddres(String username, String password)
    {
        MongoCollection<Document> collection8 = database.getCollection("Pasazer");

        FindIterable<Document> iterDoc = collection8.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("adres");
            }
        }
        return "";
    }

    //metoda do zarezerwowania lotu
    public static int insertReservation(String seatNumber, String luggage, String dataWylotu, String dataPrzylotu, String miejsceWylotu, String miejscePrzylotu)
    {
        //get a collection from database
        MongoCollection<Document> collectionRezerwacja = database.getCollection("Rezerwacja");
        MongoCollection<Document> collectionLot = database.getCollection("Lot");
        MongoCollection<Document> collectionSamolot = database.getCollection("Samolot");

        System.out.println("Collections selected successfully");

        Random randomNumbers = new Random();

        int producent = randomNumbers.nextInt(2) + 1;
        String statusRezerwacji = "w trakcie realizacji";
        String producentSamolotu;
        String typSamolotu = "pasazerski";
        int liczbaMiejscSamolotu = randomNumbers.nextInt(200) + 100;

        if (producent == 1)
        {
            producentSamolotu = "Airbus";
        }
        else
        {
            producentSamolotu = "Boeing";
        }

        //uzupelniam kolekcje Rezerwacja
        Document documentRezerwacja = new Document()
                .append("nazwaUzytkownika", LoginWindow.getUsername())
                .append("haslo", LoginWindow.getPassword())
                .append("numerSiedzenia", seatNumber)
                .append("bagaz", luggage)
                .append("statusRezerwacji", statusRezerwacji)
                .append("index", collectionRezerwacja.count() + 1);

        collectionRezerwacja.insertOne(documentRezerwacja);

        //uzupelniam kolekcje Samolot
        Document documentSamolot = new Document()
                .append("nazwaUzytkownika", LoginWindow.getUsername())
                .append("haslo", LoginWindow.getPassword())
                .append("producent", producentSamolotu)
                .append("typ", typSamolotu)
                .append("liczbaMiejsc", Integer.toString(liczbaMiejscSamolotu))
                .append("index", collectionSamolot.count() + 1);

        collectionSamolot.insertOne(documentSamolot);

        //uzupelniam kolekcje Lot
        Document documentLot = new Document()
                .append("nazwaUzytkownika", LoginWindow.getUsername())
                .append("haslo", LoginWindow.getPassword())
                .append("dataWylotu", dataWylotu)
                .append("dataPrzylotu", dataPrzylotu)
                .append("miejsceWylotu", miejsceWylotu)
                .append("miejscePrzylotu", miejscePrzylotu)
                .append("index", collectionLot.count() + 1);

        collectionLot.insertOne(documentLot);

        System.out.println("Dodano nowa rezerwacje lotu!!");

        return 1;
    }

    //metoda zwracajaca numer siedzenia w samolocie
    public static String getSeatNumber(String username, String password)
    {
        MongoCollection<Document> collection9 = database.getCollection("Rezerwacja");

        FindIterable<Document> iterDoc = collection9.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("numerSiedzenia");
            }
        }
        return "";
    }

    //metoda zwracajaca rodzaj bagazu
    public static String getLuggage(String username, String password)
    {
        MongoCollection<Document> collection10 = database.getCollection("Rezerwacja");

        FindIterable<Document> iterDoc = collection10.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("bagaz");
            }
        }
        return "";
    }

    //metoda zwracajaca date wylotu
    public static String getDataWylotu(String username, String password)
    {
        MongoCollection<Document> collection11 = database.getCollection("Lot");

        FindIterable<Document> iterDoc = collection11.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("dataWylotu");
            }
        }
        return "";
    }

    //metoda zwracajaca date przylotu
    public static String getDataPrzylotu(String username, String password)
    {
        MongoCollection<Document> collection12 = database.getCollection("Lot");

        FindIterable<Document> iterDoc = collection12.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("dataPrzylotu");
            }
        }
        return "";
    }

    //metoda zwracajaca miejsce wylotu
    public static String getMiejsceWylotu(String username, String password)
    {
        MongoCollection<Document> collection13 = database.getCollection("Lot");

        FindIterable<Document> iterDoc = collection13.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("miejsceWylotu");
            }
        }
        return "";
    }

    //metoda zwracajaca miejsce przylotu
    public static String getMiejscePrzylotu(String username, String password)
    {
        MongoCollection<Document> collection14 = database.getCollection("Lot");

        FindIterable<Document> iterDoc = collection14.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("miejscePrzylotu");
            }
        }
        return "";
    }

    //metoda zwracajaca producenta samolotu
    public static String getProducentSamolotu(String username, String password)
    {
        MongoCollection<Document> collection15 = database.getCollection("Samolot");

        FindIterable<Document> iterDoc = collection15.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("producent");
            }
        }
        return "";
    }

    //metoda zwracajaca typ samolotu
    public static String getTypSamolotu(String username, String password)
    {
        MongoCollection<Document> collection16 = database.getCollection("Samolot");

        FindIterable<Document> iterDoc = collection16.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("typ");
            }
        }
        return "";
    }

    //metoda zwracajaca liczbe miejsc w samolocie
    public static String getLiczbaMiejsc(String username, String password)
    {
        MongoCollection<Document> collection17 = database.getCollection("Samolot");

        FindIterable<Document> iterDoc = collection17.find();

        for (Document x : iterDoc)
        {
            if (x.getString("nazwaUzytkownika").equals(username) && x.getString("haslo").equals(password))
            {
                return x.getString("liczbaMiejsc");
            }
        }
        return "";
    }
}
