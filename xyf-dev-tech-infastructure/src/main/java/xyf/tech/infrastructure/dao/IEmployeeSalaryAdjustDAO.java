package xyf.tech.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import xyf.tech.infrastructure.po.EmployeeSalaryAdjustPO;

@Mapper
public interface IEmployeeSalaryAdjustDAO {

    void insert(EmployeeSalaryAdjustPO employeeSalaryAdjustPO);
}
