package com.entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id; //编号
    private Long organizationId; //所属机构
    private String organizationName; //机构名称
    private String username; //用户名
    private String password; //密码
    private String salt; //加密密码的盐
    private Long roleId; //拥有的角色列表
    private String roleName;
    private Long userCategory;//0:超级管理员  1:作者
    private String realname;
    private String phone;
    private String email;
    private Boolean locked = Boolean.FALSE;
    private String token;
    private String shortname; //用于登录登出设置

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(Long userCategory) {
		this.userCategory = userCategory;
	}

	public String getCredentialsSalt() {
        return username + salt;
    }
	
    public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
    
    public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", organizationId=" + organizationId + ", organizationName=" + organizationName
				+ ", username=" + username + ", password=" + password + ", salt=" + salt + ", roleId=" + roleId
				+ ", roleName=" + roleName + ", userCategory=" + userCategory + ", realname=" + realname + ", phone="
				+ phone + ", email=" + email + ", locked=" + locked + ", token=" + token + ", shortname=" + shortname
				+ "]";
	}
	
}

