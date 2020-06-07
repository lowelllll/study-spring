package config;

import java.util.List;
import java.util.Map;

public class DatabaseConfig {
	
	private String url;
	private String user;
	private String password;
	
	private List<String> names;
	
	private Map<String, Long> info;
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void print() {
		 System.out.printf("url: %s, user: %s, password: %s", url, user, password);
		 System.out.println();
		System.out.println("names: " + names);
		System.out.println("info: " + info);
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public void setInfo(Map<String, Long> info) {
		this.info = info;
	}
}
