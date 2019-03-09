package shitilei;

import org.springframework.stereotype.Component;

@Component
public class TongjiVo {
	private String zhucedate;
	private Integer nums;//接收count数量用interger
	public String getZhucedate() {
		return zhucedate;
	}
	public void setZhucedate(String zhucedate) {
		this.zhucedate = zhucedate;
	}
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
	}

}
