package xyf.tech.domain.salary.model.service;

import xyf.tech.domain.salary.model.aggregate.AdjustSalaryApplyOrderAggregate;

public interface ISalaryAdjustApplyService {

    String execSalaryAdjust(AdjustSalaryApplyOrderAggregate adjustSalaryApplyOrderAggregate);

}
