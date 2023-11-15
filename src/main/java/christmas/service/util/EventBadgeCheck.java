package christmas.service.util;

import christmas.domain.DomainEntityManager;

public class EventBadgeCheck {
    private final DomainEntityManager domainEntityManager;

    public EventBadgeCheck(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }


    /**
     * eventBadgeCheck(): 이벤트 배지 정보 확인
     */
    public void eventBadgeCheck(){

        if(domainEntityManager.getBenefitInfo().getTotalBenefitsAmounts() >= 5000){
            domainEntityManager.getEventBadge().setEventBadge("별");
        }

        if(domainEntityManager.getBenefitInfo().getTotalBenefitsAmounts() >= 10000){
            domainEntityManager.getEventBadge().setEventBadge("트리");
        }

        if(domainEntityManager.getBenefitInfo().getTotalBenefitsAmounts() >= 20000){
            domainEntityManager.getEventBadge().setEventBadge("산타");
        }
    }

}
