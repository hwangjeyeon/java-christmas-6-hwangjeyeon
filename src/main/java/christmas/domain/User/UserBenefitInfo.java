package christmas.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserBenefitInfo {

    private final List<String> benefitsName;
    private final List<Integer> benefitsAmounts;

    private int totalBenefitsAmounts;
    private int afterDiscountAmounts;

    public UserBenefitInfo(){
        benefitsName = new ArrayList<>();
        benefitsAmounts = new ArrayList<>();
    }


    public void addBenefitsListInfo(String benefitsName, int benefitsAmounts){
        this.benefitsName.add(benefitsName);
        this.benefitsAmounts.add(benefitsAmounts);
    }

    public List<String> getBenefitsName() {
        return benefitsName;
    }

    public List<Integer> getBenefitsAmounts() {
        return benefitsAmounts;
    }

    public void setTotalBenefitsAmounts(int totalBenefitsAmounts) {
        this.totalBenefitsAmounts = totalBenefitsAmounts;
    }

    public void setAfterDiscountAmounts(int afterDiscountAmounts) {
        this.afterDiscountAmounts = afterDiscountAmounts;
    }

    public int getTotalBenefitsAmounts() {
        return totalBenefitsAmounts;
    }

    public int getAfterDiscountAmounts() {
        return afterDiscountAmounts;
    }
}
