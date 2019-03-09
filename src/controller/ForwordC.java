package controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/xxxxx")
public class ForwordC {
	@RequestMapping("/{pagename}")
	public String jspdizhi(@PathVariable("pagename")String pagename,HttpServletRequest hsr){
		Map<String, Object> map=new HashMap<String, Object>();
		Enumeration<?> paramternames=hsr.getParameterNames();
		while(paramternames.hasMoreElements()){
			Object paramtername=paramternames.nextElement();
			hsr.setAttribute((String)paramtername, hsr.getParameter((String)paramtername));
			System.out.println((String)paramtername+"++"+hsr.getParameter((String)paramtername));
		}
		return pagename;
	}

}
