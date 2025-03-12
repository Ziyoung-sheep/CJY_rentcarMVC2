package kr.basic.model;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EventDAO {
	
	//인스턴스 객체 생성
	static private EventDAO instance = new EventDAO();
	private EventDAO() {}
	static public EventDAO getInstance() {
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
	
	public EventVO takeEvent() {
		
		EventVO nowEvent=null;
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			nowEvent=(EventVO)session.selectOne("takeEvent");
			return nowEvent;
		}catch (Exception e) {
			System.out.println("takeEvent() ERR");
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean makeNewEvent(String title, String start_date, String end_date, String event_img) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			EventVO vo=new EventVO(title, start_date, end_date, event_img);
			session.selectOne("makeNewEvent", vo);
			session.commit();
			return true;
		}catch (Exception e) {
			System.out.println("makeNewEvent() ERR");
			e.printStackTrace();
			return false;
		}
	}
	
	
	

}
