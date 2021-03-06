package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.entities.EmployeeModel;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Cacheable(value = "employee-cache", key="#employeeId")
    public Employee getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return optEmp.get();
    }

    public void saveEmployee(EmployeeModel employee){
        Employee emp = new Employee();
        emp.setSalary(employee.getSalary());
        emp.setDepartment(employee.getDepartment());
        emp.setName(employee.getName());
        employeeRepository.save(emp);
    }

    @CacheEvict(value = "employee-cache", key="#employeeId")
    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    @CachePut(value = "employee-cache", key ="#employee.id")
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}