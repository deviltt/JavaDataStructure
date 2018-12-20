package food.src.com.imooc.utils;

import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class UploadUtils {
    public static String getUUIDFileName(String fileName){
        int index = fileName.lastIndexOf(".");
        String extention = fileName.substring(index);
        String uuidFileName = UUID.randomUUID().toString().replace("-", "") + extention;
        return uuidFileName;
    }

    public static String getPath(String fileName, FileItem fileItem, HttpServletRequest req) throws IOException {
        //获得不同名的图片文件
        String uuidFileName = getUUIDFileName(fileName);
        //获得文件上传数据
        InputStream is = fileItem.getInputStream();
        //获得文件上传路径
        String path = req.getServletContext().getRealPath("/img");
        //将输入流对接到输出流
        String url = path + "\\" + uuidFileName;
        OutputStream os = new FileOutputStream(url);
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = is.read(b)) != -1)
            os.write(b, 0, len);
        is.close();
        os.close();
        return url;
    }
}
