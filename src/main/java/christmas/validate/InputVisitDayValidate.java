package christmas.validate;

public class InputVisitDayValidate {
    private final String PREFIX = "[ERROR] ";
    private final String SUFFIX = "다시 입력해주세요.\n";
    private final String day;

    public InputVisitDayValidate(String day) {
        this.day = day;
    }

    public String validate(){
        numberValidate();
        rangeValidate();
        return day;
    }

    public void numberValidate(){
        try{
            Integer.parseInt(day);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(PREFIX + "정수형 숫자로 입력하세요. " + SUFFIX);
        }
    }

    public void rangeValidate(){
        int intDay = Integer.parseInt(day);
        if(intDay < 1 || intDay > 31){
            throw new IllegalArgumentException(PREFIX + "유효하지 않은 날짜입니다. " + SUFFIX);
        }
    }


}
