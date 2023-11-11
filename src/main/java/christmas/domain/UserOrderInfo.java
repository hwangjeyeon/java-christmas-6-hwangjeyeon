package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class UserOrderInfo {

    private final List<String> menu;
    private final List<Integer> counts;

    public UserOrderInfo(String info) {
        menu = new ArrayList<>();
        counts = new ArrayList<>();

        List<String> orderList = List.of(info.split(","));

        for(String order : orderList){
            List<String> orderParts = List.of(order.trim().split("-"));
            menu.add(orderParts.get(0).trim());
            counts.add(Integer.parseInt(orderParts.get(1).trim()));
        }

    }

    public List<String> getMenu() {
        return menu;
    }

    public List<Integer> getCounts() {
        return counts;
    }
}
