package christmas;

import christmas.domain.OrderInfo;
import christmas.domain.User.UserOrderInfo;
import christmas.domain.User.UserVisitDay;

public class DomainEntityManager {

    private final UserOrderInfo userOrderInfo;
    private final UserVisitDay userVisitDay;
    private final OrderInfo orderInfo;

    public DomainEntityManager(UserVisitDay userVisitDay, UserOrderInfo userOrderInfo) {
        this.userVisitDay = userVisitDay;
        this.userOrderInfo = userOrderInfo;
        this.orderInfo = new OrderInfo();
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
}
