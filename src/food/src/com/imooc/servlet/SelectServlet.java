package food.src.com.imooc.servlet;

import com.imooc.entity.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        //首先得获取表单中输入的ID值
        String foodName = req.getParameter("foodName");
//        System.out.println(foodName);
        //获取全局作用域变量
        List<Food> list = (List<Food>) this.getServletContext().getAttribute("list");

        int index = 0;
        if(list.size() != 0) {
            for (Food food : list) {  //遍历全局作用域集合，查找有没有同名的菜品
                if (foodName.equals(food.getFoodName())) {
                    //System.out.println("SelectServlet " + food);
//                    System.out.println("true" + food.getFoodName());
                    req.setAttribute("food", food);
                    req.getRequestDispatcher("/selectResult.jsp").forward(req, resp);
                    return;
                } else {   //没有找到相应的菜品
//                    System.out.println("false" + food.getFoodName());
                    if (index != list.size() - 1) {
                        ++index;
                        continue;
                    }
                    req.setAttribute("msg", "没有找到相应的菜品");
                    req.getRequestDispatcher("/selectFoodByName.jsp").forward(req, resp);
                }
            }
        }else{
            req.setAttribute("msg", "菜品列表为空");
            req.getRequestDispatcher("/selectFoodByName.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
