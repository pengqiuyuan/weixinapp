package com.weixin.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * 操作用户，适用于Security的身份标识.
 * @author 
 *
 */
@Entity
@javax.persistence.Table(name="t_users")
@org.hibernate.annotations.Table(appliesTo="t_users", indexes = { @Index(name="idx_users_name", columnNames = { "login_name" } ) } )
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 内部编号
	 */
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/**
	 * 登录名
	 */
	@Column(name = "login_name")
	private String loginName;
	/**
	 * 密码
	 */
	@Column(name = "password")
	private String password;
	/**
	 * 性别
	 */
	@Column(name = "sex")
	private String sex;
	/**
	 * 职务 
	 */
	@Column(name = "title")
	private String title;
	/**
	 * 部门
	 */
	@Column(name = "department")
	private String department;
	/**
	 * 电话
	 */
	@Column(name = "tel")
	private String tel;
	/**
	 * 邮箱
	 */
	@Column(name = "email")
	private String email;
	/**
	 * 手机号
	 */
	@Column(name = "mobile")
	private String mobile;
	/**
	 * 创建日期
	 */
	@Column(name = "crt_date")
	private Date crtDate;
	/**
	 * 更新日期
	 */
	@Column(name = "upt_date")
	private Date uptDate;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade={})
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "t_user_roles", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<Role> roles;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getCrtDate() {
		return crtDate;
	}
	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}
	public Date getUptDate() {
		return uptDate;
	}
	public void setUptDate(Date uptDate) {
		this.uptDate = uptDate;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	@Deprecated
	public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(getRoles().size());
        for (Role role : getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
	}
	
}
