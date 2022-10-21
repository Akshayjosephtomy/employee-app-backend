package com.nestdigital.employeeappbackend.Controller;

import com.nestdigital.employeeappbackend.Dao.EmployeeDao;
import com.nestdigital.employeeappbackend.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class EmployeeController extends SpringBeanAutowiringSupport {


    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeeEntry",consumes = "application/json",produces = "application/json")
    private String employeeEntry(@RequestBody EmployeeModel employee){
        System.out.println(employee.toString());
        System.out.println(employee.getName());
        dao.save(employee);
        return "(status:'success')";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewemployee")
    public List<EmployeeModel> viewEmployee(){
        return (List<EmployeeModel>) dao.findAll();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemployee",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> searchEmployee(@RequestBody EmployeeModel employee){
        return (List<EmployeeModel>) dao.searchEmployee(employee.getName());
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deleteemployee",consumes = "application/json",produces = "application/json")
    public String deleteEmployee(@RequestBody EmployeeModel employee){
        dao.deleteEmployeeById(employee.getId());
        return "(status:'success')";
    }



}
