package cn.edu.hit.helloweb;

import cn.edu.hit.dao.MajorDao;
import cn.edu.hit.dao.impl.MajorDaoImpl;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import cn.edu.hit.entity.Major;
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if(action.equals("add")) {
            String mid = request.getParameter("mid");
            String mname = request.getParameter("mname");
            MajorDao majorDao = new MajorDaoImpl();
            majorDao.add(new Major(mid, mname));
        }
        else if(action.equals("getAll")) {
            MajorDao majorDao = new MajorDaoImpl();
            List<Major> majorList = majorDao.getAll("select * from major");
            out.println(JSON.toJSONString(majorList));
        }

    }

    public void destroy() {
    }
}