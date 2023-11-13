package christmas;

import christmas.service.BusinessService;
import christmas.service.InputService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Config {

    InputView inputView;
    InputService inputService;
    DomainEntityManager domainEntityManager;
    BusinessService businessService;
    OutputView outputView;

    public Config() {
        this.inputView = new InputView();
        this.inputService = new InputService(inputView);
        this.domainEntityManager =
                new DomainEntityManager(inputService.inputVisitDay(), inputService.inputMenu());
        this.businessService = new BusinessService(domainEntityManager);
        this.outputView = new OutputView(domainEntityManager);
    }
}
