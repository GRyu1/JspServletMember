package controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String charset = null;
    HashMap<String,Controller> list = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        charset = config.getInitParameter("charset");
        list = new HashMap<>();

        list.put("/memberInsert.do" , new MemberInsertController());
        list.put("/memberSearch.do" , new MemberSearchController());
        list.put("/memberUpdate.do" , new MemberUpdateController());
        list.put("/memberDelete.do" , new MemberDeleteController());
        list.put("/memberList.do" , new MemberListController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(charset);
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = url.substring(contextPath.length());

        Controller subCont = list.get(path);
        subCont.execute(req, resp);
    }
}
