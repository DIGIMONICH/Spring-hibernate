package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    private int series;

    @Column(name= "model")
    private String model;

    @OneToOne(mappedBy = "car")
    private User owner;

    public Car() {}

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return  "series= " + series +
                ", model= " + model;
    }
}
