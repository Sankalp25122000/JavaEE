package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class UserDbUtil {
  DataSource dataSource;

  public UserDbUtil(DataSource dataSourse) {
    super();
    this.dataSource = dataSourse;
  }

  public List<User> listUsers() {

    Connection con = null;
    Statement stmt = null;
    ResultSet result = null;
    List<User> users = new ArrayList<>();

    try {
      con = dataSource.getConnection();
      String sql = "select * from user;";
      stmt = con.createStatement();
      result = stmt.executeQuery(sql);

      while (result.next()) {
        int user_id = result.getInt("user_id");
        String fname = result.getString("fname");
        String lname = result.getString("lname");
        String username = result.getString("username");
        String password = result.getString("password");
        double balance = result.getDouble("balance");

        users.add(new User(user_id, fname, lname, username, password, balance));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close(con, stmt, result);
    }
    return users;
  }

  public List<User> searchUser(int user_id) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet result = null;

    List<User> user = new ArrayList<>();
    try {
      conn = dataSource.getConnection();
      String sql = "select * from user where user_id like ? ;";
      String query = "%" + user_id + "%";
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, query);
      result = stmt.executeQuery();

      while (result.next()) {
        int user_id1 = result.getInt("user_id");
        String fname = result.getString("fname");
        String lname = result.getString("lname");
        String username = result.getString("username");
        String password = result.getString("password");
        int balance = result.getInt("balance");
        user.add(new User(user_id1, fname, lname, username, password, balance));

      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(conn, stmt, result);
    }
    return user;

  }

  public void addUser(User tempUser) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dataSource.getConnection();
      String sql = "insert into user (user_id,fname,lname,username,password,balance) values(?,?,?,?,?,?);";
      stmt = con.prepareStatement(sql);
      stmt.setInt(1, tempUser.getUserId());
      stmt.setString(2, tempUser.getFname());
      stmt.setString(3, tempUser.getLname());
      stmt.setString(4, tempUser.getUsername());
      stmt.setString(5, tempUser.getPassword());
      stmt.setInt(6, (int) tempUser.getBalance());
      stmt.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
   
  }

  public void deleteUser(int user_id) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      String sql = "delete from user where user_id=?;";
      con = dataSource.getConnection();
      stmt = con.prepareStatement(sql);
      stmt.setInt(1, user_id);
      stmt.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }



  public List<Transactions> searchPassbookUser(int acc_no) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet result = null;
    List<Transactions> transactions = new ArrayList<>();
    try {
      conn = dataSource.getConnection();
      String sql = "select * from transactions where transaction_id like ?;";
      String query = "%" + acc_no + "%";
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, query);
      result = stmt.executeQuery();
      while (result.next()) {
          int transactiondId= result.getInt("transaction_id");
          int accountNo = result.getInt("account_number");
          String transactionDate =result.getString("transaction_time");
          String transactionType = result.getString("transaction_type");
          int amount = result.getInt("amount");
        
          transactions.add(new Transactions(transactiondId, accountNo, transactionType, transactionDate, amount));
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        close(conn, stmt, result);
      }
      return transactions;
    }
    
    
    private void close(Connection con, Statement stmt, ResultSet result) {
      try {
        if (con != null) {
          con.close();
        }
        if (stmt != null) {
          stmt.close();
        }
        if (result != null) {
          result.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    
  }