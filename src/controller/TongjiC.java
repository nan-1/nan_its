package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.serviceImpl.TongjiServiceImpl;
import shitilei.TongjiVo;

@Controller
@RequestMapping("/tongji")
public class TongjiC {
	@Autowired
	private TongjiServiceImpl tongjiservice;
	@RequestMapping("/zhuce")
	@ResponseBody
	public List<TongjiVo> zhucetongji(HttpServletRequest hsr){
		List<TongjiVo> list=tongjiservice.zhucetongji();
		System.out.println(list.get(0).getNums());
		return list;
	}

}
