package christmas.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserBenefitInfo {

    private List<String> benefitsName;
    private List<Integer> benefitsAmounts;

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
}
