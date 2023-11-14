package christmas.service.util;

import christmas.DomainEntityManager;

public class DDayCheck {
    DomainEntityManager domainEntityManager;

    public DDayCheck(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public void dDayCheck(){
        if(domainEntityManager.getUserVisitDay().getVisitDay() <= 25
            && domainEntityManager.getOrderInfo().getBeforeOrderAmount() >= 10000){
            int discounts = 1000 + (domainEntityManager.getUserVisitDay().getVisitDay() - 1) * 100;
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("크리스마스 디데이 할인", discounts);
        }

        if(domainEntityManager.getUserVisitDay().getVisitDay() > 25 ){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("없음",0);
        }
    }


}
