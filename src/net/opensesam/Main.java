package net.opensesam;

import java.util.HashSet;
import java.util.Set;

import net.opensesam.bo.UserBo;
import net.opensesam.entity.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class Main {

	public static void main(final String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"net/opensesam/beans.xml");

		// add new user
		User newUser = new User();
		newUser.setAge(63);

		// with 2 new email addresses
		Email e1 = new Email();
		e1.setAddress("newemail1@opensesam.net");
		Email e2 = new Email();
		e2.setAddress("newemail2@opensesam.net");

		Set<Email> emails = new HashSet<Email>();
		emails.add(e1);
		emails.add(e2);
		newUser.setEmails(emails);

		UserBo userBo = (UserBo) ctx.getBean("userBo");
		userBo.insert(newUser);

		// retrieve a user
		User u = userBo.findById(1);

		// and it's primary email address
		Email e = userBo.getPrimaryEmail(u);
		System.out.println(e.getAddress());

		// run "complex transaction" on user
		userBo.complexTransaction(u);
	}
}