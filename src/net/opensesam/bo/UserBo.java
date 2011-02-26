package net.opensesam.bo;

import net.opensesam.entity.*;

public interface UserBo {

  User findById(int id);

  void insert(User user);

  void complexTransaction(User user);
  
  Email getPrimaryEmail(User user);
  
}