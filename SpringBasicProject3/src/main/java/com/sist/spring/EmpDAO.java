package com.sist.spring;
import java.util.*;

import com.sist.spring.EmpVO;

import java.sql.*;
/*
 * => MyBasicDataSource �޸� �Ҵ� ��û
 * => MyBasicDataSource�� ������ �ִ� setter �� ���� ä���
 * => EmpDAO(MyBasicDataSource ds)
 * ================================================= Spring�� ��û
 * => MainClass���� ȣ���ؼ� ��� 
 */
public class EmpDAO {
	private MyBasicDataSource ds;
	public EmpDAO(MyBasicDataSource ds){
		this.ds = ds;
		try {
			Class.forName(ds.getDriverClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private Connection conn;
	private PreparedStatement ps;
	
	public void getConnection(){
		try {
			conn=DriverManager.getConnection(ds.getUrl(),ds.getUserName(),ds.getPassword());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
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
	public List<EmpVO> empAllData(){
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			getConnection();
			String sql = "SELECT empno,ename,job,hiredate,sal "
					+"FROM emp";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setSal(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally{
			disConnection();
		}
		return list;
	}
}
