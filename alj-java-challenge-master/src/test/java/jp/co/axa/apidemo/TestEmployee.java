package jp.co.axa.apidemo;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import jp.co.axa.apidemo.services.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class TestEmployee {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Test
    public void getAllEmployeesTest()
    {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee();
        empOne.setId(1L);
        empOne.setName("pradeep");
        empOne.setDepartment("IT");
        empOne.setSalary(100);
        Employee empTwo = new Employee();
        empOne.setId(2L);
        empOne.setName("pradeep1");
        empOne.setDepartment("IT");
        empOne.setSalary(100);
        Employee empThree = new Employee();
        empOne.setId(3L);
        empOne.setName("pradeep2");
        empOne.setDepartment("IT");
        empOne.setSalary(100);

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        when(employeeRepository.findAll()).thenReturn(list);

        //test
        List<Employee> empList = employeeService.retrieveEmployees();

        assertEquals(3, empList.size());
        verify(this.employeeRepository, times(1)).findAll();
    }


    @Test
    public void getAllEmployeeById()
    {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee();
        empOne.setId(1L);
        empOne.setName("pradeep");
        empOne.setDepartment("IT");
        empOne.setSalary(100);

        Optional<Employee> emp = Optional.of(empOne);
        when(employeeRepository.findById(1L)).thenReturn(emp);

        //test
        Employee resultEmp = employeeService.getEmployee(1L);

        assertEquals("pradeep", resultEmp.getName());
    }

    @Test
    public  void  saveEmployeeTest ()  {

        Employee empOne = new Employee();
        empOne.setId(1L);
        empOne.setName("pradeep");
        empOne.setDepartment("IT");
        empOne.setSalary(100);

        when(this.employeeRepository.save(empOne)).thenReturn(empOne);

        this.employeeService.saveEmployee(empOne);

        Optional<Employee> emp = Optional.of(empOne);
        when(employeeRepository.findById(1L)).thenReturn(emp);

        //test
        Employee resultEmp = employeeService.getEmployee(1L);

        assertEquals("pradeep", resultEmp.getName());
    }

    @Test
    public  void  deleteEmployeeById ()  {

        this.employeeService.deleteEmployee(1L);

        verify(this.employeeRepository, times(1)).deleteById(1L);
    }
}
