package shitilei;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
@Component()
public class YhVo {
	private String yhid;
	private String name;
	private String pwd;
	private String zjhm;
	private Date zhucedate;
	private String roleid;
	private String rolename;
	private String permissionsid;
	private String permissionsname;
	private List<PermissionsVo> pv;
	public String getPermissionsid() {
		return permissionsid;
	}
	public void setPermissionsid(String permissionsid) {
		this.permissionsid = permissionsid;
	}
	public String getPermissionsname() {
		return permissionsname;
	}
	public void setPermissionsname(String permissionsname) {
		this.permissionsname = permissionsname;
	}
	public List<PermissionsVo> getPv() {
		return pv;
	}
	public void setPv(List<PermissionsVo> pv) {
		this.pv = pv;
	}
	public String getYhid() {
		return yhid;
	}
	public void setYhid(String yhid) {
		this.yhid = yhid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public Date getZhucedate() {
		return zhucedate;
	}
	public void setZhucedate(Date zhucedate) {
		this.zhucedate = zhucedate;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getPermissionid() {
		return permissionsid;
	}
	public void setPermissionid(String permissionid) {
		this.permissionsid = permissionid;
	}
	public String getPermissionname() {
		return permissionsname;
	}
	public void setPermissionname(String permissionname) {
		this.permissionsname = permissionname;
	}
	
}
