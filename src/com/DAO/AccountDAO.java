package com.DAO;

import com.DTO.Account;
import com.connection.ConnectionReal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// account bank

public class AccountDAO {

    final String NOMEDATABELA = "account";

    public void insert(Account account) {
        Connection conn = ConnectionReal.getConnection();
        String sql = "INSERT INTO " + NOMEDATABELA + " (agency, agencyDigit, accountNumber, accountNumberDigit, bankName, bankNumber, type) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAgency());
            ps.setInt(2, account.getAgencyDigit());
            ps.setInt(3, account.getAccountNumber());
            ps.setInt(4, account.getAccountNumberDigit());
            ps.setString(5, account.getBankName());
            ps.setInt(6, account.getBankNumber());
            ps.setString(7, account.getType());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account) {
        Connection conn = ConnectionReal.getConnection();
        String sql = "UPDATE " + NOMEDATABELA + " SET agency = ?, agencyDigit = ?, accountNumber = ?, accountNumberDigit = ?, bankName = ?, bankNumber = ?, type = ? WHERE idAccount = ?;";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAgency());
            ps.setInt(2, account.getAgencyDigit());
            ps.setInt(3, account.getAccountNumber());
            ps.setInt(4, account.getAccountNumberDigit());
            ps.setString(5, account.getBankName());
            ps.setInt(6, account.getBankNumber());
            ps.setString(7, account.getType());
            ps.setInt(8, account.getIdAccount());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Account account) {
        Connection conn = ConnectionReal.getConnection();
        String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idAccount = ?;";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getIdAccount());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> selectAll() {
        Connection conn = ConnectionReal.getConnection();
        String sql = "SELECT * FROM " + NOMEDATABELA + ";";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Account> accounts = new ArrayList<Account>();
            while(rs.next()) {
                Account account = new Account();
                account.setIdAccount(rs.getInt("idAccount"));
                account.setAgency(rs.getInt("agency"));
                account.setAgencyDigit(rs.getInt("agencyDigit"));
                account.setAccountNumber(rs.getInt("accountNumber"));
                account.setAccountNumberDigit(rs.getInt("accountNumberDigit"));
                account.setBankName(rs.getString("bankName"));
                account.setBankNumber(rs.getInt("bankNumber"));
                account.setType(rs.getString("type"));
                accounts.add(account);
            }

            rs.close();
            ps.close();
            conn.close();
            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    public Account selectId(int id) {
        Connection conn = ConnectionReal.getConnection();
        String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idAccount = ?;";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Account account = new Account();
            if(rs.next()) {
                account.setIdAccount(rs.getInt("idAccount"));
                account.setAgency(rs.getInt("agency"));
                account.setAgencyDigit(rs.getInt("agencyDigit"));
                account.setAccountNumber(rs.getInt("accountNumber"));
                account.setAccountNumberDigit(rs.getInt("accountNumberDigit"));
                account.setBankName(rs.getString("bankName"));
                account.setBankNumber(rs.getInt("bankNumber"));
                account.setType(rs.getString("type"));
            }

            rs.close();
            ps.close();
            conn.close();
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Account select(Account account){
        Connection conn = ConnectionReal.getConnection();
        String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE agency = ? AND agencyDigit = ? AND accountNumber = ? AND accountNumberDigit = ? AND bankName = ? AND bankNumber = ? AND type = ?;";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAgency());
            ps.setInt(2, account.getAgencyDigit());
            ps.setInt(3, account.getAccountNumber());
            ps.setInt(4, account.getAccountNumberDigit());
            ps.setString(5, account.getBankName());
            ps.setInt(6, account.getBankNumber());
            ps.setString(7, String.valueOf(account.getType()));
            ResultSet rs = ps.executeQuery();
            Account account1 = new Account();
            if(rs.next()) {
                account1.setIdAccount(rs.getInt("idAccount"));
                account1.setAgency(rs.getInt("agency"));
                account1.setAgencyDigit(rs.getInt("agencyDigit"));
                account1.setAccountNumber(rs.getInt("accountNumber"));
                account1.setAccountNumberDigit(rs.getInt("accountNumberDigit"));
                account1.setBankName(rs.getString("bankName"));
                account1.setBankNumber(rs.getInt("bankNumber"));
                account1.setType(rs.getString("type"));
            }

            rs.close();
            ps.close();
            conn.close();
            return account1;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Account> selectAgency(int agency) {
        Connection conn = ConnectionReal.getConnection();
        String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE agency = ?;";
        List<Account> accounts = new ArrayList<Account>();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, agency);
            ResultSet rs = ps.executeQuery();
            Account account = new Account();
            while(rs.next()) {
                account.setIdAccount(rs.getInt("idAccount"));
                account.setAgency(rs.getInt("agency"));
                account.setAgencyDigit(rs.getInt("agencyDigit"));
                account.setAccountNumber(rs.getInt("accountNumber"));
                account.setAccountNumberDigit(rs.getInt("accountNumberDigit"));
                account.setBankName(rs.getString("bankName"));
                account.setBankNumber(rs.getInt("bankNumber"));
                account.setType(rs.getString("type"));
            }

            rs.close();
            ps.close();
            conn.close();
            accounts.add(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public List<Account> selectBankNumber(int bank){
        Connection conn = ConnectionReal.getConnection();
        String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE bankNumber = ?;";
        List<Account> accounts = new ArrayList<Account>();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bank);
            ResultSet rs = ps.executeQuery();
            Account account = new Account();
            while(rs.next()) {
                account.setIdAccount(rs.getInt("idAccount"));
                account.setAgency(rs.getInt("agency"));
                account.setAgencyDigit(rs.getInt("agencyDigit"));
                account.setAccountNumber(rs.getInt("accountNumber"));
                account.setAccountNumberDigit(rs.getInt("accountNumberDigit"));
                account.setBankName(rs.getString("bankName"));
                account.setBankNumber(rs.getInt("bankNumber"));
                account.setType(rs.getString("type"));
            }

            rs.close();
            ps.close();
            conn.close();
            accounts.add(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public List<Account> selectBankName(String bank) {
        Connection conn = ConnectionReal.getConnection();
        String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE bankName = ?;";
        List<Account> accounts = new ArrayList<Account>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bank);
            ResultSet rs = ps.executeQuery();
            Account account = new Account();
            while (rs.next()) {
                account.setIdAccount(rs.getInt("idAccount"));
                account.setAgency(rs.getInt("agency"));
                account.setAgencyDigit(rs.getInt("agencyDigit"));
                account.setAccountNumber(rs.getInt("accountNumber"));
                account.setAccountNumberDigit(rs.getInt("accountNumberDigit"));
                account.setBankName(rs.getString("bankName"));
                account.setBankNumber(rs.getInt("bankNumber"));
                account.setType(rs.getString("type"));
            }

            rs.close();
            ps.close();
            conn.close();
            accounts.add(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }
}
