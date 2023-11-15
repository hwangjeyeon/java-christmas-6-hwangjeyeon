package christmas.view;

import christmas.service.BasicService;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private final BasicService basicService;
    private static final String INPUT_START_MENT = "안녕하세요! 우테코 식당 12월 이벤트 플레너입니다.\n";
    private static final String INPUT_VISIT_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private static final String INPUT_MENU_INFO = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String MENU_INFO_LIST = "[사랑하는 고객님! 메뉴 정보는 다음과 같습니다!]\n";

    public InputView(BasicService basicService) {
        this.basicService = basicService;
    }

    public String inputVisitDay(){
        System.out.println(INPUT_START_MENT + INPUT_VISIT_DAY);
        return readLine();
    }

    public void basicInfoMenuList(){
        System.out.println(MENU_INFO_LIST + basicService.menuInfoList());
    }

    public void basicClientCautionInfo(){
        System.out.println(basicService.clientCautionInfo());
    }

    public String inputMenuInfo(){
        System.out.println(INPUT_MENU_INFO);
        return readLine();
    }


}
