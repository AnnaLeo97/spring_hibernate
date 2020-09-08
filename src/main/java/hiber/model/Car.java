package hiber.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;

    @NonNull
    @Column
    String name;

    @NonNull
    @Column
    int series;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    public Car() { }

    public Car(String name, int series) {
        this.name = name;
        this.series = series;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getSeries() { return series; }

    public void setSeries(int series) { this.series = series; }

   public void setId(long id) { this.id = id; }

    public long getId() { return id; }
}
