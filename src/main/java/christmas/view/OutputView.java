package christmas.view;


import christmas.service.OutputService;

import java.util.stream.IntStream;

public class OutputView {
    private final OutputService outputService;
    private final String ORDER_MENU = "<주문 메뉴>";
    private final String BEFORE_AMOUNTS = "<할인 전 총주문 금액>";
    private final String GIFT_MENU = "<증정 메뉴>";
    private final String BENEFITS_LIST = "<혜택 내역>";
    private final String TOTAL_BENEFITS_AMOUNTS = "<총혜택 금액>";
    private final String AFTER_DISCOUNTS_AMOUNTS = "<할인 후 예상 결제 금액>";
    private final String EVENT_BADGE = "<12월 이벤트 배지>";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public OutputView(OutputService outputService) {
        this.outputService = outputService;
    }

    public void printEventBenefitsList(){
        printList();
        printOrderMenu();
        printBeforeAmounts();
        printGiftMenu();
        printBenefitsList();
        printTotalBenefits();
        printAfterDiscountsAmounts();
        printEventBadge();
    }

    public void printList(){
        System.out.println(outputService.makeStringEventList());
    }

    public void printOrderMenu(){
        System.out.println(ORDER_MENU + LINE_SEPARATOR + outputService.makeOrderMenuList());

    }

    public void printBeforeAmounts(){
        System.out.println(BEFORE_AMOUNTS + LINE_SEPARATOR + outputService.makeBeforeDiscounts());
    }

    public void printGiftMenu(){
        System.out.println(GIFT_MENU + LINE_SEPARATOR + outputService.makeGiftMenu());
    }

    public void printBenefitsList(){
        System.out.println(BENEFITS_LIST + LINE_SEPARATOR + outputService.makeBenefitsList());
    }

    public void printTotalBenefits(){
        System.out.println(TOTAL_BENEFITS_AMOUNTS + LINE_SEPARATOR + outputService.makeTotalBenefits());
    }

    public void printAfterDiscountsAmounts(){
        System.out.println(AFTER_DISCOUNTS_AMOUNTS + LINE_SEPARATOR + outputService.makeAfterBenefits());

    }

    public void printEventBadge(){
        System.out.println(EVENT_BADGE + LINE_SEPARATOR + outputService.makeBadge());
    }

}
