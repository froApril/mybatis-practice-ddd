package xyf.tech.domain.employee.service;

import org.springframework.stereotype.Service;
import xyf.tech.domain.employee.model.entity.EmployeeInfoEntity;
import xyf.tech.domain.employee.reponsitory.IEmployeeRepository;

import javax.annotation.Resource;


@Service
public class EmployeeService implements IEmployeeService{

    @Resource
    private IEmployeeRepository employeeRepository;

    @Override
    public void insertEmployInfo(EmployeeInfoEntity employeeInfoEntity) {
        employeeRepository.insertEmployeeInfo(employeeInfoEntity);
    }

    @Override
    public EmployeeInfoEntity queryEmployInfo(String employeeNumber) {
        return employeeRepository.queryEmployInfo(employeeNumber);
    }
}
