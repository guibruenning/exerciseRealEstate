package com.BO;

import com.DAO.AccountDAO;
import com.DTO.Account;

import java.util.List;

public class AccountBO {

    public void insert(Account account) {
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.insert(account);
    }

    public void update(Account account) {
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.update(account);
    }

    public void delete(Account account) {
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.delete(account);
    }

    public Account select(int id) {
        AccountDAO accountDAO = new AccountDAO();
        return accountDAO.selectId(id);
    }

    public List<Account> selectAll() {
        AccountDAO accountDAO = new AccountDAO();
        return accountDAO.selectAll();
    }

    public Account select(Account account) {
        AccountDAO accountDAO = new AccountDAO();
        return accountDAO.select(account);
    }

    public List<Account> selectAgency(int agency) {
        AccountDAO accountDAO = new AccountDAO();
        return accountDAO.selectAgency(agency);
    }

    public List<Account> selectBankNumber(int bank){
        AccountDAO accountDAO = new AccountDAO();
        return accountDAO.selectBankNumber(bank);
    }

    public List<Account> selectBankName(String bank) {
        AccountDAO accountDAO = new AccountDAO();
        return accountDAO.selectBankName(bank);
    }
}
