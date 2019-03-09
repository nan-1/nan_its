package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.RpyService;
import service.YhService;
import service.serviceImpl.YhServiceImpl;
import shitilei.Yh;
import shitilei.YhVo;

import com.google.gson.JsonObject;

@Controller
@RequestMapping("/ccc")
public class NewC {
	@Autowired
	private RpyService rpyservice;
	@Autowired
	private YhService yhservice;
	@Autowired
	private Yh yh;
	public Yh getYh() {
		return yh;
	}

	@Autowired
	public void setYh(Yh yh) {
		this.yh = yh;
	}
	@Autowired
	private YhVo yhvo;
	public YhVo getYhvo() {
		return yhvo;
	}


	// modelandview
	@RequestMapping("/modelandv")
	public ModelAndView mav(
			@RequestParam(value = "text", required = false) String text,
			@RequestParam(value = "tel", required = false) String t) {
		System.out.println(text + "---" + t);
		ModelAndView ma = new ModelAndView();
		ma.setViewName("show");
		text = "nan";
		String str = "aaas";
		List<String> li = new ArrayList<String>();
		li.add("aaa");
		li.add("bb");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("wo", "www");
		ma.addObject("text", text);
		ma.addObject("list", li);
		ma.addObject("map", map);
		ma.addObject("str", str);
		return ma;
	}

	@RequestMapping("/modelonly")
	public String denglu(HttpServletRequest request, Model model) {
		String text = "用户名或密码不正确";
		// model.addAttribute("key", key);
		// 此时没有定义变量的名字，默认就用这个参数的类型的名字做为变量的名字，不过首字母大写变小写
		// model.addAttribute("xxxxxxx");
		String dengluname = request.getParameter("dengluname");
		String denglupwd = request.getParameter("denglupwd");
		System.out.println(dengluname + "+" + denglupwd);
		yh = yhservice.getYhbyname(dengluname);
		System.out.println(yh);
		if (yh != null) {
			System.out.println(yh + "==" + yh.getName() + "==" + yh.getPwd());
			if (yh.getName().equals(dengluname) && yh.getPwd().equals(denglupwd)) {
				System.out.println(yh.getId());
//				List<YhVo> yhvolist=rpyservice.juesequanxian(yh.getId());
				yhvo.setPv(rpyservice.juesequanxian(yh.getId()));
				yhvo.setYhid(yh.getId());
				model.addAttribute("yhvo", yhvo);
				//session加入登录name
				request.getSession().setAttribute("name", dengluname);
				return "lailalaodi";
			} else {
				model.addAttribute("text", text);
				return "denglu";
			}
		} else {
			model.addAttribute("text", text);
			return "denglu";
		}
	}

	@RequestMapping("/zhuce")
	@ResponseBody
	public Map<String, Object> zhuce(HttpServletRequest hr,@RequestParam(value = "name", required = false) String name,@RequestParam(value = "pwd", required = false) String pwd,@RequestParam(value = "zjhm", required = false) String zjhm, Yh yh) {
//		public Map<String, Object> zhuce(HttpServletRequest hr,Yh yh){	//这里为什么要传入一个实体类yh？上面不是有一个了吗。。。
		Map<String, Object> map=new HashMap<String, Object>();
//		String name=hr.getParameter("zhucename");
//		String pwd=hr.getParameter("zhucepwd");
//		String zjhm=hr.getParameter("zjhm");
//		System.out.println(name + "---" + pwd);
		System.out.println(yh.getName()+"--iop");
		System.out.println("===" + yh.getZjhm()+yh.getPwd());
//		yh.setName(name);
//		yh.setPwd(pwd);
//		yh.setZjhm(zjhm);
		if(yhservice.zhuce(yh)!=0){
			map.put("xinxi", "wanshi");			
			return map;
		}else{
			map.put("xinxi", "zazhengdi");			
			return map;
		}
	}
	
//	//第二种注册方式
//	@RequestMapping("/zhuce")
//	public String zhuce(HttpServletRequest hr) {
//		Map<String, Object> map=new HashMap<String, Object>();
//		String name=hr.getParameter("name");
//		String pwd=hr.getParameter("pwd");
//		String zjhm=hr.getParameter("zjhm");
//		System.out.println(name + "---" + pwd);
//		yh.setName(name);
//		yh.setPwd(pwd);
//		yh.setZjhm(zjhm);
//		System.out.println("===" + yh.getZjhm());
//		yhservice.zhuce(yh);
//		map.put("xinxi", "wanshi");
//		return "denglu";
//	}

