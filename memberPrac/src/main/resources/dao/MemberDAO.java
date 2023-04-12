package dao;

import vo.MemberVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
    private static MemberDAO dao = new MemberDAO();
    private MemberDAO(){}
    public static MemberDAO getInstance(){
        return dao;
    }

    public Connection connect(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","12qw34er");
        }catch (Exception e){
            System.out.println("오류발생 : "+e);
        }
        return conn;
    }

    public void close(Connection connection , PreparedStatement preparedStatement , ResultSet resultSet){
        if(resultSet != null){
            try{
                resultSet.close();
            }catch (Exception e){
                System.out.println("오류발생 : "+e);
            }
        }
        close(connection,preparedStatement);
    }

    public void close(Connection connection, PreparedStatement preparedStatement){
        if(preparedStatement!=null){
            try{
                preparedStatement.close();
            }catch (Exception exception){
                System.out.println("오류 발생 : "+exception);
            }
        }
        if (connection != null){
            try {
                connection.close();
            }catch (Exception exception){
                System.out.println("오류발생 : "+exception);
            }
        }
    }

    public void memberInsert(MemberVO member){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection=connect();
            preparedStatement = connection.prepareStatement("insert into member values (?,?,?)");
            preparedStatement.setString(1, member.getId());
            preparedStatement.setString(2, member.getPasswd());
            preparedStatement.setString(3, member.getName());
            System.out.println(member.toString());

            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("오류발생 : "+e);
        }finally {
            close(connection , preparedStatement);
        }
    }

    public MemberVO memberSearch(String id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        MemberVO member = null;

        try{
            conn=connect();
            preparedStatement = conn.prepareStatement("select * from jdbc.member where id=?");
            preparedStatement.setString(1,id);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                member = new MemberVO();
                member.setId(resultSet.getString(1));
                member.setPasswd(resultSet.getString(2));
                member.setName(resultSet.getString(3));
            }
        }catch (Exception e){
            System.out.println("오류발생 : "+e);
        }finally {
            close(conn,preparedStatement,resultSet);
        }
        return member;
    }

    public void memberUpdate(MemberVO member) {
        Connection conn=null;
        PreparedStatement ps= null;

        try{
            conn = connect();
            ps = conn.prepareStatement("update jdbc.member set passwd=?,name=? where id=?");
            ps.setString(1, member.getPasswd());
            ps.setString(2, member.getName());
            ps.setString(3, member.getId());

            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("오류 발생 : "+e);
        }finally {
            close(conn , ps);
        }
    }

    public void memberDelete(String id) {
        Connection conn =null;
        PreparedStatement ps = null;

        try{
            conn = connect();
            ps = conn.prepareStatement("delete from jdbc.member where id=?");
            ps.setString(1, id);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("오류발생 : " + e);
        }finally {
            close(conn, ps);
        }
    }

    public ArrayList<MemberVO> memberlist() {
        ArrayList<MemberVO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        MemberVO member;

        try{
            conn = connect();
            ps = conn.prepareStatement("select * from jdbc.member");
            rs = ps.executeQuery();
            while(rs.next()){
                member = new MemberVO();
                member.setId(rs.getString(1));
                member.setPasswd(rs.getString(2));
                member.setName(rs.getString(3));
                list.add(member);
            }
        }catch (Exception e){
            System.out.println("오류 발생 : "+e);
        } finally {
            close(conn, ps , rs);
        }
        return list;
    }
}
