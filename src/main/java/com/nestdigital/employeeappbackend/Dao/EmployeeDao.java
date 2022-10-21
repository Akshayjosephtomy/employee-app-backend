package com.nestdigital.employeeappbackend.Dao;

import com.nestdigital.employeeappbackend.Model.EmployeeModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository <EmployeeModel,Integer> {

    @Modifying
    @Query(value = "DELETE FROM `employees` WHERE `id`= :id",nativeQuery = true)
    void deleteEmployeeById(Integer id);

    @Query(value = "SELECT `id`, `address`, `code`, `company`, `dob`, `name`, `phone`, `salary` FROM `employees` WHERE `name` LIKE concat('%',:name,'%')",nativeQuery = true)
    List<EmployeeModel>searchEmployee(String name);

}
