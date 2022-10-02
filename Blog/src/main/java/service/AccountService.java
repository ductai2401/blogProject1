package service;

import model.Account;

public interface AccountService {
    public Account checkLogin(String username, String password);
    public void signUp(String username, String password);
    public Account checkExistAccount(String username);
}
