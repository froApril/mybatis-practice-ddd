package xyf.tech.domain.salary.model.repository;

import xyf.tech.domain.salary.model.aggregate.AdjustSalaryApplyOrderAggregate;

public interface ISalaryAdjustRepository {

    String adjustSalary(AdjustSalaryApplyOrderAggregate adjustSalaryApplyOrderAggregate);
}
