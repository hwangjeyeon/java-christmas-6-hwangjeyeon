package christmas.service;

import christmas.domain.User.UserOrderInfo;
import christmas.domain.User.UserVisitDay;
import christmas.view.InputView;

public class InputService {

    private final InputView inputView;

    public InputService(InputView view) {
        this.inputView = view;
        InputVisitDay();
        InputMenu();
    }

    public void InputVisitDay() {
        String day = inputView.inputVisitDay();
        //TODO: 검증 로직 추가 필요

        UserVisitDay userVisitDay = new UserVisitDay(Integer.parseInt(day));
    }

    public void InputMenu(){
        String menuInfo = inputView.inputMenuInfo();
        //TODO: 검증 로직 추가 필요

        UserOrderInfo userOrderInfo = new UserOrderInfo(menuInfo);
    }

}
