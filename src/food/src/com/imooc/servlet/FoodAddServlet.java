package food.src.com.imooc.servlet;

import com.imooc.entity.Food;
import com.imooc.utils.UploadUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/FoodAddServlet")
public class FoodAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //存放name ： value键值对
            Map<String, String> map = new HashMap<>();
            //磁盘文件项工厂
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //创建核心解析类
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            //解析request请求
            List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
            //存储图片路径
            String url = null;
            for(FileItem fileItem : fileItemList){
                //如果是常规表单项
                if(fileItem.isFormField()){
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    map.put(name, value);
                }
                else{   //如果是表单文件项
                    //获得文件名称
                    String fileName = fileItem.getName();
                    if(fileName != null && !"".equals(fileName))
                        url = UploadUtils.getPath(fileName, fileItem, req);
                }
            }   //for

//            System.out.println(map);

            //重新获取全局作用域变量
            List<Food> list = (List<Food>) this.getServletContext().getAttribute("list");

            Food food = new Food();
            food.setFoodId(Integer.parseInt(map.get("foodId")));
            food.setFoodName(map.get("foodName"));
            food.setTaste(map.get("taste"));
            food.setPath(url);
            food.setPrice(Double.parseDouble(map.get("price")));
            food.setDesc(map.get("desc"));

//            System.out.println(food);

            //判断菜品是否已经添加，则显示错误信息并返回菜品添加页面
            for(Food food1 : list){
                if(food.getFoodName().equals(food1.getFoodName())){
                    req.setAttribute("msg", "菜品已经添加!");
                    req.getRequestDispatcher("/addFood.jsp").forward(req, resp);
                    return;
                }
            }

            //如果没有同样的菜品，则存入全局作用域
            list.add(food);
            this.getServletContext().setAttribute("list", list);

//            req.getSession().setAttribute("food", food);
            req.getRequestDispatcher("/showFoodList.jsp").forward(req, resp);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
