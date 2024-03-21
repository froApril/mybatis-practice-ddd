package xyf.tech.infrastructure.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import xyf.tech.domain.employee.model.entity.EmployeeInfoEntity;
import xyf.tech.domain.employee.reponsitory.IEmployeeRepository;
import xyf.tech.infrastructure.dao.IEmployeeDAO;
import xyf.tech.infrastructure.dao.IEmployeeSalaryDAO;
import xyf.tech.infrastructure.po.EmployeePO;
import xyf.tech.infrastructure.po.EmployeeSalaryPO;

import javax.annotation.Resource;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    @Resource
    private IEmployeeDAO employeeDAO;

    @Resource
    private IEmployeeSalaryDAO employeeSalaryDAO;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Override
    public void insertEmployeeInfo(EmployeeInfoEntity employeeInfoEntity) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult(){
            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    EmployeePO employeePO = EmployeePO.builder()
                            .employeeNumber(employeeInfoEntity.getEmployeeNumber())
                            .employeeName(employeeInfoEntity.getEmployeeName())
                            .employeeLevel(employeeInfoEntity.getEmployeeLevel())
                            .employeeTitle(employeeInfoEntity.getEmployeeTitle())
                            .build();

                    employeeDAO.insert(employeePO);

                    EmployeeSalaryPO employeeSalaryPO = EmployeeSalaryPO.builder()
                            .employeeNumber(employeeInfoEntity.getEmployeeNumber())
                            .salaryTotalAmount(employeeInfoEntity.getSalaryTotalAmount())
                            .salaryMeritAmount(employeeInfoEntity.getSalaryMeritAmount())
                            .salaryBaseAmount(employeeInfoEntity.getSalaryBaseAmount())
                            .build();

                    employeeSalaryDAO.insert(employeeSalaryPO);
                } catch (Exception e) {
                    status.setRollbackOnly();
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public EmployeeInfoEntity queryEmployInfo(String employNumber) {
        EmployeePO employeePO = employeeDAO.queryEmployeeByEmployNumber(employNumber);
        EmployeeSalaryPO employeeSalaryPO = employeeSalaryDAO.queryEmployeeSalaryByEmployNumber(employNumber);

        return EmployeeInfoEntity.builder()
                .employeeNumber(employeePO.getEmployeeNumber())
                .employeeName(employeePO.getEmployeeName())
                .employeeLevel(employeePO.getEmployeeLevel())
                .employeeTitle(employeePO.getEmployeeTitle())
                .salaryTotalAmount(employeeSalaryPO.getSalaryTotalAmount())
                .salaryMeritAmount(employeeSalaryPO.getSalaryTotalAmount())
                .salaryBaseAmount(employeeSalaryPO.getSalaryTotalAmount())
                .build();
    }
}
