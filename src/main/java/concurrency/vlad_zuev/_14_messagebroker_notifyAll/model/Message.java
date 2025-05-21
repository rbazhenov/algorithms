package concurrency.vlad_zuev._14_messagebroker_notifyAll.model;

import java.util.Objects;

public class Message {

    private final String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Message other = (Message) otherObject;
        return Objects.equals(this.data, other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[data = " + this.data + "]";
    }
}
