package christmas.service;

import christmas.DomainEntityManager;
import christmas.service.util.GiftCheckUtil;
import christmas.service.util.OrderInfoSave;

public class BusinessService {

    private final DomainEntityManager domainEntityManager;

    public BusinessService(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public void BusinessServiceProgress(){
        orderInfoSaveUtil();
        GiftCheckUtil();
    }

    public void orderInfoSaveUtil(){
        OrderInfoSave orderInfoSave = new OrderInfoSave(domainEntityManager);
        orderInfoSave.calculateOrderAmount();
    }

    public void GiftCheckUtil(){
        GiftCheckUtil giftCheckUtil = new GiftCheckUtil(domainEntityManager);
        giftCheckUtil.setGiftMenuInfo();
    }

}
