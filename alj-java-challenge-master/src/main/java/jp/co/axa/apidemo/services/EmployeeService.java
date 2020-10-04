package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.entities.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    public List<Employee> retrieveEmployees();

    public Employee getEmployee(Long employeeId);

    public void saveEmployee(EmployeeModel employee);

    public void deleteEmployee(Long employeeId);

    public void updateEmployee(Employee employee);
}