package sample.models;

public class Credit {
    private int sum;
    private String date;
    private int sumInMounth;

    public Credit(int sum, String date, int sumInMounth) {
        this.sum = sum;
        this.date = date;
        this.sumInMounth = sumInMounth;
    }

    @Override
    public String toString() {
        return sum + " " + date + " " + sumInMounth;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSumInMounth() {
        return sumInMounth;
    }

    public void setSumInMounth(int sumInMounth) {
        this.sumInMounth = sumInMounth;
    }
}
