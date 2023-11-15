package christmas.service.util;

import christmas.DomainEntityManager;

public class GiftSave {
    private final DomainEntityManager domainEntityManager;

    public GiftSave(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public void giftSave(){
        if(domainEntityManager.getGiftMenuInfo().getPrice() == 0){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("없음"
                    , domainEntityManager.getGiftMenuInfo().getPrice());
        }

        if(domainEntityManager.getGiftMenuInfo().getPrice() != 0){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("증정 이벤트"
                    , domainEntityManager.getGiftMenuInfo().getPrice());
        }

    }

}
