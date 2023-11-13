package christmas.view;

import christmas.DomainEntityManager;

import java.util.stream.IntStream;

public class OutputView {
    DomainEntityManager domainEntityManager;
    private final String ORDER_MENU = "\n<주문 메뉴>\n";
    private final String BEFORE_AMOUNTS = "\n<할인 전 총주문 금액>\n";
    private final String GIFT_MENU = "\n<증정 메뉴>\n";
    private final String BENEFITS_LIST = "\n<혜택 내역>\n";
    private final String TOTAL_BENEFITS_AMOUNTS = "\n<총혜택 금액>\n";
    private final String AFTER_DISCOUNTS_AMOUNTS = "\n<할인 후 예상 결제 금액>\n";
    private final String EVENT_BADGE = "\n<12월 이벤트 배지>\n";
    public OutputView(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
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
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"
                ,domainEntityManager.getUserVisitDay().getVisitDay());
    }

    public void printOrderMenu(){
        System.out.print(ORDER_MENU);
        IntStream.range(0, domainEntityManager.getUserOrderInfo().getMenu().size())
                .forEach(i -> {
                    String menu = domainEntityManager.getUserOrderInfo().getMenu().get(i);
                    int counts = domainEntityManager.getUserOrderInfo().getCounts().get(i);
                    System.out.printf("%s %d개\n", menu, counts);
                });
    }

    public void printBeforeAmounts(){
        System.out.println(BEFORE_AMOUNTS + domainEntityManager.getOrderInfo().getBeforeOrderAmount() + "개");
    }

    public void printGiftMenu(){
        System.out.println(GIFT_MENU + domainEntityManager.getGiftMenuInfo().getName()
                + domainEntityManager.getGiftMenuInfo().getCounts() + "개");
    }

    public void printBenefitsList(){
        System.out.print(BENEFITS_LIST);
        IntStream.range(0, domainEntityManager.getBenefitInfo().getBenefitsName().size())
                .forEach(i -> {
                    String benefitsName = domainEntityManager.getBenefitInfo().getBenefitsName().get(i);
                    int benefitsAmount = domainEntityManager.getBenefitInfo().getBenefitsAmounts().get(i);
                    System.out.printf("%s: -%d원\n", benefitsName, benefitsAmount);
                });
    }

    public void printTotalBenefits(){
        System.out.println(TOTAL_BENEFITS_AMOUNTS + String.format("-%d원"
                ,domainEntityManager.getBenefitInfo().getTotalBenefitsAmounts()));
    }

    public void printAfterDiscountsAmounts(){
        System.out.println(AFTER_DISCOUNTS_AMOUNTS + String.format("%d원"
                ,domainEntityManager.getBenefitInfo().getAfterDiscountAmounts()));

    }

    public void printEventBadge(){
        System.out.println(EVENT_BADGE + domainEntityManager.getEventBadge().getEventBadge());
    }

}
