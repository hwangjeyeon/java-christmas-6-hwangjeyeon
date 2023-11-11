package christmas.service.util;

import christmas.DomainEntityManager;
import christmas.domain.menu.MenuInfo;

import java.util.List;
import java.util.stream.Collectors;

public class OrderInfoSave {

    private final DomainEntityManager domainEntityManager;

    public OrderInfoSave(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public void calculateOrderAmount(){
        List<String> orderMenu = domainEntityManager.getUserOrderInfo().getMenu();
        //TODO 메뉴별 가격 와야함
        int totalAmount = orderMenu.stream()
                .map(MenuInfo::valueOf)
                .mapToInt(menuInfo ->  domainEntityManager.getOrderPrice().get(menuInfo))
                .sum();

        domainEntityManager.getOrderInfo().setBeforeOrderAmount(totalAmount);
    }

}

