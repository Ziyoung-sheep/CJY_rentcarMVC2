package kr.basic.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.eclipse.tags.shaded.org.apache.regexp.recompile;

public class UserDAO {
	
	//인스턴스 객체 생성
	static private UserDAO instance = new UserDAO();
	private UserDAO() {}
	static public UserDAO getInstance() {
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
	
	//유저 리스트 만들기
	public ArrayList<UserVO> makeUserList() {
		
		ArrayList<UserVO> list = null;
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list=(ArrayList)session.selectList("userList");
			return list;
		}catch (Exception e) {
			System.out.println("makeUserList() ERR");
			e.printStackTrace();
			return null;
		}
	}
	
	
	//로그인 체크: 아이디랑 비번 입력해서 넘버 뽑기
	public int checkLogin(String id, String pw) {
		try (SqlSession session = sqlSessionFactory.openSession()) {	
			Map<String, String> checkIdPw=new HashMap<String, String>();
			checkIdPw.put("id", id);
			checkIdPw.put("pw", pw);
			int num=session.selectOne("checkLogin", checkIdPw);
			System.out.println("num="+num);
			return num; //성공하면 로그인한 num이 나오고
		} catch (Exception e) {
			e.printStackTrace();
			return 0; //실패하면 0 반환
		}
	}
	
	//id 입력해서 유저의 num 찾아오기
	public boolean checkId(String id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			Integer num=session.selectOne("getUserNum", id);
			System.out.println("중복 아이디 체크 num="+num);
			//num이 null이면 같은 아이디가 없다는 이야기 / num이 숫자이면 같은 아이디가 있다는 이야기
			if (num==null) return true;
			else return false;
		} catch (Exception e) {
			System.out.println("아이디 체크하다 오류났음");
			e.printStackTrace();
			return false;
		}
	}

	//만들었는데 쓸모없어짐...필요하면 다시 살리지 뭐
//	public String getUserId(int num) {
//		try (SqlSession session = sqlSessionFactory.openSession()) {
//			String id=session.selectOne("getUserId", num);
//			System.out.println(num+"번 User의 ID: "+id);
//			return id;
//		}catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	public void newUserJoin(String id, String pw, String name, String email, String phone) {
		UserVO newUser=new UserVO(name, id, pw, email, phone);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			System.out.println("newUser: "+newUser.toString());
			session.selectOne("userJoin", newUser);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//id입력해서 삭제하기
	public boolean deleteUser(String id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.insert("userDelete", id);
			session.commit();
			return true;
		}catch (Exception e) {
			System.out.println("deleteUser ERR");
			e.printStackTrace();
			return false;
		}
	}
}
