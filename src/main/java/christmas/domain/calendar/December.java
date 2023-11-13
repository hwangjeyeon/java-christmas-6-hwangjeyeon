package christmas.domain.calendar;

import java.util.EnumSet;

public enum December {
    ONE(1,"주말",false),
    TWO(2,"주말",false),
    THREE(3,"평일", true),
    FOUR(4,"평일", false),
    FIVE(5, "평일", false),
    SIX(6, "평일", false),
    SEVEN(7, "평일", false),
    EIGHT(8, "주말", false),
    NINE(9, "주말", false),
    TEN(10, "평일", true),
    ELEVEN(11, "평일", false),
    TWELVE(12, "평일", false),
    THIRTEEN(13, "평일", false),
    FOURTEEN(14, "평일", false),
    FIFTEEN(15, "주말", false),
    SIXTEEN(16, "주말", false),
    SEVENTEEN(17, "평일", true),
    EIGHTEEN(18, "평일", false),
    NINETEEN(19, "평일", false),
    TWENTY(20, "평일", false),
    TWENTY_ONE(21, "평일", false),
    TWENTY_TWO(22, "주말", false),
    TWENTY_THREE(23, "주말", false),
    TWENTY_FOUR(24, "평일", true),
    TWENTY_FIVE(25, "평일", true),
    TWENTY_SIX(26, "평일", false),
    TWENTY_SEVEN(27, "평일", false),
    TWENTY_EIGHT(28, "평일", false),
    TWENTY_NINE(29, "주말", false),
    THIRTY(30, "주말", false),
    THIRTY_ONE(31, "평일", true);


    private final int day;
    private final String dayOfWeek;
    private final boolean star;

    December(int day, String dayOfWeek, boolean star) {
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.star = star;
    }

    public static String getDayOfWeekByDay(int day){
        return EnumSet.allOf(December.class).stream()
                .filter(December -> December.day==day)
                .findFirst()
                .map(December::getDayOfWeek)
                .orElse("없음");
    }


    public static boolean getStarByDay(int day){
        return Boolean.TRUE.equals(EnumSet.allOf(December.class).stream()
                .filter(December -> December.day == day)
                .findFirst()
                .map(December::isStar)
                .orElse(false));
    }


    public int getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isStar() {
        return star;
    }
}
