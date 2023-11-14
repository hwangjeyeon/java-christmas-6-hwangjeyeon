package christmas;

import christmas.service.BusinessService;
import christmas.service.InputService;
import christmas.service.OutputService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Config {

    InputView inputView;
    InputService inputService;
    DomainEntityManager domainEntityManager;
    BusinessService businessService;
    OutputView outputView;
    OutputService outputService;

    public Config() {
        this.inputView = new InputView();
        this.inputService = new InputService(inputView);
        this.domainEntityManager =
                new DomainEntityManager(inputService.inputVisitDay(), inputService.inputMenu());
        this.businessService = new BusinessService(domainEntityManager);
        this.outputService = new OutputService(domainEntityManager);
        this.outputView = new OutputView(outputService);
    }
}
