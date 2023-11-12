package christmas.domain.User;

import java.util.List;

public class UserBenefitInfo {

    private List<String> benefitsName;
    private List<Integer> benefitsAmounts;

    private int totalBenefitsAmounts;
    private int afterDiscountAmounts;


    public UserBenefitInfo(List<String> benefitsName, List<Integer> benefitsAmounts) {
        this.benefitsName = benefitsName;
        this.benefitsAmounts = benefitsAmounts;
    }



}
