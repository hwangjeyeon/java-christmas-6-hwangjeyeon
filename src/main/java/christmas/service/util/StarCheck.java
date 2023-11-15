package christmas.service.util;

import christmas.domain.DomainEntityManager;
import christmas.domain.calendar.December;

public class StarCheck {
    private final DomainEntityManager domainEntityManager;

    public StarCheck(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }


    /**
     * starCheck():
     * - noneStar: 해당 날짜에 별이 없는 경우
     * - checkStar: 해당 날짜에 별이 있는 경우
     */
    public void starCheck(){
        checkStar();
        noneStar();
    }

    private void noneStar() {
        if(!December.getStarByDay(domainEntityManager.getUserVisitDay().visitDay())){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("없음", 0);
        }
    }

    private void checkStar() {
        if(December.getStarByDay(domainEntityManager.getUserVisitDay().visitDay())
                && domainEntityManager.getOrderInfo().getBeforeOrderAmount() >= 10000){
          domainEntityManager.getBenefitInfo().addBenefitsListInfo("특별 할인", 1000);
        }
    }

}
