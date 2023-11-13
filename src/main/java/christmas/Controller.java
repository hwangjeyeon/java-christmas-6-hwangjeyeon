package christmas;

import christmas.service.BusinessService;
import christmas.service.InputService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BusinessService businessService;
    private final DomainEntityManager domainEntityManager;
    private final InputService inputService;

    public Controller(Config config) {
        this.inputView = config.inputView;
        this.inputService = config.inputService;
        this.domainEntityManager = config.domainEntityManager;
        this.businessService = config.businessService;
        this.outputView = config.outputView;
    }

    public void controllerRun(){
        businessService.BusinessServiceProgress();
        outputView.printEventBenefitsList();
    }

}
