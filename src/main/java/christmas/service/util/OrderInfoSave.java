package christmas.service.util;

import christmas.DomainEntityManager;

import java.util.List;

public class OrderInfoSave {

    private final DomainEntityManager domainEntityManager;

    public OrderInfoSave(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public void calculateOrderAmount(){
        List<String> orderCounts = domainEntityManager.getUserOrderInfo().getMenu();
        //TODO 메뉴별 가격 와야함

    }

}

