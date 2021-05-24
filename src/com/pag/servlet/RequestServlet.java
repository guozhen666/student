package com.pag.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@MultipartConfig
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在所有数据获取之前，进行乱码处理
        //处理请求体乱码
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(username);
        System.out.println(password);
        System.out.println(gender);
        System.out.println(Arrays.toString(hobbies));
        //文件处理，上传
        // 获取上传的文件对象
        Part part=request.getPart("file");
        //获取上传的文件的名字（包括后缀）
        String header=part.getHeader("Content-Disposition");
        String fileName = header.substring(header.lastIndexOf("=")+2,header.length()-1);
        //指定上传位置
        String path= "D:\\upload";
        //判断该文件夹是否存在，如果不存在，就创建
        File file=new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        part.write(path+"/"+UUID.randomUUID()+fileName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
