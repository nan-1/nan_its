package interceptorlanjieqi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public  class ZidingyiInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyIntercpetor.preHandle()");
      //获取请求的url，是登录的话放行
        String url = request.getRequestURI();
        System.out.println("url:"+url);
        if(url.indexOf("/modelonly")>=0){
        	return true;
        }
        
      //判断session
        HttpSession session  = request.getSession();
        //从session中取出用户身份信息
        String username = (String) session.getAttribute("name");
        System.out.println("username:"+username);
        if(username != null){
            //身份存在，放行
            return true;
        }else{
      //执行这里表示用户身份需要认证，跳转登陆页面
        request.getRequestDispatcher("/WEB-INF/jsp/denglu.jsp").forward(request, response);
        //return false表示拦截，不向下执行；return true表示放行
        return false;
        }
    }
}
