package controller;

import service.MemberService;
import vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MemberListController implements Controller{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberService service = MemberService.getInstance();
        ArrayList<MemberVO> list = service.meberlist();

        request.setAttribute("list", list);
        HttpUtil.forward(request,response,"/result/memberListOutput.jsp");
    }
}
