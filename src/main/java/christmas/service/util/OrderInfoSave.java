package christmas.service.util;

import christmas.DomainEntityManager;
import christmas.domain.menu.MenuInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static christmas.domain.menu.MenuInfo.getPriceByName;

public class OrderInfoSave {

    private final DomainEntityManager domainEntityManager;

    public OrderInfoSave(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public void calculateOrderAmount(){
        List<String> orderMenu = domainEntityManager.getUserOrderInfo().getMenu();
        List<Integer> orderCounts = domainEntityManager.getUserOrderInfo().getCounts();

        int totalAmount = IntStream.range(0, orderMenu.size())
                .mapToObj(i -> MenuInfo.getPriceByName(orderMenu.get(i)) * orderCounts.get(i))
                .mapToInt(Integer::intValue)
                .sum();

        domainEntityManager.getOrderInfo().setBeforeOrderAmount(totalAmount);
    }



}

