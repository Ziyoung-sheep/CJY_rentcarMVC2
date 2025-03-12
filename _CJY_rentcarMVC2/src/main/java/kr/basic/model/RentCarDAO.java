package kr.basic.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class RentCarDAO {
	
	//인스턴스 객체 생성
	static private RentCarDAO instance = new RentCarDAO();
	private RentCarDAO() {}
	static public RentCarDAO getInstance() {
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
	
	//랜트카 리스트
	public ArrayList<RentCarVO> makeRentCarList() {
		ArrayList<RentCarVO> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list=(ArrayList)session.selectList("rentcarList");
			return list;
		}catch (Exception e) {
			System.out.println("makeRentCarList() ERR");
			e.printStackTrace();
			return null;
		}
	}
	//랜트카 리스트
	public ArrayList<RentCarVO> makeRentCarList(Integer category) {
		ArrayList<RentCarVO> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list=(ArrayList)session.selectList("rentcarListByCategory", category);
			return list;
		}catch (Exception e) {
			System.out.println("makeRentCarList() ERR");
			e.printStackTrace();
			return null;
		}
	}
	//랜트카 리스트
	public ArrayList<RentCarVO> makeRentCarList(String company) {
		ArrayList<RentCarVO> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list=(ArrayList)session.selectList("rentcarListByCompany",company);
			return list;
		}catch (Exception e) {
			System.out.println("makeRentCarList() ERR");
			e.printStackTrace();
			return null;
		}
	}
	//랜트카 리스트
	public ArrayList<RentCarVO> makeRentCarList(Integer category, String company) {
		ArrayList<RentCarVO> list = null;
		Map<String, Object> map=new HashMap();
		map.put("category", category);
		map.put("company", company);
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list=(ArrayList)session.selectList("rentcarListByCategoryAndCompany", map);
			return list;
		}catch (Exception e) {
			System.out.println("makeRentCarList() ERR");
			e.printStackTrace();
			return null;
		}
	}
	
	//랜트카 상세보기
	public RentCarVO rentCarContent(int num) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			Integer num2=num;
			RentCarVO vo=session.selectOne("rentCarContent",num2);
			return vo;
		}catch (Exception e) {
			System.out.println("rentCarContent ERR");
			e.printStackTrace();
			return null;
		}
	}
	
	public int rentCarQyt(int num) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			int cnt=session.selectOne("getRentCarQty", num);
			return cnt;
		}catch (Exception e) {
			System.out.println("rentCarQyt ERR");
			e.printStackTrace();
			return 0;
		}
	}
	public Boolean deleteRentCar(int num) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.insert("rentCarDelete", num);
			session.commit();
			return true;
		}catch (Exception e) {
			System.out.println("deleteRentCar ERR");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertNewRentCar(String name, int category, int price, int usepeople, int total_qty, String company, String img, String info) {
		RentCarVO vo=new RentCarVO(name, category, price, usepeople, total_qty, company, img, info);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.insert("rentCarInsert", vo);
			session.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
