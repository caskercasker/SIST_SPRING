package com.sist.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String URL="jdbc:oracle:thin:@localhost:1521:XE";
	public MemberDAO (){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void getConnection(){
		try {
			conn= DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void disConnection(){
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<MemberVO> memberListData(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			getConnection();
			String sql = "SELECT * FROM trans_member";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			//index가 안맞아도 컬럼 명으로 처리 가능 (mybatis)
			while(rs.next()){
				MemberVO vo = new MemberVO();
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				vo.setSex(rs.getString("sex"));
				
				list.add(vo);
			}
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			disConnection();
		}
		return list;
	}
	
	public void memberInsert(MemberVO vo,MemberVO vo2){
		try {
			getConnection();
			String sql ="INSERT INTO trans_member VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getNo());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getSex());
			ps.executeUpdate();  //commit
			
			sql ="INSERT INTO trans_member VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo2.getNo());
			ps.setString(2, vo2.getName());
			ps.setString(3, vo2.getSex());
			ps.executeUpdate(); //commit
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			disConnection();
		}
	}
}
