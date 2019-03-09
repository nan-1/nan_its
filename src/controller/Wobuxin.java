package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wo")
public class Wobuxin {
public String aaa(Model model){
	String str="suibian";
	model.addAttribute("str", str);
	return "shouye";
	
}
}
