package pl.piotr.zadanieapp;



import javax.persistence.*;

@Entity
public class RequestCounterEntity {
    @Id
    private String userName;
    private int counter;

    public RequestCounterEntity() {}

    public RequestCounterEntity(String userName, int counter) {
        this.userName = userName;
        this.counter = counter;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
