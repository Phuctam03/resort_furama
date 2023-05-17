package model;

import java.time.LocalDate;

public class Booking {
    private String idBooking;
    private LocalDate timeBooking;
    private LocalDate startTimeHire;
    private LocalDate lastTimeHire;
    private String idCustomer;
    private String idService;

    public Booking() {
    }

    public Booking(String idBooking, LocalDate timeBooking, LocalDate startTimeHire, LocalDate lastTimeHire,
            String idCustomer, String idService) {
        this.idBooking = idBooking;
        this.timeBooking = timeBooking;
        this.startTimeHire = startTimeHire;
        this.lastTimeHire = lastTimeHire;
        this.idCustomer = idCustomer;
        this.idService = idService;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getTimeBooking() {
        return timeBooking;
    }

    public void setTimeBooking(LocalDate timeBooking) {
        this.timeBooking = timeBooking;
    }

    public LocalDate getStartTimeHire() {
        return startTimeHire;
    }

    public void setStartTimeHire(LocalDate startTimeHire) {
        this.startTimeHire = startTimeHire;
    }

    public LocalDate getLastTimeHire() {
        return lastTimeHire;
    }

    public void setLastTimeHire(LocalDate lastTimeHire) {
        this.lastTimeHire = lastTimeHire;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "Booking [idBooking=" + idBooking + ", timeBooking=" + timeBooking + ", startTimeHire=" + startTimeHire
                + ", lastTimeHire=" + lastTimeHire + ", idCustomer=" + idCustomer + ", idService=" + idService + "]";
    }
}
