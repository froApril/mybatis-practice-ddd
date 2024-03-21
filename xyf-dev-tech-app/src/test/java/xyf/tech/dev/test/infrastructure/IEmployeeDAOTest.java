package xyf.tech.dev.test.infrastructure;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyf.tech.infrastructure.dao.IEmployeeDAO;
import xyf.tech.infrastructure.po.EmployeePO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IEmployeeDAOTest {
    @Resource
    private IEmployeeDAO employeeDAO;

    @Test
    public void test_insert() {
        EmployeePO employee = new EmployeePO();
        employee.setEmployeeNumber("1001231");
        employee.setEmployeeName("小傅哥");
        employee.setEmployeeLevel("T2");
        employee.setEmployeeTitle("见习工程师");
        employeeDAO.insert(employee);
    }

    @Test
    public void test_query() {
        EmployeePO employeePO = employeeDAO.queryEmployeeByEmployNumber("1001231");
        log.info("测试结果：{}", JSON.toJSONString(employeePO));
    }

    @Test
    public void test_insert_list() {
        List<EmployeePO> list = new ArrayList<>();
        for (int i = 5; i < 8; i++) {
            EmployeePO employee = new EmployeePO();
            employee.setEmployeeNumber("1001231" + i);
            employee.setEmployeeName("花花");
            employee.setEmployeeLevel("T2");
            employee.setEmployeeTitle("见习工程师");
            list.add(employee);
        }
        employeeDAO.insertList(list);
    }
}
