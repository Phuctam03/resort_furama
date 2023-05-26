package model;


public abstract class Facility {
    protected String id;
    protected String nameService;
    protected double useArea;
    protected double priceHire;
    protected int numberPeople;
    protected String typeRental;

    public Facility() {
    }

    public Facility(String id, String nameService, double useArea, double priceHire, int numberPeople,
            String typeRental) {
        this.id = id;
        this.nameService = nameService;
        this.useArea = useArea;
        this.priceHire = priceHire;
        this.numberPeople = numberPeople;
        this.typeRental = typeRental;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getUseArea() {
        return useArea;
    }

    public void setUseArea(double useArea) {
        this.useArea = useArea;
    }

    public double getPriceHire() {
        return priceHire;
    }

    public void setPriceHire(double priceHire) {
        this.priceHire = priceHire;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public String getTypeRental() {
        return typeRental;
    }

    public void setTypeRental(String typeRental) {
        this.typeRental = typeRental;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", nameService=" + nameService + ", useArea=" + useArea + ", priceHire="
                + priceHire + ", numberPeople=" + numberPeople + ", typeRental=" + this.typeRental + "]";
    }

}
