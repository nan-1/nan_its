package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/ng")
public class Uwlwcon {
	public String zzz(HttpServletRequest hr, @RequestParam(value="name", required=false) String name, @RequestParam(value="tel", required=false) String t){
		System.out.println(name+"---"+t);
		hr.setAttribute("name", "aaa");
		return "shanchu.jsp";
	}
	public Model mo(HttpServletRequest hr, @RequestParam(value="name", required=false) String name, @RequestParam(value="tel", required=false) String t,Model mo){
		System.out.println(name+"---"+t);
		
		hr.setAttribute("name", "aaa");
		return mo;
	}
	//modelandview
	@RequestMapping("/modelandv")
	public ModelAndView mav( @RequestParam(value="name", required=false) String name, @RequestParam(value="tel", required=false) String t){
		System.out.println(name+"---"+t);
		ModelAndView ma=new ModelAndView();
		ma.setViewName("denglu");
		String str="aaas";
		List<String> li= new ArrayList<String>();
		li.add("aaa");
		li.add("bb");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("wo", "www");
		ma.addObject("list", li);
		//ma.addObject("map", map);
		ma.addObject("str", str);
		return ma;
	}
	@RequestMapping("/modelonly")
	public String secondRequest(Model model){
		String key = "hello world";
		model.addAttribute("key", key);
		//��ʱû�ж�����������֣�Ĭ�Ͼ���������������͵�������Ϊ���������֣���������ĸ��д��Сд
		//model.addAttribute("xxxxxxx");
		return "shouye";
	}
	public String secondRequest(HttpServletRequest request,HttpSession session){
		request.setAttribute("req", "ͨ��request��ŵĲ���");
		session.setAttribute("ses", "session�е�����");
		return "show";
	}

}
