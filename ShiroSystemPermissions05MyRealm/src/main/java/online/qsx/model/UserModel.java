package online.qsx.model;

public class UserModel {
	private Long id;
	private String userName;
	private String password;
	private Long role_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public UserModel(String userName) {
		super();
		this.userName = userName;
	}

	public UserModel() {
		super();
	}

}
