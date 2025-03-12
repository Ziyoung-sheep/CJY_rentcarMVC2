package kr.basic.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CommunityBoardDAO {
	
	//인스턴스 객체 생성
	static private CommunityBoardDAO instance = new CommunityBoardDAO();
	private CommunityBoardDAO() {}
	static public CommunityBoardDAO getInstance() {
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
	
	
	public ArrayList<CommunityBoardVO> makeCommunityBoardList() {
		ArrayList<CommunityBoardVO> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list=(ArrayList)session.selectList("communityBoardList");
			return list;
		}catch (Exception e) {
			System.out.println("makeRentCarList() ERR");
			e.printStackTrace();
			return null;
		}
	}
	
	//새글쓰기
	public int insertNewCB(String id, String title, String main, String img) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			CommunityBoardVO vo=new CommunityBoardVO(id, title, main, img);
			session.selectOne("communityBoardInsert", vo);
			session.commit();
			return 1;
		}catch (Exception e) {
			System.out.println("insertNewCB() ERR");
			e.printStackTrace();
			return 0;
		}
	}
	
	//글 가져오기
	public CommunityBoardVO communityBoardContent(int num) {
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			CommunityBoardVO vo=session.selectOne("communityBoardReading", num);
			return vo;
		}catch (Exception e) {
			System.out.println("communityBoardConten ERR");
			e.printStackTrace();
			return null;
		}
	}
	
	//글 삭제하기
	public boolean communityBoardDelete(int num) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.selectOne("communityBoardDelete", num);
			session.commit();
			return true;
		}catch (Exception e) {
			System.out.println("communityBoardDelete() ERR");
			e.printStackTrace();
			return false;
		}
	}

}
