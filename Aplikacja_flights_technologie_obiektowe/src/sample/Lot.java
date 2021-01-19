package sample;

public class Lot
{
    private String dataWylotu;
    private String dataPrzylotu;
    private String miejsceWylotu;
    private String miejscePrzylotu;
    private Samolot samolot;

    //konstruktor
    public Lot(String  dataWylotu, String dataPrzylotu, String miejsceWylotu, String miejscePrzylotu, Samolot samolot)
    {
        this.dataWylotu = dataWylotu;
        this.dataPrzylotu = dataPrzylotu;
        this.miejsceWylotu = miejsceWylotu;
        this.miejscePrzylotu = miejscePrzylotu;
        this.samolot = samolot;
    }

    //setters and getters

    public void setDataWylotu(String dataWylotu)
    {
        this.dataWylotu = dataWylotu;
    }

    public String getDataWylotu()
    {
        return dataWylotu;
    }

    public void setDataPrzylotu(String dataPrzylotu)
    {
        this.dataPrzylotu = dataPrzylotu;
    }

    public String getDataPrzylotu()
    {
        return dataPrzylotu;
    }

    public void setMiejsceWylotu(String miejsceWylotu)
    {
        this.miejsceWylotu = miejsceWylotu;
    }

    public String getMiejsceWylotu()
    {
        return miejsceWylotu;
    }

    public void setMiejscePrzylotu(String miejscePrzylotu)
    {
        this.miejscePrzylotu = miejscePrzylotu;
    }

    public String getMiejscePrzylotu()
    {
        return miejscePrzylotu;
    }

    public void setSamolot(Samolot samolot)
    {
        this.samolot = samolot;
    }

    public Samolot getSamolot()
    {
        return samolot;
    }

    //przeslonienie metody toString()
    @Override
    public String toString()
    {
        return "Lot{" +
                "dataWylotu='" + dataWylotu + '\'' +
                ", dataPrzylotu='" + dataPrzylotu + '\'' +
                ", miejsceWylotu='" + miejsceWylotu + '\'' +
                ", miejscePrzylotu='" + miejscePrzylotu + '\'' +
                ", samolot=" + samolot +
                '}';
    }
}
