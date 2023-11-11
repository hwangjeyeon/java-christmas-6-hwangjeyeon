package christmas;

import christmas.domain.OrderInfo;
import christmas.domain.User.UserOrderInfo;
import christmas.domain.User.UserVisitDay;
import christmas.domain.menu.MenuInfo;

import java.util.EnumMap;


public class DomainEntityManager {

    private final UserOrderInfo userOrderInfo;
    private final UserVisitDay userVisitDay;
    private final OrderInfo orderInfo;
    private final EnumMap<MenuInfo, Integer> orderPrice;

    public DomainEntityManager(UserVisitDay userVisitDay, UserOrderInfo userOrderInfo) {
        this.userVisitDay = userVisitDay;
        this.userOrderInfo = userOrderInfo;
        this.orderInfo = new OrderInfo();
        this.orderPrice = new EnumMap<>(MenuInfo.class);
    }

    public UserOrderInfo getUserOrderInfo() {
        return userOrderInfo;
    }

    public UserVisitDay getUserVisitDay() {
        return userVisitDay;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public EnumMap<MenuInfo, Integer> getOrderPrice() {
        return orderPrice;
    }
}
