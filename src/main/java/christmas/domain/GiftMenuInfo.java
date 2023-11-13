package christmas.domain;

import christmas.domain.menu.MenuInfo;

public class GiftMenuInfo {

    private String name;
    private int counts;
    private int price;


    public void setGiftMenuPrice(){
        price = MenuInfo.getPriceByName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public String getName() {
        return name;
    }

    public int getCounts() {
        return counts;
    }

    public int getPrice() {
        return price;
    }
}
