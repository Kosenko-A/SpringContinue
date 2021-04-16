package ru.geekbrains.SpringContinue.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonDto {

    @NotBlank
    @ApiModelProperty(value = "Имя", required = true)
    private String first_name;

    @NotNull
    @ApiModelProperty(value = "Фамилия", required = true)
    private String last_name;

    public PersonDto() {

    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
