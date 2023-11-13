package christmas.domain.menu;


import java.util.EnumSet;

public enum MenuInfo {
    MUSHROOM_CREAM_SOUP("양송이수프", 6000,Category.APPETIZER),
    TAPAS("타파스", 5500, Category.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, Category.APPETIZER),
    TBON_STEAK("티본스테이크",55000,Category.MAIN),
    BBQ_RIB("바비큐립", 54000, Category.MAIN),
    SEAFOOD_SPAGHETTI("해산물파스타", 35000, Category.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타",25000, Category.MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, Category.DESSERT),
    ICE_CREAM("아이스크림", 5000, Category.DESSERT),
    ZERO("제로콜라", 3000, Category.BEVERAGE),
    RED_WINE("레드와인", 60000, Category.BEVERAGE),
    CHAMPAGNE("샴페인", 25000, Category.BEVERAGE);

    private final String name;
    private final int price;
    private final Category category;

    MenuInfo(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }


    public static Integer getPriceByName(String name) {
        return EnumSet.allOf(MenuInfo.class).stream()
                .filter(menuInfo -> menuInfo.name.equals(name))
                .findFirst()
                .map(MenuInfo::getPrice)
                .orElse(0);
    }

    public static Category getCategoryByName(String name){
        return EnumSet.allOf(MenuInfo.class).stream()
                .filter(menuInfo -> menuInfo.name.equals(name))
                .findFirst()
                .map(MenuInfo::getCategory)
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
