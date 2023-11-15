package christmas;

import christmas.service.BusinessService;
import christmas.service.InputService;
import christmas.service.BasicService;
import christmas.service.OutputService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    private final BasicService basicService;
    private final InputView inputView;
    private final OutputView outputView;
    private final OutputService outputService;
    private final BusinessService businessService;
    private final DomainEntityManager domainEntityManager;
    private final InputService inputService;

    public Controller() {
        this.basicService = new BasicService();
        this.inputView = new InputView(basicService);
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
