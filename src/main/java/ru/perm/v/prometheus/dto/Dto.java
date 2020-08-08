package ru.perm.v.prometheus.dto;

public class Dto {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void incId() {
        id++;
    }

    @Override
    public String toString() {
        return "Dto{" +
                "id=" + id +
                '}';
    }
}
