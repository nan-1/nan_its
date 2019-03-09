package shitilei;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component()
public class Yh {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String name;
	private String pwd;
	private String zjhm;
	private Date zhucedate;

	public Date getZhucedate() {
		return zhucedate;
	}

	public void setZhucedate(Date zhucedate) {
		this.zhucedate = zhucedate;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
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
}
