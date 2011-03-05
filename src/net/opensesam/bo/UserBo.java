package net.opensesam.bo;

import net.opensesam.entity.Email;
import net.opensesam.entity.User;

public interface UserBo {

    User findById(int id);

    void insert(User user);

    void complexTransaction(User user);

    Email getPrimaryEmail(User user);

}