package cn.ok.demos.druidmonitordemo.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue()
    private int id;
    private String userName;
    private int age;
    private long phone;
    private Date birthDay;

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-dd").create();
        return gson.toJson(this);
    }
}
