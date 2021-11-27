package bsuir.webtech.lab4.business;

import java.security.NoSuchAlgorithmException;

public class AuthorizationService {
    private final AccountsRepository accountsRepository;
    private final SaltShaker saltShaker;

    public AuthorizationService(AccountsRepository accountsRepository, SaltShaker saltShaker) {
        this.accountsRepository = accountsRepository;
        this.saltShaker = saltShaker;
    }

    public String createSalt() {
        return saltShaker.createSalt();
    }

    public boolean tryAuthorize(UserSession userSession, String email, String passwordSaltHash, String salt) {

        if (!saltShaker.tryUse(salt)) {
            return false;
        }

        Account account = accountsRepository.getAccountBy(email);
        if (account == null) {
            return false;
        }

        try {
            if (!passwordSaltHash.equals(Cryptography.getHash(account.getPassHash() + salt))) {
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            return false;
        }

        userSession.setUserId(account.getId());
        return true;
    }
}
