package xyf.tech.infrastructure.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyf.tech.domain.salary.model.aggregate.AdjustSalaryApplyOrderAggregate;
import xyf.tech.domain.salary.model.entity.EmployeeEntity;
import xyf.tech.domain.salary.model.entity.EmployeeSalaryAdjustEntity;
import xyf.tech.domain.salary.model.repository.ISalaryAdjustRepository;
import xyf.tech.infrastructure.dao.IEmployeeDAO;
import xyf.tech.infrastructure.dao.IEmployeeSalaryAdjustDAO;
import xyf.tech.infrastructure.dao.IEmployeeSalaryDAO;
import xyf.tech.infrastructure.po.EmployeePO;
import xyf.tech.infrastructure.po.EmployeeSalaryAdjustPO;
import xyf.tech.infrastructure.po.EmployeeSalaryPO;

import javax.annotation.Resource;

@Repository
public class SalaryAdjustRepository implements ISalaryAdjustRepository {
    @Resource
    private IEmployeeDAO employeeDAO;

    @Resource
    private IEmployeeSalaryDAO employeeSalaryDAO;

    @Resource
    private IEmployeeSalaryAdjustDAO employeeSalaryAdjustDAO;

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 350, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String adjustSalary(AdjustSalaryApplyOrderAggregate adjustSalaryApplyOrderAggregate) {
        String employeeNumber = adjustSalaryApplyOrderAggregate.getEmployeeNumber();
        String orderId = adjustSalaryApplyOrderAggregate.getOrderId();
        EmployeeEntity employeeEntity = adjustSalaryApplyOrderAggregate.getEmployeeEntity();
        EmployeeSalaryAdjustEntity employeeSalaryAdjustEntity = adjustSalaryApplyOrderAggregate.getEmployeeSalaryAdjustEntity();

        EmployeePO employeePO = EmployeePO.builder()
                .employeeNumber(employeeNumber)
                .employeeLevel(employeeEntity.getEmployeeLevel().getCode())
                .employeeTitle(employeeEntity.getEmployeeTitle().getCode()).build();

        employeeDAO.update(employeePO);

        EmployeeSalaryPO employeeSalaryPO = EmployeeSalaryPO.builder()
                .employeeNumber(employeeNumber)
                .salaryTotalAmount(employeeSalaryAdjustEntity.getAdjustTotalAmount())
                .salaryMeritAmount(employeeSalaryAdjustEntity.getAdjustMeritAmount())
                .salaryBaseAmount(employeeSalaryAdjustEntity.getAdjustBaseAmount())
                .build();

        employeeSalaryDAO.update(employeeSalaryPO);

        EmployeeSalaryAdjustPO employeeSalaryAdjustPO = EmployeeSalaryAdjustPO.builder()
                .employeeNumber(employeeNumber)
                .adjustOrderId(orderId)
                .adjustTotalAmount(employeeSalaryAdjustEntity.getAdjustTotalAmount())
                .adjustMeritAmount(employeeSalaryAdjustEntity.getAdjustMeritAmount())
                .adjustBaseAmount(employeeSalaryAdjustEntity.getAdjustBaseAmount())
                .build();
        employeeSalaryAdjustDAO.insert(employeeSalaryAdjustPO);

        return orderId;
    }
}
