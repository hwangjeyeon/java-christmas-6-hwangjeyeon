package christmas.service.util;

import christmas.DomainEntityManager;
import christmas.domain.menu.MenuInfo;

public class GiftCheck {
    private final DomainEntityManager domainEntityManager;

    public GiftCheck(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }


    /**
     * giftCheck(): 증정 선물 제공 여부 판단
     * setGiftMenuInfo(): 증정 선물 정보 설정
     *
     */
    public boolean giftCheck(){
        if(domainEntityManager.getOrderInfo().getBeforeOrderAmount() >= 120000){
            return true;
        }

        return false;
    }


    public void setGiftMenuInfo(){
        if(giftCheck()){
            domainEntityManager.getGiftMenuInfo().setName(MenuInfo.CHAMPAGNE.getName());
            domainEntityManager.getGiftMenuInfo().setCounts(1);
            domainEntityManager.getGiftMenuInfo().setGiftMenuPrice();
        }

        if(!giftCheck()){
            domainEntityManager.getGiftMenuInfo().setName("없음");
            domainEntityManager.getGiftMenuInfo().setCounts(0);
        }
    }

}
