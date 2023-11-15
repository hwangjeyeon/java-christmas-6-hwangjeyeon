package christmas.service.util;

import christmas.domain.DomainEntityManager;

public class GiftSave {
    private final DomainEntityManager domainEntityManager;

    public GiftSave(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }


    /**
     * giftSave():
     * - noneGift(): 증정 선물 해당 안 되는 경우 저장
     * - saveGift(): 증정 선물 해당 되는 경우 저장
     */
    public void giftSave(){
        noneGift();
        saveGift();
    }

    private void saveGift() {
        if(domainEntityManager.getGiftMenuInfo().getPrice() != 0){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("증정 이벤트"
                    , domainEntityManager.getGiftMenuInfo().getPrice());
        }
    }

    private void noneGift() {
        if(domainEntityManager.getGiftMenuInfo().getPrice() == 0){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("없음"
                    , domainEntityManager.getGiftMenuInfo().getPrice());
        }
    }

}
