package christmas.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserOrderInfo {

    private List<String> menu;
    private List<Integer> counts;

    public UserOrderInfo(String info) {
        menu = new ArrayList<>();
        counts = new ArrayList<>();

        List<String> orderList = List.of(info.split(","));
        setSplitMenuName(orderList);
        setSplitMenuCounts(orderList);
    }

    private void setSplitMenuCounts(List<String> orderList) {
        counts = orderList.stream()
                .map(order -> order.split("-"))
                .map(orderParts -> Integer.parseInt(orderParts[1].trim()))
                .toList();
    }

    private void setSplitMenuName(List<String> orderList) {
        menu = orderList.stream()
                .map(order -> order.split("-"))
                .map(orderParts -> orderParts[0].trim())
                .toList();
    }

    public int calculateOrderCounts(){
        return counts.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<String> getMenu() {
        return menu;
    }

    public List<Integer> getCounts() {
        return counts;
    }
}
