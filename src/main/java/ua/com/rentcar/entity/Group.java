package ua.com.rentcar.entity;

import ua.com.rentcar.dao.Identified;

/**
 * Created by maks on 21.01.2015.
 */
public class Group implements Identified<Integer> {
    private int id;
    private String name;

    public Group() {
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
