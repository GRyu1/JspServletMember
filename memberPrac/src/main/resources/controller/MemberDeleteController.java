package controller;

import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberDeleteController implements Controller{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        MemberService service = MemberService.getInstance();
        service.memberDelete(id);

        HttpUtil.forward(request, response , "/result/memberDeleteOutput.jsp");
    }
}
