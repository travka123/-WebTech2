package bsuir.webtech.lab3.server.business;

import bsuir.webtech.lab3.shared.AccessRights;

public class AuthorizationService {
    private final AccountService accountRepository;

    public AuthorizationService(AccountService accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccessRights tryAuthorizeUser(String username, String passwordHash) {
        Account account = accountRepository.getAccountByUsername(username);
        if (account == null) {
            return null;
        }

        if (!account.getPasswordHash().equals(passwordHash)) {
            return null;
        }

        return account.getAccessRights();
    }
}
