package christmas.service;

import christmas.DomainEntityManager;
import christmas.service.util.DDayCheck;
import christmas.service.util.GiftCheck;
import christmas.service.util.OrderInfoSave;
import christmas.service.util.WeekCategoryCheck;

public class BusinessService {

    private final DomainEntityManager domainEntityManager;

    public BusinessService(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public void BusinessServiceProgress(){
        orderInfoSaveUtil();
        giftCheckUtil();
        dDayCheckUtil();
        weekCategoryCheckUtil();
    }

    public void orderInfoSaveUtil(){
        OrderInfoSave orderInfoSave = new OrderInfoSave(domainEntityManager);
        orderInfoSave.calculateOrderAmount();
    }

    public void giftCheckUtil(){
        GiftCheck giftCheck = new GiftCheck(domainEntityManager);
        giftCheck.setGiftMenuInfo();
    }

    public void dDayCheckUtil(){
        DDayCheck dDayCheck = new DDayCheck(domainEntityManager);
        dDayCheck.dDayCheck();
    }

    public void weekCategoryCheckUtil(){
        WeekCategoryCheck weekCategoryCheck = new WeekCategoryCheck(domainEntityManager);
        weekCategoryCheck.weekCategoryCheck();
    }

}
