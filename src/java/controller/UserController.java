/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author GiaHieu
 */
@Controller

public class UserController {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstm;

    @RequestMapping("login")
    public String index() {
        return "login";
    }

    @RequestMapping(params = "btnLogin")
    public String inser(ModelMap model, @RequestParam("username") String username,
            @RequestParam("password") String password) {
        try {
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=SOF302_ASM";
            con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select * from Users where Username=? and Password=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String full = rs.getString(3);
                model.addAttribute("message", "Bạn đã đăng nhập thành công");
                model.addAttribute("fullname", "Xin chào" + full);
            }else{
                model.addAttribute("message", "Bạn đã đăng nhập thất bại");
            }
            con.close();
            pstm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }

}
