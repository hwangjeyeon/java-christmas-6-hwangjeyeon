package christmas.service.util;

import christmas.DomainEntityManager;
import christmas.domain.calendar.December;
import christmas.domain.menu.Category;
import christmas.domain.menu.MenuInfo;

import java.util.List;
import java.util.stream.IntStream;

public class WeekCategoryCheck {

    private final DomainEntityManager domainEntityManager;

    public WeekCategoryCheck(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public void weekCategoryCheck(){
        List<String> orderMenu = domainEntityManager.getUserOrderInfo().getMenu();
        List<Integer> orderCounts = domainEntityManager.getUserOrderInfo().getCounts();
        String weekCategory = December.getDayOfWeekByDay(domainEntityManager.getUserVisitDay().visitDay());

        if(weekCategory.equals("평일")){
            menuCategoryInWeekDayCheck(orderMenu, orderCounts);
        }

        if(weekCategory.equals("주말")){
            menuCategoryInWeekendDayCheck(orderMenu, orderCounts);
        }

        if(domainEntityManager.getOrderInfo().getBeforeOrderAmount() < 10000){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("없음", 0);
        }
    }


    public void menuCategoryInWeekDayCheck(List<String> orderMenu, List<Integer> orderCounts){
        int discounts = IntStream.range(0, orderMenu.size())
                    .filter(i -> {
                        String menuName = orderMenu.get(i);
                        Category category = MenuInfo.getCategoryByName(menuName);
                        return category == Category.DESSERT; // 원하는 카테고리로 변경
                    })
                    .mapToObj(orderCounts::get)
                    .mapToInt(Integer::intValue)
                    .sum();
        if(discounts == 0){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("없음", 0);
        }

        if(discounts != 0){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("평일 할인", discounts*2023);
        }

    }


    public void menuCategoryInWeekendDayCheck(List<String> orderMenu, List<Integer> orderCounts){
        int discounts = IntStream.range(0, orderMenu.size()).filter(i -> {
                    String menuName = orderMenu.get(i);
                    Category category = MenuInfo.getCategoryByName(menuName);
                    return category == Category.MAIN; // 원하는 카테고리로 변경
                })
                .mapToObj(orderCounts::get)
                .mapToInt(Integer::intValue)
                .sum();
        if(discounts == 0){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("없음", 0);
        }

        if(discounts != 0){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("주말 할인", discounts*2023);
        }

    }



}
