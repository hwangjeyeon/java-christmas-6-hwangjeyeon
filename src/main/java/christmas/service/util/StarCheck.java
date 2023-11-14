package christmas.service.util;

import christmas.DomainEntityManager;
import christmas.domain.calendar.December;

public class StarCheck {
    private final DomainEntityManager domainEntityManager;

    public StarCheck(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }
    
    public void starCheck(){
        if(December.getStarByDay(domainEntityManager.getUserVisitDay().getVisitDay())
                && domainEntityManager.getOrderInfo().getBeforeOrderAmount() >= 10000){
          domainEntityManager.getBenefitInfo().addBenefitsListInfo("특별 할인", 1000);  
        }
        
        if(!December.getStarByDay(domainEntityManager.getUserVisitDay().getVisitDay())){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("없음", 0);
        }
    }
    
}
