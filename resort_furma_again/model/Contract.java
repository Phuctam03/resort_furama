package model;

public class Contract {
    private int numberContract;
    private String idBooking;
    private double deposit;
    private double totalPayment;

    public Contract() {
    }

    public Contract(int numberContract, String idBooking, double deposit, double totalPayment) {
        this.numberContract = numberContract;
        this.idBooking = idBooking;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
    }

    public int getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "Contract [numberContract=" + numberContract + ", idBooking=" + idBooking + ", deposit=" + deposit
                + ", totalPayment=" + totalPayment + "]";
    }

}
