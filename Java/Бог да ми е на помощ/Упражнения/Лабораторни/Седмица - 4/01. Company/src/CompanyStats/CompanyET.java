public class CompanyET extends Company {
    private String FounderName;
    private double StartingFund;
    private double RealFund;

    public String getFounderName() {
        return FounderName;
    }

    public void setFounderName(String name) {
        this.FounderName = name;
    }

    public double getStartingFund() {
        return StartingFund;
    }

    public void setStartingFund(double startingFund) {
        this.StartingFund = startingFund;
    }

    public double getRealFund() {
        return RealFund;
    }

    public void setRealFund(double realFund) {
        this.RealFund = realFund;
    }

    public double todayFund() {
        return RealFund - StartingFund;
    }
}
