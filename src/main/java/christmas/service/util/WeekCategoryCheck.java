package christmas.service.util;

import christmas.domain.DomainEntityManager;
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

    /**
     * weekCategoryCheck():
     * - weekCategoryInWeekDay(): 평일인지 확인
     *      - menuCategoryInWeekDayCheck():
     *          - weekDayDiscounts (static): 평일 할인정보 계산
     *          - weekDayDiscounts(): 평일 할인정보 저장
     *          - noneDiscounts(): 할인 혜택 미적용
     * - weekCategoryInWeekendDay(): 주말인지 확인
     *      - menuCategoryInWeekendDayCheck():
     *          - weekendDayDiscounts(static): 주말 할인정보 계산
     *          - weekendDayDiscounts(): 주말 할인정보 저장
     *          - noneDiscounts(): 할인 혜택 미적용
     * - weekCategoryInNone(): 할인 혜택 미적용
     */
    public void weekCategoryCheck(){
        List<String> orderMenu = domainEntityManager.getUserOrderInfo().getMenu();
        List<Integer> orderCounts = domainEntityManager.getUserOrderInfo().getCounts();
        String weekCategory = December.getDayOfWeekByDay(domainEntityManager.getUserVisitDay().visitDay());

        weekCategoryInWeekDay(weekCategory, orderMenu, orderCounts);
        weekCategoryInWeekendDay(weekCategory, orderMenu, orderCounts);
        weekCategoryInNone();
    }

    private void weekCategoryInWeekDay(String weekCategory, List<String> orderMenu, List<Integer> orderCounts) {
        if(weekCategory.equals("평일")){
            menuCategoryInWeekDayCheck(orderMenu, orderCounts);
        }
    }


    public void menuCategoryInWeekDayCheck(List<String> orderMenu, List<Integer> orderCounts){
        int discounts = weekDayDiscounts(orderMenu, orderCounts);
        noneDiscounts(discounts);
        weekDayDiscounts(discounts);
    }

    private static int weekDayDiscounts(List<String> orderMenu, List<Integer> orderCounts) {
        return IntStream.range(0, orderMenu.size())
                .filter(i -> {
                    String menuName = orderMenu.get(i);
                    Category category = MenuInfo.getCategoryByName(menuName);
                    return category == Category.DESSERT;
                })
                .mapToObj(orderCounts::get)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void weekDayDiscounts(int discounts) {
        if(discounts != 0){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("평일 할인", discounts * 2023);
        }
    }

    private void weekCategoryInWeekendDay(String weekCategory, List<String> orderMenu, List<Integer> orderCounts) {
        if(weekCategory.equals("주말")){
            menuCategoryInWeekendDayCheck(orderMenu, orderCounts);
        }
    }

    public void menuCategoryInWeekendDayCheck(List<String> orderMenu, List<Integer> orderCounts){
        int discounts = weekendDayDiscounts(orderMenu, orderCounts);
        noneDiscounts(discounts);
        weekendDayDiscounts(discounts);
    }

    private static int weekendDayDiscounts(List<String> orderMenu, List<Integer> orderCounts) {
        return IntStream.range(0, orderMenu.size()).filter(i -> {
                    String menuName = orderMenu.get(i);
                    Category category = MenuInfo.getCategoryByName(menuName);
                    return category == Category.MAIN;
                })
                .mapToObj(orderCounts::get)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void weekendDayDiscounts(int discounts) {
        if(discounts != 0){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("주말 할인", discounts * 2023);
        }
    }

    private void noneDiscounts(int discounts) {
        if(discounts == 0){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("없음", 0);
        }
    }

    private void weekCategoryInNone() {
        if(domainEntityManager.getOrderInfo().getBeforeOrderAmount() < 10000){
            domainEntityManager.getBenefitInfo().addBenefitsListInfo("없음", 0);
        }
    }

}
