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
      //��ȡ�����url���ǵ�¼�Ļ�����
        String url = request.getRequestURI();
        System.out.println("url:"+url);
        if(url.indexOf("/modelonly")>=0){
        	return true;
        }
        
      //�ж�session
        HttpSession session  = request.getSession();
        //��session��ȡ���û������Ϣ
        String username = (String) session.getAttribute("name");
        System.out.println("username:"+username);
        if(username != null){
            //��ݴ��ڣ�����
            return true;
        }else{
      //ִ�������ʾ�û������Ҫ��֤����ת��½ҳ��
        request.getRequestDispatcher("/WEB-INF/jsp/denglu.jsp").forward(request, response);
        //return false��ʾ���أ�������ִ�У�return true��ʾ����
        return false;
        }
    }
}
