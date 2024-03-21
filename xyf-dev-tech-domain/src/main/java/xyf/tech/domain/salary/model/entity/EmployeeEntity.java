package xyf.tech.domain.salary.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyf.tech.domain.salary.model.valobj.EmployeePostVO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    /** 雇员级别 */
    private EmployeePostVO employeeLevel;
    /** 雇员岗位Title */
    private EmployeePostVO employeeTitle;

}
