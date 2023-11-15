package christmas;

import christmas.domain.DomainEntityManager;
import christmas.service.BusinessService;
import christmas.service.InputService;
import christmas.service.OutputService;
import christmas.view.InputView;
import christmas.view.OutputView;


/**
 *  주어진 출력문 형식에 맞추기 위해 BasicService는 주석 처리했습니다 -> 이러한 기능이 출력문에 추가되면 좋을 것 같아 만들었습니다.
 */
public class Controller {
    //private final BasicService basicService;
    private final InputView inputView;
    private final OutputView outputView;
    private final OutputService outputService;
    private final BusinessService businessService;
    private final DomainEntityManager domainEntityManager;
    private final InputService inputService;

    public Controller() {
        //this.basicService = new BasicService();
        this.inputView = new InputView(/*basicService*/);
        this.inputService = new InputService(inputView);
        this.domainEntityManager = new DomainEntityManager(inputService.inputVisitDay(), inputService.inputMenu());
        this.businessService = new BusinessService(domainEntityManager);
        this.outputService = new OutputService(domainEntityManager);
        this.outputView = new OutputView(outputService);
    }

    public void controllerRun(){
        businessService.BusinessServiceProgress();
        outputView.printEventBenefitsList();
    }

}
