package com.ishop.servlet.product;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ishop.dao.ProductDao;
import com.ishop.dao.impl.ProductDaoImpl;
import com.ishop.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by myq on 2017/4/29.
 */
@WebServlet(name = "GetProductByIdServlet",urlPatterns = "/getProductById")
public class GetProductByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ProductDao pd = new ProductDaoImpl();
            String paramId = request.getParameter("id");
            Integer id = Integer.parseInt(paramId);
            Product product = pd.get(id);
            PrintWriter out = response.getWriter();
            //将list的数据转换成JSON返回给前台
            //JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
            //SerializerFeature.WriteDateUseDateFormat用来将日期格式化成yyyy-MM-dd的形式
            String json = JSON.toJSONString(product, SerializerFeature.WriteDateUseDateFormat,SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect);
            if(product != null) {
                out.println(json);
                out.close();
            }else{
                out.println(false);
                out.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}