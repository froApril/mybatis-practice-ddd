package xyf.tech.dev.test.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyf.tech.infrastructure.dao.IEmployeeSalaryAdjustDAO;
import xyf.tech.infrastructure.po.EmployeeSalaryAdjustPO;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IEmployeeSalaryDAOTest {

    @Resource
    private IEmployeeSalaryAdjustDAO employeeSalaryAdjustDAO;

    @Test
    public void test_insert() {
        EmployeeSalaryAdjustPO employeeSalaryAdjust = new EmployeeSalaryAdjustPO();
        employeeSalaryAdjust.setEmployeeNumber("10031231");
        employeeSalaryAdjust.setAdjustOrderId("109089990191231123");
        employeeSalaryAdjust.setAdjustTotalAmount(new BigDecimal(1000));
        employeeSalaryAdjust.setAdjustBaseAmount(new BigDecimal(800));
        employeeSalaryAdjust.setAdjustMeritAmount(new BigDecimal(200));
        employeeSalaryAdjustDAO.insert(employeeSalaryAdjust);
    }

}
