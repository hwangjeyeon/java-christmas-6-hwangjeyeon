package christmas.service;

import christmas.domain.User.UserOrderInfo;
import christmas.domain.User.UserVisitDay;
import christmas.view.InputView;

public class InputService {

    private final InputView inputView;

    public InputService(InputView view) {
        this.inputView = view;
    }

    public UserVisitDay inputVisitDay() {
        String day = inputView.inputVisitDay();
        //TODO: 검증 로직 추가 필요

        return new UserVisitDay(Integer.parseInt(day));
    }

    public UserOrderInfo inputMenu(){
        String menuInfo = inputView.inputMenuInfo();
        //TODO: 검증 로직 추가 필요

        return new UserOrderInfo(menuInfo);
    }


}
