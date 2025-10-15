
public class Company {
    String Name;
    String Date;
    String Code;

    public String getName(String name) {
        return setName(name);
    }

    public String setName(String name) {
        return this.Name = name;
    }

    public String getDate(String date) {
        return setDate(date);
    }

    public String setDate(String date) {
        return this.Date = date;
    }

    public String getCode(String code) {
        return setCode(code);
    }

    public String setCode(String code) {
        if (code.length() != 10) {
            System.out.println("The bulstat has to be 10 symbols long!");
            return "";
        }
        return this.Code = code;
    }
}
