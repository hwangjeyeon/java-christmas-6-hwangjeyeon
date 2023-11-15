package christmas.service;

import christmas.DomainEntityManager;

import java.text.DecimalFormat;
import java.util.stream.IntStream;

public class OutputService {
    private final String NONE = "없음";
    private final DomainEntityManager domainEntityManager;
    private final DecimalFormat decimalFormat;

    public OutputService(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
        this.decimalFormat = new DecimalFormat("#,###");
    }
    public String makeStringEventList(){
        String sb = "12월 " +
                domainEntityManager.getUserVisitDay().visitDay() +
                "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
        return sb;
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
                    orderMenu.append(menu).append(" ").append(counts).append("개\n");
                });
    }


    public String makeBeforeDiscounts(){
        int orderAmounts = domainEntityManager.getOrderInfo().getBeforeOrderAmount();

        return decimalFormat.format(orderAmounts) + "원\n";
    }

    public String makeGiftMenu(){
        StringBuilder menu = new StringBuilder(domainEntityManager.getGiftMenuInfo().getName());
        if(menu.toString().equals(NONE)){
            return NONE + "\n";
        }
        int counts = domainEntityManager.getGiftMenuInfo().getCounts();
        menu.append(" ");
        menu.append(counts);
        menu.append("개\n");

        return menu.toString();
    }

    public String makeBenefitsList(){
        StringBuilder benefitsList = new StringBuilder();
        benefitsListMake(benefitsList);
        if(benefitsList.isEmpty()){
            benefitsList.append(NONE).append("\n");
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
                        benefitsList.append(benefitsName).append(": -").append(decimalFormat.format(benefitsAmount)).append("원\n");
                    }
                });
    }

    public String makeTotalBenefits(){
        int benefits = domainEntityManager.getBenefitInfo().getTotalBenefitsAmounts();
        if(benefits == 0){
            return benefits + "원\n";
        }

        return "-" + decimalFormat.format(benefits) + "원\n";
    }

    public String makeAfterBenefits(){
        int afterBenefits = domainEntityManager.getBenefitInfo().getAfterDiscountAmounts();
        return decimalFormat.format(afterBenefits) + "원\n";
    }

    public String makeBadge(){
        return domainEntityManager.getEventBadge().getEventBadge();
    }

}
