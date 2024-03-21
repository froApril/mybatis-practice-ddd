package xyf.tech.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import xyf.tech.infrastructure.po.EmployeeSalaryPO;

import java.util.List;

@Mapper
public interface IEmployeeSalaryDAO {
    void insert(EmployeeSalaryPO employeeSalary);

    void insertList(List<EmployeeSalaryPO> list);

    void update(EmployeeSalaryPO employeeSalaryPO);

    EmployeeSalaryPO queryEmployeeSalaryByEmployNumber(String employNumber);
}
