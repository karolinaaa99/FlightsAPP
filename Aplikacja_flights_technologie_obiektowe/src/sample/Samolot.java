package sample;

public class Samolot
{
    private String producent;
    private String typ;
    private int liczbaMiejsc;

    //konstruktor
    public Samolot(String producent, String typ, int liczbaMiejsc)
    {
        this.producent = producent;
        this.typ = typ;
        this.liczbaMiejsc = liczbaMiejsc;
    }

    //setters and getters

    public void setProducent(String producent)
    {
        this.producent = producent;
    }

    public String getProducent()
    {
        return producent;
    }

    public void setTyp(String typ)
    {
        this.typ = typ;
    }

    public String getTyp()
    {
        return typ;
    }

    public void setLiczbaMiejsc(int liczbaMiejsc)
    {
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public int getLiczbaMiejsc()
    {
        return liczbaMiejsc;
    }

    //przeslonienie metody toString()
    @Override
    public String toString()
    {
        return "Samolot{" +
                "producent='" + producent + '\'' +
                ", typ='" + typ + '\'' +
                ", liczbaMiejsc=" + liczbaMiejsc +
                '}';
    }
}
