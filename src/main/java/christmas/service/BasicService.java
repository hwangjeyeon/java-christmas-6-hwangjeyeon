package christmas.service;

import christmas.domain.menu.MenuInfo;

import java.util.EnumSet;
import java.util.stream.Collectors;

public class BasicService {

    private static final String clientCaution = "[사랑하는 고객님! 주문 전에 다음 이벤트 주의사항을 참고해주세요!]\n";
    private static final String clientCautionList1 = "- 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.\n";
    private static final String clientCautionList2 = "- 음료만 주문 시, 주문할 수 없습니다.\n";
    private static final String clientCautionList3 = "- 메뉴는 한 번에 최대 20개 까지만 주문할 수 있습니다.\n";

    public String menuInfoList(){
        return EnumSet.allOf(MenuInfo.class).stream()
                .collect(Collectors.groupingBy(MenuInfo::getCategory,
                        Collectors.mapping(menuInfo -> menuInfo.getName() + "(" + menuInfo.getPrice() + ")",
                                Collectors.joining(", "))))
                .entrySet().stream()
                .map(entry -> "<" + entry.getKey().getMessage() + ">\n" + entry.getValue() + "\n")
                .collect(Collectors.joining());
    }

    public String clientCautionInfo(){
        StringBuilder sb = new StringBuilder(clientCaution)
                .append(clientCautionList1)
                .append(clientCautionList2)
                .append(clientCautionList3);
        return sb.toString();
    }

}
