package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * add employee
     * @param employeeDTO
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * employee split page query
     * @param employeePageQueryDTO
     * @return
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * activate employee or
     * @param status
     * @param id
     */
    void activatestatus(Integer status, Long id);

    /**
     * query employee by id
     * @param id
     * @return
     */
    Employee getById(Long id);

    /**
     * edit employee
     * @param employeeDTO
     */
    void update(EmployeeDTO employeeDTO);
}
