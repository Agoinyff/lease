package com.lease.webadmin.schedule;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.lease.model.entity.LeaseAgreement;
import com.lease.model.enums.LeaseStatus;
import com.lease.webadmin.service.LeaseAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author yff
 * @date 2026-01-26 17:16:41
 * 定时检查租约是否过期
 */
@Component
public class ScheduleTasks {

//    @Scheduled(cron = "* * * * * *")
//    public void test(){
    @Autowired
    private LeaseAgreementService   leaseAgreementService;

    @Scheduled(cron = "0 0 0 * * ?") //每天凌晨执行一次
    public void checkLeaseStatus() {
        LambdaUpdateWrapper<LeaseAgreement> leaseAgreementLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        leaseAgreementLambdaUpdateWrapper.le(LeaseAgreement::getLeaseEndDate, new Date())
                .in(LeaseAgreement::getStatus, LeaseStatus.SIGNED, LeaseStatus.WITHDRAWING)
                .set(LeaseAgreement::getStatus, LeaseStatus.EXPIRED);
        leaseAgreementService.update(leaseAgreementLambdaUpdateWrapper);
    }

}
