package xyf.tech.domain.employee.reponsitory;

import xyf.tech.domain.employee.model.entity.EmployeeInfoEntity;

public interface IEmployeeRepository {

    void insertEmployeeInfo(EmployeeInfoEntity employeeInfoEntity);

    EmployeeInfoEntity queryEmployInfo(String employNumber);
}
