package christmas.service;

import christmas.DomainEntityManager;
import christmas.service.util.DDayCheck;
import christmas.service.util.GiftCheck;
import christmas.service.util.OrderInfoSave;

public class BusinessService {

    private final DomainEntityManager domainEntityManager;

    public BusinessService(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public void BusinessServiceProgress(){
        orderInfoSaveUtil();
        GiftCheckUtil();
        dDayCheckUtil();
    }

    public void orderInfoSaveUtil(){
        OrderInfoSave orderInfoSave = new OrderInfoSave(domainEntityManager);
        orderInfoSave.calculateOrderAmount();
    }

    public void GiftCheckUtil(){
        GiftCheck giftCheck = new GiftCheck(domainEntityManager);
        giftCheck.setGiftMenuInfo();
    }

    public void dDayCheckUtil(){
        DDayCheck dDayCheck = new DDayCheck(domainEntityManager);
        dDayCheck.dDayCheck();
    }

}
