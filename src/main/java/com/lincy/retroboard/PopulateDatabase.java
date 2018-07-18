package com.lincy.retroboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Adam Linczmayer
 */

@Component
public class PopulateDatabase implements CommandLineRunner {

	private final UserRepository users;

	@Autowired
	public PopulateDatabase(UserRepository managerRepository) {

		this.users = managerRepository;
	}

	@Override
	public void run(String... strings) throws Exception {

		Users lincy = this.users.save(new Users("Lincy", "linci",
							"ROLE_MANAGER"));
		Users adam = this.users.save(new Users("Adam", "adam",
							"ROLE_MANAGER"));

		SecurityContextHolder.getContext().setAuthentication(
			new UsernamePasswordAuthenticationToken("Lincy", "nothing special",
				AuthorityUtils.createAuthorityList("ROLE_MANAGER")));

	/*	this.employees.save(new Employee("Frodo", "Baggins", "ring bearer", greg));
		this.employees.save(new Employee("Bilbo", "Baggins", "burglar", greg));
		this.employees.save(new Employee("Gandalf", "the Grey", "wizard", greg));*/

		SecurityContextHolder.getContext().setAuthentication(
			new UsernamePasswordAuthenticationToken("Adam", "nothing special",
				AuthorityUtils.createAuthorityList("ROLE_MANAGER")));

/*		this.employees.save(new Employee("Samwise", "Gamgee", "gardener", oliver));
		this.employees.save(new Employee("Merry", "Brandybuck", "pony rider", oliver));
		this.employees.save(new Employee("Peregrin", "Took", "pipe smoker", oliver));*/

		SecurityContextHolder.clearContext();
	}
}