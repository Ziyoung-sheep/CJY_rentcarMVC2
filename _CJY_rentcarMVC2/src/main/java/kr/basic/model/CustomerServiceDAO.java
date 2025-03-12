package kr.basic.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerServiceDAO {
	
	//인스턴스 객체 생성
	static private CustomerServiceDAO instance = new CustomerServiceDAO();
	private CustomerServiceDAO() {}
	static public CustomerServiceDAO getInstance() {
		return instance;
	}
	
	//static{} static블록 서버 실행될 때 딱 1번 실행한다
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "kr/basic/mybatis/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//문의글 전체보기
	public ArrayList<CustomerServiceVO> makeMyCustomerServiceList() {
		ArrayList<CustomerServiceVO> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list=(ArrayList)session.selectList("customerServiceList");
			return list;
		}catch (Exception e) {
			System.out.println("customerServiceList() ERR");
			e.printStackTrace();
			return null;
		}
	}
	//내 문의글 확인하기
	public ArrayList<CustomerServiceVO> makeMyCustomerServiceList(String id) {
		ArrayList<CustomerServiceVO> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			
			list=(ArrayList)session.selectList("customerServiceListFromId", id);
			return list;
		
		}catch (Exception e) {
			System.out.println("customerServiceList() ERR");
			e.printStackTrace();
			return null;
		}
	}
	
	//새문의글쓰기
	public int insertNewCS(String id, String title, String main) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			CustomerServiceVO vo=new CustomerServiceVO(id, title, main);
			session.selectOne("customerserviceInsert", vo);
			session.commit();
			return 1;
		}catch (Exception e) {
			System.out.println("insertNewCS() ERR");
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public CustomerServiceVO customerServiceContent(int num) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			CustomerServiceVO vo=session.selectOne("customerServiceReading", num);
			return vo;
		}catch (Exception e) {
			System.out.println("customerServiceContent ERR");
			e.printStackTrace();
			return null;
		}
	}

}
