package christmas.service;

import christmas.domain.User.UserOrderInfo;
import christmas.domain.User.UserVisitDay;
import christmas.domain.menu.MenuInfo;
import christmas.validate.InputMenuValidate;
import christmas.validate.InputVisitDayValidate;
import christmas.view.InputView;

import java.util.EnumSet;
import java.util.stream.Collectors;

public class InputService {

    private final InputView inputView;


    public InputService(InputView view) {
        this.inputView = view;
    }

    public UserVisitDay inputVisitDay() {
        try {
            InputVisitDayValidate inputVisitDayValidate
                    = new InputVisitDayValidate(inputView.inputVisitDay());
            String day = inputVisitDayValidate.validate();
            basicInfoService();
            return new UserVisitDay(Integer.parseInt(day));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputVisitDay();
        }
    }

    private void basicInfoService() {
        inputView.basicInfoMenuList();
        inputView.basicClientCautionInfo();
    }


    public UserOrderInfo inputMenu(){
        try{
            InputMenuValidate inputMenuValidate
                    = new InputMenuValidate(inputView.inputMenuInfo());
            String menu = inputMenuValidate.validate();
            return new UserOrderInfo(menu);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputMenu();
        }
    }


}
