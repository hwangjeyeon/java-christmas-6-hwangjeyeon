package christmas.service;

import christmas.domain.DomainEntityManager;

import java.text.DecimalFormat;
import java.util.stream.IntStream;

public class OutputService {
    private static final String NONE = "없음";
    private static final String WON = "원\n";
    private static final String UNIT = "개\n";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String MONTH = "12월 ";
    private static final String PREVIEW = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private final DomainEntityManager domainEntityManager;
    private final DecimalFormat decimalFormat;

    public OutputService(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
        this.decimalFormat = new DecimalFormat("#,###");
    }
    public String makeStringEventList(){
        return MONTH + domainEntityManager.getUserVisitDay().visitDay() + PREVIEW;
    }



    public String makeOrderMenuList(){
        StringBuilder orderMenu = new StringBuilder();
        orderMenuListMake(orderMenu);

        return orderMenu.toString();
    }

    private void orderMenuListMake(StringBuilder orderMenu) {
        IntStream.range(0, domainEntityManager.getUserOrderInfo().getMenu().size())
                .forEach(i -> {
                    String menu = domainEntityManager.getUserOrderInfo().getMenu().get(i);
                    int counts = domainEntityManager.getUserOrderInfo().getCounts().get(i);
                    orderMenu.append(menu).append(" ").append(counts).append(UNIT);
                });
    }


    public String makeBeforeDiscounts(){
        int orderAmounts = domainEntityManager.getOrderInfo().getBeforeOrderAmount();

        return decimalFormat.format(orderAmounts) + WON;
    }

    public String makeGiftMenu(){
        StringBuilder menu = new StringBuilder(domainEntityManager.getGiftMenuInfo().getName());
        if(menu.toString().equals(NONE)){
            return NONE + LINE_SEPARATOR;
        }
        int counts = domainEntityManager.getGiftMenuInfo().getCounts();
        menu.append(" ").append(counts).append(UNIT);

        return menu.toString();
    }

    public String makeBenefitsList(){
        StringBuilder benefitsList = new StringBuilder();
        benefitsListMake(benefitsList);
        if(benefitsList.isEmpty()){
            benefitsList.append(NONE).append(LINE_SEPARATOR);
        }
        return benefitsList.toString();
    }

    private void benefitsListMake(StringBuilder benefitsList) {
        IntStream.range(0, domainEntityManager.getBenefitInfo().getBenefitsName().size())
                .forEach(i -> {
                    String benefitsName = domainEntityManager.getBenefitInfo().getBenefitsName().get(i);
                    int benefitsAmount = domainEntityManager.getBenefitInfo().getBenefitsAmounts().get(i);
                    DecimalFormat decimalFormat = new DecimalFormat("#,###");
                    if(!benefitsName.equals(NONE) || benefitsAmount != 0){
                        benefitsList.append(benefitsName).append(": -").
                                append(decimalFormat.format(benefitsAmount)).append(WON);
                    }
                });
    }

    public String makeTotalBenefits(){
        int benefits = domainEntityManager.getBenefitInfo().getTotalBenefitsAmounts();
        if(benefits == 0){
            return benefits + WON;
        }

        return "-" + decimalFormat.format(benefits) + WON;
    }

    public String makeAfterBenefits(){
        int afterBenefits = domainEntityManager.getBenefitInfo().getAfterDiscountAmounts();
        return decimalFormat.format(afterBenefits) + WON;
    }

    public String makeBadge(){
        return domainEntityManager.getEventBadge().getEventBadge();
    }

}
