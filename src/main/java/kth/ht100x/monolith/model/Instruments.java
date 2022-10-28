package kth.ht100x.monolith.model;

public class Instruments {
    private final int id;
    private final String type;
    private final String brand;
    private final String date;
    private final int price;
    private final Boolean status;
    private final String rentedByWho;

    public Instruments(int id, String type, String brand, String date, int price, Boolean status, String rentedByWho) {

        this.id = id;
        this.type = type;
        this.brand = brand;
        this.date = date;
        this.price = price;
        this.status = status;
        this.rentedByWho = rentedByWho;
    }

    public Instruments(Instruments instruments, String name) {
        this.id = instruments.getId();
        this.type = instruments.getType();
        this.brand = instruments.getBrand();
        this.date = instruments.getDate();
        this.price = instruments.getPrice();
        this.status = instruments.getStatus();
        this.rentedByWho = name;
    }
    
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getRentedByWho() {
        return rentedByWho;
    }
}
