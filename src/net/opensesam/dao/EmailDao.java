package net.opensesam.dao;

import net.opensesam.entity.Email;
import org.hibernate.SessionFactory;

public class EmailDao extends AbstractDao<Email> {
	public EmailDao(SessionFactory sessionFactory) {
		super(Email.class, sessionFactory);
	}
}