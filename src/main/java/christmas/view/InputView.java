package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_START_MENT = "안녕하세요! 우테코 식당 12월 이벤트 플레너입니다.\n";
    private static final String INPUT_VISIT_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private static final String INPUT_MENU_INFO = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public String inputVisitDay(){
        System.out.println(INPUT_START_MENT + INPUT_VISIT_DAY);
        String input = readLine();
        return input;
    }

    public String inputMenuInfo(){
        System.out.println(INPUT_MENU_INFO);
        String input = readLine();
        return input;
    }


}
