package christmas.service;

import christmas.DomainEntityManager;
import christmas.service.util.*;

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
        starCheckUtil();
        giftSaveUtil();
        calculateBenefitsUtil();
        eventBadgeCheckUtil();
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

    public void starCheckUtil(){
        StarCheck starCheck = new StarCheck(domainEntityManager);
        starCheck.starCheck();
    }

    public void giftSaveUtil(){
        GiftSave giftSave = new GiftSave(domainEntityManager);
        giftSave.giftSave();
    }

    public void calculateBenefitsUtil(){
        CalculateBenefits calculateBenefits = new CalculateBenefits(domainEntityManager);
        calculateBenefits.calculateBenefits();
        calculateBenefits.calculateAfterDiscounts();
    }

    public void eventBadgeCheckUtil(){
        EventBadgeCheck eventBadgeCheck = new EventBadgeCheck(domainEntityManager);
        eventBadgeCheck.eventBadgeCheck();
    }

}
