package sample;

public class Pasazer
{
    private String nazwaUzytkownika;
    private String haslo;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String telefon;
    private String mail;
    private String adres;

    //konstruktor
    public Pasazer(String nazwaUzytkownika, String haslo, String imie, String nazwisko, String pesel, String telefon, String mail, String adres)
    {
        this.nazwaUzytkownika = nazwaUzytkownika;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.telefon = telefon;
        this.mail = mail;
        this.adres = adres;
    }

    //setters and getters

    public void setNazwaUzytkownika(String nazwaUzytkownika)
    {
        this.nazwaUzytkownika = nazwaUzytkownika;
    }

    public String getNazwaUzytkownika()
    {
        return nazwaUzytkownika;
    }

    public void setHaslo(String haslo)
    {
        this.haslo = haslo;
    }

    public String getHaslo()
    {
        return haslo;
    }

    public void setImie(String imie)
    {
        this.imie = imie;
    }

    public String getImie()
    {
        return imie;
    }

    public void setNazwisko(String nazwisko)
    {
        this.nazwisko = nazwisko;
    }

    public String getNazwisko()
    {
        return nazwisko;
    }

    public void setPesel(String pesel)
    {
        this.pesel = pesel;
    }

    public String getPesel()
    {
        return pesel;
    }

    public void setTelefon(String telefon)
    {
        this.telefon = telefon;
    }

    public String getTelefon()
    {
        return telefon;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getMail()
    {
        return mail;
    }

    public void setAdres(String adres)
    {
        this.adres = adres;
    }

    public String getAdres()
    {
        return adres;
    }

    //przeslonienie metody toString()
    @Override
    public String toString()
    {
        return "Pasażer{" +
                "nazwaUzytkownika='" + nazwaUzytkownika + '\'' +
                ", haslo='" + haslo + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", telefon='" + telefon + '\'' +
                ", mail='" + mail + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
