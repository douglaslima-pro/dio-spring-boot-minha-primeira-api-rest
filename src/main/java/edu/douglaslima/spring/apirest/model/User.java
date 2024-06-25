package edu.douglaslima.spring.apirest.model;

public class User {
	
	private static Long SEQUENCE = 0L;
	
	private Long id;
	private String login;
	private String password;
	
	public User(String login, String password) {
		this.id = ++SEQUENCE;
		this.login = login;
		this.password = password;
	}

	@Override
	public String toString() {
		return "\"User\": {\n"
				+ "\t\"id\": \"" + id + "\",\n"
				+ "\t\"login\": \"" + login + "\",\n"
				+ "\t\"password\": \"" + password + "\"\n"
				+ "}";
	}

	public Long getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
