package xyf.tech.domain.salary.model.service;

import org.springframework.stereotype.Service;
import xyf.tech.domain.salary.model.aggregate.AdjustSalaryApplyOrderAggregate;
import xyf.tech.domain.salary.model.repository.ISalaryAdjustRepository;

import javax.annotation.Resource;

@Service
public class SalaryAdjustApplyService implements ISalaryAdjustApplyService{


    @Resource
    private ISalaryAdjustRepository salaryAdjustRepository;

    @Override
    public String execSalaryAdjust(AdjustSalaryApplyOrderAggregate adjustSalaryApplyOrderAggregate) {
        return salaryAdjustRepository.adjustSalary(adjustSalaryApplyOrderAggregate);
    }
}
