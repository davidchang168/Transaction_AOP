package net.opensesam.bo;

import net.opensesam.dao.EmailDao;
import net.opensesam.dao.UserDao;
import net.opensesam.entity.Email;
import net.opensesam.entity.User;

public class UserBoImpl implements UserBo {
	UserDao userDao;
	EmailDao emailDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	@Override
	public User findById(int id) {
		return userDao.get(id);
	}

	@Override
	public Email getPrimaryEmail(User user) {
		return userDao.getFirstEmail(user.getId());
	}

	@Override
	public void insert(User user) {
		for (Email e : user.getEmails()) {
			emailDao.save(e);
		}
		userDao.save(user);
	}

	public void complexTransaction(User user) {
		User u = findById(user.getId());
		// update all user's email addresses
		for (Email e : u.getEmails()) {
			e.setAddress(e.getAddress() + ".new");
		}
		// If exception is thrown, no changes should be persisted in DB
		/*
		 * if (true) { throw new RuntimeException("Ouch, an exception!"); }
		 */
		// update user's age
		u.setAge(u.getAge() + 100);
	}

}