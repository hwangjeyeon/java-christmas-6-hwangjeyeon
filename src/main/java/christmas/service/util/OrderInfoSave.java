package christmas.service.util;

import christmas.domain.DomainEntityManager;
import christmas.domain.menu.MenuInfo;
import java.util.List;
import java.util.stream.IntStream;

public class OrderInfoSave {

    private final DomainEntityManager domainEntityManager;

    public OrderInfoSave(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    /**
     * calculateBeforeOrderAmount(): 할인 전 주문 정보 계산 및 저장
     */
    public void calculateBeforeOrderAmount(){
        List<String> orderMenu = domainEntityManager.getUserOrderInfo().getMenu();
        List<Integer> orderCounts = domainEntityManager.getUserOrderInfo().getCounts();

        int totalAmount = IntStream.range(0, orderMenu.size())
                .mapToObj(i -> MenuInfo.getPriceByName(orderMenu.get(i)) * orderCounts.get(i))
                .mapToInt(Integer::intValue)
                .sum();

        domainEntityManager.getOrderInfo().setBeforeOrderAmount(totalAmount);
    }



}

