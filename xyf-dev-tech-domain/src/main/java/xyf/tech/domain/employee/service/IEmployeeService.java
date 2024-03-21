package xyf.tech.domain.employee.service;

import xyf.tech.domain.employee.model.entity.EmployeeInfoEntity;

public interface IEmployeeService {

    void insertEmployInfo(EmployeeInfoEntity employeeInfoEntity);

    EmployeeInfoEntity queryEmployInfo(String employeeNumber);
}
