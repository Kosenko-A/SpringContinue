package ru.geekbrains.SpringContinue.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 128)
    @ApiModelProperty(value = "Имя", required = true)
    private String first_name;

    @Column(name = "last_name",length = 128)
    @ApiModelProperty(value = "Фамилия", required = true)
    private String last_name;

    public Person() {
        UUID.randomUUID();
    }

    public Person(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Override
    @Transactional
    public String toString() {
        return String.format("id: %s, first_name: %s, last_name: %s", id, first_name, last_name);
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
