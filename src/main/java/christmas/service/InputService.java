package christmas.service;

import christmas.domain.User.UserOrderInfo;
import christmas.domain.User.UserVisitDay;
import christmas.validate.InputMenuValidate;
import christmas.validate.InputVisitDayValidate;
import christmas.view.InputView;


/**
 *  주어진 출력문 형식에 맞추기 위해 BasicService는 주석 처리했습니다 -> 이러한 기능이 출력문에 추가되면 좋을 것 같아 만들었습니다.
 */
public class InputService {

    private final InputView inputView;


    public InputService(InputView view) {
        this.inputView = view;
    }

    public UserVisitDay inputVisitDay() {
        try {
            InputVisitDayValidate inputVisitDayValidate = new InputVisitDayValidate(inputView.inputVisitDay());
            String day = inputVisitDayValidate.validate();
            //basicInfoService();
            return new UserVisitDay(Integer.parseInt(day));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputVisitDay();
        }
    }

    /*private void basicInfoService() {
        inputView.basicInfoMenuList();
        inputView.basicClientCautionInfo();
    }*/


    public UserOrderInfo inputMenu(){
        try{
            InputMenuValidate inputMenuValidate = new InputMenuValidate(inputView.inputMenuInfo());
            String menu = inputMenuValidate.validate();
            return new UserOrderInfo(menu);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputMenu();
        }
    }


}
