package com.test.web.servlet;

import com.test.web.dao.LoginDao;
import com.test.web.dao.impliments.LoginDaoImpl;
import com.test.web.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 石昊 on 2017/4/8.
 */
public class LoginServlet extends HttpServlet{
    public LoginServlet(){
        super();
    }

    public void destroy(){
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
        response.setContentType("text/html");

        //设置对客户端请求进行重新编码的编码为utf-8
        request.setCharacterEncoding("utf-8");

        //指定对服务器响应进行重新编码的编码为utf-8
        response.setCharacterEncoding("utf-8");

        //服务器向客户端反馈的时候需要用流向客户端输出数据
        PrintWriter out = response.getWriter();

        //获取jsp页面发生的事件
        String state = request.getParameter("state");

        //对jsp页面传来的事件进行判断并进行响应
        System.out.println(state);
        if (state.equals("login")) {
            LoginCheck(request, response);
        } else if (state.equals("register")) {
            Register(request, response);
        } else if (state.equals("edit")) {
            EditUser(request, response);
        } else if (state.equals("del")) {
            DeleteUser(request,response);
        }else if (state.equals("toadd")){
            RequestDispatcher rd =request.getRequestDispatcher("/register.jsp");
            rd.forward(request,response);
        }else if(state.equals("toedit")){
            TOEditUser(request, response);
        }
    }

    /*
     *列出所有用户
     */
    private void ListAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<User> list = new ArrayList<User>();
        RequestDispatcher rd = null;
        LoginDao userdao = new LoginDaoImpl();
        list = userdao.ListAll();
        request.setAttribute("list",list);
        rd = request.getRequestDispatcher("/main.jsp");
        rd.forward(request,response);
    }

    /*
     *获取注册时封装的userbean
     */
    private User getBeanFromRequest(HttpServletRequest request,HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User bean = new User();
        bean.setUsername(username);
        bean.setPassword(password);
        return bean;
    }

    /*
     *登录
     */
    private void LoginCheck(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginDao userdao = new LoginDaoImpl();
        User userbean = null;
        userbean = userdao.GetUserByUsername(username);
        RequestDispatcher rd = null;
        HttpSession session = request.getSession();
        if(userbean != null){
            System.out.println(userbean);
            if(userbean.getPassword().equals(password)){
                session.setAttribute("name",userbean);
                ListAll(request,response);
            }else{
                rd = request.getRequestDispatcher("/login.jsp");
                request.setAttribute("msg","密码错误");
                rd.forward(request,response);
            }
        }else{
            rd = request.getRequestDispatcher("/login.jsp");
            request.setAttribute("msg","该用户不存在");
            rd.forward(request,response);
        }
    }

    /*
     *注册
     */
    private void  Register(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        RequestDispatcher rd = null;
        LoginDao userdao = new LoginDaoImpl();
        if(userdao.GetUserByUsername(request.getParameter("username"))!=null){
            request.setAttribute("msg","该用户已经存在");
            rd = request.getRequestDispatcher("/register.jsp");
            rd.forward(request,response);
        }else{
            User bean = getBeanFromRequest(request,response);
            if(bean != null){
                userdao = new LoginDaoImpl();
                userdao.InsertUser(bean);
                ListAll(request,response);
            }else{
                rd = request.getRequestDispatcher("/register.jsp");
                request.setAttribute("msg","输入信息不完全");
                rd.forward(request,response);
            }
        }
    }

    /*
     *编辑用户
     */
    private void EditUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        RequestDispatcher rd = null;
        LoginDao userdao = new LoginDaoImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User bean = userdao.GetUserByUsername(username);
        LoginDao userdao1 = new LoginDaoImpl();
        User user = new User();
        user.setId(bean.getId());
        user.setUsername(username);
        user.setPassword(password);
        userdao1.UpdateUser(user);
        ListAll(request,response);
    }

    /*
     *删除用户
     */
    private void DeleteUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String username = request.getParameter("username");
        System.out.println(username);
        LoginDao userdao = new LoginDaoImpl();
        userdao.DeleteUser(username);
        ListAll(request,response);
    }

    /*
     *跳转至编辑
     */
    private void TOEditUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        RequestDispatcher rd = null;
        String username = request.getParameter("username");
        LoginDao userdao = new LoginDaoImpl();
        User user = userdao.GetUserByUsername(username);
        request.setAttribute("_username",user.getUsername());
        request.setAttribute("_password",user.getPassword());
        rd = request.getRequestDispatcher("/edit.jsp");
        rd.forward(request,response);
    }
}
