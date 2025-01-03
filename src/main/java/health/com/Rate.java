package health.com;

public class Rate {

    private int rateValue;
    private String rateMessage;
    public Rate(int rate, String message){
        this.rateMessage=message;
        this.rateValue=rate;
    }


    public int getRateValue() {
        return rateValue;
    }

    public void setRateValue(int rateValue) {
        this.rateValue = rateValue;
    }

    public String getRateMessage() {
        return rateMessage;
    }

    public void setRateMessage(String rateMessage) {
        this.rateMessage = rateMessage;
    }


    @Override
    public String toString() {
        return "Rate [ rateMessage=" + rateMessage + ", rateValue=" + rateValue + "/5 ]";
    }
}
