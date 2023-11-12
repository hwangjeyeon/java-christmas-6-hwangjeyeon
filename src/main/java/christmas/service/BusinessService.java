package christmas.service;

import christmas.DomainEntityManager;
import christmas.service.util.OrderInfoSave;

public class BusinessService {

    private final DomainEntityManager domainEntityManager;

    public BusinessService(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public void BusinessServiceProgress(){
        orderInfoSaveUtil();
    }

    public void orderInfoSaveUtil(){
        OrderInfoSave orderInfoSave = new OrderInfoSave(domainEntityManager);
        orderInfoSave.calculateOrderAmount();
    }

}
