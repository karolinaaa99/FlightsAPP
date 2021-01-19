package sample;

public class Rezerwacja
{
    private int numerSiedzenia;
    private String bagaz;
    private Pasazer pasazer;
    private Lot lot;
    private String statusRezerwacji;

    //konstruktor
    public Rezerwacja(int numerSiedzenia, String bagaz, Pasazer pasazer, Lot lot, String statusRezerwacji)
    {
        this.numerSiedzenia = numerSiedzenia;
        this.bagaz = bagaz;
        this.pasazer = pasazer;
        this.lot = lot;
        this.statusRezerwacji = statusRezerwacji;
    }

    //setters and getters

    public void setNumerSiedzenia(int numerSiedzenia)
    {
        this.numerSiedzenia = numerSiedzenia;
    }

    public int getNumerSiedzenia()
    {
        return numerSiedzenia;
    }

    public void setBagaz(String bagaz)
    {
        this.bagaz = bagaz;
    }

    public String getBagaz()
    {
        return bagaz;
    }

    public void setPasazer(Pasazer pasazer)
    {
        this.pasazer = pasazer;
    }

    public Pasazer getPasażer()
    {
        return pasazer;
    }

    public void setLot(Lot lot)
    {
        this.lot = lot;
    }

    public Lot getLot()
    {
        return lot;
    }

    public void setStatusRezerwacji(String statusRezerwacji)
    {
        this.statusRezerwacji = statusRezerwacji;
    }

    public String getStatusRezerwacji()
    {
        return statusRezerwacji;
    }

    //przeslonienie metody toString()
    @Override
    public String toString()
    {
        return "Rezerwacja{" +
                "numerSiedzenia=" + numerSiedzenia +
                ", bagaz='" + bagaz + '\'' +
                ", pasażer=" + pasazer +
                ", lot=" + lot +
                ", statusRezerwacji='" + statusRezerwacji + '\'' +
                '}';
    }
}
