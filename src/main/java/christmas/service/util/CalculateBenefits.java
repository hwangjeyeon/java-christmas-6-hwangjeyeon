package christmas.service.util;

import christmas.DomainEntityManager;

import java.util.List;

public class CalculateBenefits {

    private final DomainEntityManager domainEntityManager;

    public CalculateBenefits(DomainEntityManager domainEntityManager) {
        this.domainEntityManager = domainEntityManager;
    }

    public void calculateBenefits(){
        List<Integer> benefits = domainEntityManager.getBenefitInfo().getBenefitsAmounts();
        int benefitsAmount = benefits.stream()
                            .mapToInt(Integer::intValue)
                            .sum();
        domainEntityManager.getBenefitInfo().setTotalBenefitsAmounts(benefitsAmount);
    }

    public void calculateAfterDiscounts(){
       int totalBenefitsAmounts = domainEntityManager.getOrderInfo().getBeforeOrderAmount()
               - domainEntityManager.getBenefitInfo().getTotalBenefitsAmounts()
               + domainEntityManager.getGiftMenuInfo().getPrice();
       domainEntityManager.getBenefitInfo().setAfterDiscountAmounts(totalBenefitsAmounts);
    }
}
