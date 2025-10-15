
public class Company_IT extends Company {
    String FounderName;
    Double StartingFund;
    Double RealFund;

    public String getFounderName(String name) {
        return setFounderName(name);
    }

    public String setFounderName(String name) {
        return this.FounderName = name;
    }

    public double getStartingFund(Double startingFund) {
        return setStartingFund(startingFund);
    }

    public double setStartingFund(Double startingFund) {
        return this.StartingFund = startingFund;
    }

    public double getRealFund(Double realFund) {
        return setRealFund(realFund);
    }

    public double setRealFund(Double realFund) {
        return this.RealFund = realFund;
    }

    public double todayFund() {
        return Math.abs(StartingFund - RealFund);
    }
}
