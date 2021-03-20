package com.app.entity;

import javax.persistence.Entity;

@Entity
public class Admin extends BaseEntity {
//	@Autowired
//	UserRepository userDao;
//	@Autowired
//	RoleRepository roleDao;
	
	private String adminName;
	private String password;
	
	public Admin() {
		System.out.println("Admin constructor");
		
//		if(!userDao.existsByEmail("admin@admin.com")) {
//			User admin = new User("admin", "admin@admin.com", "admin");
//			Role role = new Role(ERole.ADMIN);
//			roleDao.save(role);
//			admin.getRoles().add(role);
//			userDao.save(admin);
//		}
		
		
		
		
		
	}

	public Admin(String adminName, String password) {
		super();
		this.adminName = adminName;
		this.password = password;
	}
	 
	//setters and getters
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + "]";
	}

	
	
	
}
