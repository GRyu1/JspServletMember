package controller;

import service.MemberService;
import vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberUpdateController implements Controller{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String passwd = request.getParameter("passwd");
        String name = request.getParameter("name");

        if(id == null || id.isEmpty() || passwd==null || passwd.isEmpty() || name == null || name.isEmpty()){
            request.setAttribute("error", "모든 항목을 빠짐없이 입력해주세요.");
            HttpUtil.forward(request,response,"/memberInsert.jsp");
        }
        MemberVO member = new MemberVO();
        member.setId(id);
        member.setPasswd(passwd);
        member.setName(name);

        MemberService service = MemberService.getInstance();
        service.memberUpdate(member);

        request.setAttribute("id", id);
        HttpUtil.forward(request, response , "/result/memberUpdateOutput.jsp");
    }
}
