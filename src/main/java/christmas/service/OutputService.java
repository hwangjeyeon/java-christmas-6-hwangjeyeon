package christmas.service;

import christmas.DomainEntityManager;
import christmas.domain.menu.MenuInfo;

import java.text.DecimalFormat;
import java.util.EnumSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputService {
    private final String NONE = "없음";
    private final DomainEntityManager domainEntityManager;

    public OutputService(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }
    public String makeStringEventList(){
        String sb = "12월 " +
                domainEntityManager.getUserVisitDay().getVisitDay() +
                "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
        return sb;
    }



    public String makeOrderMenuList(){
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, domainEntityManager.getUserOrderInfo().getMenu().size())
                .forEach(i -> {
                    String menu = domainEntityManager.getUserOrderInfo().getMenu().get(i);
                    int counts = domainEntityManager.getUserOrderInfo().getCounts().get(i);
                    sb.append(menu).append(" ").append(counts).append("개\n");
                });

        return sb.toString();
    }


    public String makeBeforeDiscounts(){
        int orderAmounts = domainEntityManager.getOrderInfo().getBeforeOrderAmount();


        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        StringBuilder sb = new StringBuilder(decimalFormat.format(orderAmounts)).append("원\n");
        return sb.toString();
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
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, domainEntityManager.getBenefitInfo().getBenefitsName().size())
                .forEach(i -> {
                    String benefitsName = domainEntityManager.getBenefitInfo().getBenefitsName().get(i);
                    int benefitsAmount = domainEntityManager.getBenefitInfo().getBenefitsAmounts().get(i);
                    DecimalFormat decimalFormat = new DecimalFormat("#,###");
                    if(!benefitsName.equals(NONE) || benefitsAmount != 0){
                        sb.append(benefitsName).append(": -").append(decimalFormat.format(benefitsAmount)).append("원\n");
                    }
                });
        if(sb.isEmpty()){
            sb.append(NONE).append("\n");
        }
        return sb.toString();
    }

    public String makeTotalBenefits(){
        int benefits = domainEntityManager.getBenefitInfo().getTotalBenefitsAmounts();
        if(benefits == 0){
            return benefits + "원\n";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        StringBuilder sb = new StringBuilder("-")
                        .append(decimalFormat.format(benefits))
                        .append("원\n");

        return sb.toString();
    }

    public String makeAfterBenefits(){
        int afterBenefits = domainEntityManager.getBenefitInfo().getAfterDiscountAmounts();
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        StringBuilder sb = new StringBuilder(decimalFormat.format(afterBenefits)).append("원\n");
        return sb.toString();
    }

    public String makeBadge(){
        return domainEntityManager.getEventBadge().getEventBadge();
    }

}
