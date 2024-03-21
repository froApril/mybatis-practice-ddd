package xyf.tech.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import xyf.tech.infrastructure.po.EmployeePO;

import java.util.List;


@Mapper
public interface IEmployeeDAO {

    void insert(EmployeePO employee);

    void insertList(List<EmployeePO> list);

    void update(EmployeePO employeePO);

    EmployeePO queryEmployeeByEmployNumber(String employNumber);
}
