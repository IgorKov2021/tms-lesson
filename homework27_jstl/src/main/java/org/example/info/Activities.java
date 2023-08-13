package org.example.info;

public class Activities {
    String name;
    Status status = Status.NOT_DONE;

    public Activities(String name) {
        this.name = name;

    }


    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