	@RequestMapping("/xiugaiyh")
	@ResponseBody
	public Map<String, Object> xiugaiyh(HttpServletRequest hr,@RequestParam(value = "name", required = false) String name,@RequestParam(value = "pwd", required = false) String pwd,
			@RequestParam(value = "zjhm", required = false) String zjhm,@RequestParam(value = "id", required = false) String id, Yh yh) {
//		public Map<String, Object> zhuce(HttpServletRequest hr,Yh yh){	//这里为什么要传入一个实体类yh？上面不是有一个了吗。。。
		Map<String, Object> map=new HashMap<String, Object>();
//		String name=hr.getParameter("zhucename");
//		String pwd=hr.getParameter("zhucepwd");
//		String zjhm=hr.getParameter("zjhm");
		System.out.println(id+name);
		System.out.println(name);
		System.out.println(yh.getName()+"--iop--" + yh.getZjhm()+yh.getPwd());
		if(name!=null&&name!=""&&pwd!=null&&pwd!=""){
		if(yhservice.updateYh(yh)!=0){
			map.put("mess", "ol");			
			return map;
		}else{
			map.put("mess", "zazhengdi");			
			return map;
		}
		}else{
			map.put("mess", "empty");			
			return map;
		}
	}
	@RequestMapping("/woajax")
	@ResponseBody
	// 返回json
	public Map<String, Object> ajaxxiangguan(
			@RequestParam(value = "zhucename", required = false) String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(name);
		// JsonObject json=new JsonObject();
		// json.add("text", text);
		Yh yh=yhservice.getYhbyname(name);
		if(yh.getName()!=null&&yh.getName()!=""){
			map.put("yanzheng","had");
			return map;
		}
		else{
			map.put("yanzheng", "no");
			return map;
		}
		// 此时没有定义变量的名字，默认就用这个参数的类型的名字做为变量的名字，不过首字母大写变小写
		// model.addAttribute("xxxxxxx");
		// return "shouye";		
	}
	@RequestMapping("/ajaxyhmyanzheng")
	@ResponseBody
	// 返回json
	public Map<String, Object> yhnyanzheng(
			@RequestParam(value = "zhucename", required = false) String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(name+"---");
		// JsonObject json=new JsonObject();
		// json.add("text", text);
		if(name!=null||name!=""){			
			yh=yhservice.getYhbyname(name);
		}
		if(yh!=null){
			System.out.println(yh.getName());
			map.put("yanzheng","had");
			return map;
		}
		else{
			map.put("yanzheng", "no");
			return map;
		}
	}
	@RequestMapping("/liebiao")
	@ResponseBody
	// 返回json
	public List<Yh> yhliebiao(HttpServletRequest hr,
			@RequestParam(value = "name", required = false) String name,@RequestParam(value = "page", required = false) String page,@RequestParam(value = "rows", required = false) String rows,Yh yh) {
		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println(hr.getParameter("name"));
		System.out.println(name);
//		name="%"+name+"%";//模糊查询的一种方式
		List<Yh> yhlist=yhservice.getYhall(yh);
		System.out.println(yhlist);
		map.put("yh", yhlist);
		// JsonObject json=new JsonObject();
		// json.add("text", text);
		return yhlist;
	}
	@RequestMapping("/shanchuyh")
	@ResponseBody
	// 返回json
	public Map<String, Object> shanchuyh(
			@RequestParam(value = "ids", required = false) String name,Yh yh) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(name+"---");
//		List<Yh> yhlist=yhservice.getYhall(yh);
		if(yhservice.shanchuByname(name)==1){
			
			map.put("mess","success" );
			return map;
		}else{
			map.put("mess","nosuccess" );
			return map;
		}
	}
	
	@RequestMapping("/jiaruvip")
	// 返回响应体中
	@ResponseBody
	public Map<String, Object> jiaruvip(
			@RequestParam(value = "yhid", required = false) String yhid) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(yhid);
		// JsonObject json=new JsonObject();
		// json.add("text", text);
		int jiaruchenggong=1;
		if(rpyservice.jiaruvip(yhid)!=0){
			System.out.println("jiaruchenggong"+rpyservice.jiaruvip(yhid));
			System.out.println("yhid"+yhid);
			map.put("jiaruchenggong","kaishi");
			return map;
		}
		else{
			map.put("shenmeqingkuang", "no");
			return map;
		}
		// 此时没有定义变量的名字，默认就用这个参数的类型的名字做为变量的名字，不过首字母大写变小写
		// model.addAttribute("xxxxxxx");
		// return "shouye";		
	}
}
