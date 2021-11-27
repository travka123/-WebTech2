package bsuir.webtech.lab4.business;

import bsuir.webtech.lab4.presentation.stubs.StubAccountRepository;

public class ServicesAccessPoint {
    private static final AuthorizationService authorizationService = new AuthorizationService(
            new StubAccountRepository(),
            new SaltShaker(60000)
    );

    public AuthorizationService getAuthorizationService() {
        return authorizationService;
    }
}
