public class Company {
    private String Name;
    private String Date;
    private String Bulstat;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getBulstat() {
        return Bulstat;
    }

    public void setBulstat(String bulstat) {
        if (bulstat.length() != 10) {
            System.out.println("The bulstat has to be 10 symbols long!");
        } else {
            this.Bulstat = bulstat;
        }
    }
}
