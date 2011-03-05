package net.opensesam.dao;

import net.opensesam.entity.Email;
import net.opensesam.entity.User;
import org.hibernate.SessionFactory;

public class UserDao extends AbstractDao<User> {
    public UserDao(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }

    public Email getFirstEmail(int userId) {
        Email email = (Email) query(
                "select email from Email email join email.users u where u.id = ?")
                .setInteger(0, userId).setMaxResults(1).uniqueResult();

        return email;
    }
}
