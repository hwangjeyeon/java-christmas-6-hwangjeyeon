package christmas.domain.menu;

public enum Category {
    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGE("음료");

    private final String message;

    Category(String message) {
        this.message = message;

    }
}
