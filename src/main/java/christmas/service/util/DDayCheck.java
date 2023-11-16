package christmas.service.util;

import christmas.domain.DomainEntityManager;

public class DDayCheck {
    private final DomainEntityManager domainEntityManager;

    public DDayCheck(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }


    /**
     * dDayCheck(): 디데이 정보 확인
     */
    public void dDayCheck(){
        if(domainEntityManager.getUserVisitDay().visitDay() <= 25
            && domainEntityManager.getOrderInfo().getBeforeOrderAmount() >= 10000){
            int discounts = 1000 + (domainEntityManager.getUserVisitDay().visitDay() - 1) * 100;
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("크리스마스 디데이 할인", discounts);
        }

        if(domainEntityManager.getUserVisitDay().visitDay() > 25 ){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("없음",0);
        }
    }


}
