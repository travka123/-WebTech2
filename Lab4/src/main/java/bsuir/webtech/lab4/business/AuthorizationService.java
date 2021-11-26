package bsuir.webtech.lab4.business;

import java.security.NoSuchAlgorithmException;

public class AuthorizationService {
    private final AccountsRepository accountsRepository;
    private final SaltsRepository saltsRepository;

    public AuthorizationService(AccountsRepository accountsRepository, SaltsRepository saltsRepository) {
        this.accountsRepository = accountsRepository;
        this.saltsRepository = saltsRepository;
    }

    public String createSalt() {
        return saltsRepository.createSalt();
    }

    public boolean tryAuthorize(UserSession userSession, String email, String passwordSaltHash, String salt) {

        if (!saltsRepository.tryUse(salt)) {
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

        //userSession.setUserId(account.getId());
        return true;
    }
}
