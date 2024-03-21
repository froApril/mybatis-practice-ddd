package xyf.tech.domain.salary.model.aggregate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyf.tech.domain.salary.model.entity.EmployeeEntity;
import xyf.tech.domain.salary.model.entity.EmployeeSalaryAdjustEntity;
import xyf.tech.domain.salary.model.valobj.EmployeePostVO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdjustSalaryApplyOrderAggregate {
    /** 雇员编号 */
    private String employeeNumber;
    /** 调薪单号 */
    private String orderId;
    /** 雇员实体 */
    private EmployeeEntity employeeEntity;
    /** 雇员实体 */
    private EmployeeSalaryAdjustEntity employeeSalaryAdjustEntity;
}
