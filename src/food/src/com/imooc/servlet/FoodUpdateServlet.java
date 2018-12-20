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

@WebServlet("/FoodUpdateServlet")
public class FoodUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //修改之前首先要在全局作用域中找到这个菜品，因此第一步需要拿到全局作用域集合
            List<Food> list = (List<Food>) this.getServletContext().getAttribute("list");
            //拿到表单提交的ID，因为要提取文件信息，要创建磁盘工厂类对象
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            //对request进行解析，返回
            List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
            //map用来临时保存要修改的数据
            Map<String, String> map = new HashMap<>();
            String url = null;
            //将菜品ID转换成整数
            int foodId = Integer.parseInt(fileItemList.get(0).getString());
            int index = 0;
            //遍历集合找到相同ID的菜品
            if(list.size() != 0) {
                for (Food food : list) {
                    if (food.getFoodId() == foodId) {   //如果找到了则进行修改操作
                        //先将所有修改的数据进行保存
                        for (int i = 1; i < fileItemList.size(); i++) {  //遍历表单返回的结果，除了第一个foodId
                            if (fileItemList.get(i).isFormField()) {  //如果是普通的表单项
                                String name = fileItemList.get(i).getFieldName();
                                String value = fileItemList.get(i).getString("UTF-8");
                                map.put(name, value);
                            } else { //是文件流信息
                                FileItem fileItem = fileItemList.get(i);
                                url = UploadUtils.getPath(fileItem.getName(), fileItem, req);
                                map.put("foodImage", url);
                            }
                        }
                        //                    System.out.println(map);
                        food.setFoodName(map.get("foodName"));
                        food.setTaste(map.get("taste"));
                        food.setPath(map.get("foodImage"));
                        food.setDesc(map.get("desc"));
                        food.setPrice(Double.parseDouble(map.get("price")));
                        req.setAttribute("msg", "修改成功！");
//                        list.add(food);   //不需要再放回了
                        //再将修改后的list放回不需要放回的，重复了就
                        this.getServletContext().setAttribute("list", list);

                        req.getSession().setAttribute("updateName", food.getFoodName());
                        //页面跳转
                        req.getRequestDispatcher("/updateFood.jsp").forward(req, resp);
                        return;
                    } else {  //没找到则跳转到添加菜品页面
                        if (index != list.size() - 1) {
                            ++index;
                            continue;
                        }
                        req.setAttribute("msg", "该菜品不存在");
                        req.getRequestDispatcher("/addFood.jsp").forward(req, resp);
                    }
                }
            }else {
                req.setAttribute("msg1", "菜品列表为空");
                req.getRequestDispatcher("/addFood.jsp").forward(req, resp);
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
