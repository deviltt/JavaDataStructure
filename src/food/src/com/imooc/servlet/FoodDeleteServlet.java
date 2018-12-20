package food.src.com.imooc.servlet;

import com.imooc.entity.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FoodDeleteServlet")
public class FoodDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先获取表单传过来的foodId
        int foodId = Integer.parseInt(req.getParameter("foodId"));
        //获取全局作用域集合，找到对应的foodId，并删除
        List<Food> foods = (List<Food>) this.getServletContext().getAttribute("list");
        int index = 0;
        if(foods.size() != 0) {
            for (Food food : foods) {
                if (foodId == food.getFoodId()) {
                    foods.remove(food);
                    //将修改的集合重新放入
                    this.getServletContext().setAttribute("list", foods);
                    req.setAttribute("msg", "成功删除！");
                    req.getRequestDispatcher("/deleteById.jsp").forward(req, resp);
                    return;
                } else {
                    if (index != foods.size() - 1) {
                        ++index;
                        continue;
                    }
                    req.setAttribute("msg", "菜品不存在，不需要删除");
                    req.getRequestDispatcher("/deleteById.jsp").forward(req, resp);
                }
            }
        }else {
            req.setAttribute("msg", "菜品列表为空");
            req.getRequestDispatcher("/deleteById.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
