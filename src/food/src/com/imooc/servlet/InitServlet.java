package food.src.com.imooc.servlet;

import com.imooc.entity.Food;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //定义存储菜品信息的List容器
        List<Food> list = new ArrayList<>();

        //Servlet整个生命周期中init方法只执行一次，设置全局作用域，在web.xml中配置Servlet
        this.getServletContext().setAttribute("list", list);
    }
}
