package christmas.service.util;

import christmas.DomainEntityManager;
import christmas.domain.menu.MenuInfo;

public class GiftCheckUtil {
    private final DomainEntityManager domainEntityManager;

    public GiftCheckUtil(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public boolean GiftCheck(){
        if(domainEntityManager.getOrderInfo().getBeforeOrderAmount() >= 120000){
            return true;
        }

        return false;
    }


    public void setGiftMenuInfo(){
        if(GiftCheck()){
            domainEntityManager.getGiftMenuInfo().setName(MenuInfo.CHAMPAGNE.getName());
            domainEntityManager.getGiftMenuInfo().setCounts(1);
        }

        if(!GiftCheck()){
            domainEntityManager.getGiftMenuInfo().setName("없음");
            domainEntityManager.getGiftMenuInfo().setCounts(0);
        }
    }

}
