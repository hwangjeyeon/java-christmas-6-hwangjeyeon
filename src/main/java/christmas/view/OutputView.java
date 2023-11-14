package christmas.view;


import christmas.service.OutputService;

import java.util.stream.IntStream;

public class OutputView {
    OutputService outputService;
    private final String ORDER_MENU = "\n<주문 메뉴>\n";
    private final String BEFORE_AMOUNTS = "\n<할인 전 총주문 금액>\n";
    private final String GIFT_MENU = "\n<증정 메뉴>\n";
    private final String BENEFITS_LIST = "\n<혜택 내역>\n";
    private final String TOTAL_BENEFITS_AMOUNTS = "\n<총혜택 금액>\n";
    private final String AFTER_DISCOUNTS_AMOUNTS = "\n<할인 후 예상 결제 금액>\n";
    private final String EVENT_BADGE = "\n<12월 이벤트 배지>\n";

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
        System.out.print(outputService.makeStringEventList());
    }

    public void printOrderMenu(){
        System.out.print(ORDER_MENU + outputService.makeOrderMenuList());

    }

    public void printBeforeAmounts(){
        System.out.print(BEFORE_AMOUNTS + outputService.makeBeforeDiscounts());
    }

    public void printGiftMenu(){
        System.out.print(GIFT_MENU + outputService.makeGiftMenu());
    }

    public void printBenefitsList(){
        System.out.print(BENEFITS_LIST + outputService.makeBenefitsList());
    }

    public void printTotalBenefits(){
        System.out.print(TOTAL_BENEFITS_AMOUNTS + outputService.makeTotalBenefits());
    }

    public void printAfterDiscountsAmounts(){
        System.out.print(AFTER_DISCOUNTS_AMOUNTS + outputService.makeAfterBenefits());

    }

    public void printEventBadge(){
        System.out.println(EVENT_BADGE + outputService.makeBadge());
    }

}
