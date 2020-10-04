package jp.co.axa.apidemo.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class EmployeeModel implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer salary;

    @Getter
    @Setter
    private String department;

    public EmployeeModel() {
    }
}
