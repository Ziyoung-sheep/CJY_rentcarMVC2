package kr.basic.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;import org.apache.tomcat.util.openssl.openssl_h;

public class ReservationDAO {
	
	//인스턴스 객체 생성
		static private ReservationDAO instance = new ReservationDAO();
		private ReservationDAO() {}
		static public ReservationDAO getInstance() {
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
		
		//아이디로 리스트 만들기
		public ArrayList<ReservationVO> makeMyReservationList(String id) {
			ArrayList<ReservationVO> list = null;
			try (SqlSession session = sqlSessionFactory.openSession()) {
				
				list=(ArrayList)session.selectList("reservationListFromId", id);
				return list;
			
			}catch (Exception e) {
				System.out.println("memberList() ERR");
				e.printStackTrace();
				return null;
			}
		}
		
		//아이디 없이 리스트 만들기
		public ArrayList<ReservationVO> makeMyReservationList() {
			ArrayList<ReservationVO> list = null;
			try (SqlSession session = sqlSessionFactory.openSession()) {
				list=(ArrayList)session.selectList("reservationList");
				return list;
			}catch (Exception e) {
				System.out.println("memberList() ERR");
				e.printStackTrace();
				return null;
			}
		}
		
		//예약 만들기
		public int makeNewReservation(int num, String userid, int qty, int dday, String rday, int usein,
				int usewifi, int usenavi, int useseat) {
			ReservationVO vo=new ReservationVO(num, userid, qty, dday, rday, usein, usewifi, usenavi, useseat);
			try (SqlSession session = sqlSessionFactory.openSession()) {
				session.selectOne("reservationInsert", vo);
				session.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("makeNewReservation() ERR");
				e.printStackTrace();
				return 0;
			}
		}
		
		//num 받아서 예약 삭제
		public boolean reservationDelete(int num) {
			try (SqlSession session = sqlSessionFactory.openSession()) {
				session.selectOne("reservationDelete", num);
				session.commit();
				return true;
			}catch (Exception e) {
				System.out.println("reservationDelete() ERR");
				e.printStackTrace();
				return false;
			}
		}
		
		public int areadyRent(Map<String, Object>map) {
			try (SqlSession session = sqlSessionFactory.openSession()) {
				int num=session.selectOne("sumRbyDateAndNum", map);
				return num;
			}catch (Exception e) {
				System.out.println("reservationDelete() ERR");
				e.printStackTrace();
				return 0;
			}
		}
		
		
//		public ArrayList<MemberVO> memberList() {
//			ArrayList<MemberVO> list = null;
//			try (SqlSession session = sqlSessionFactory.openSession()) {
//				//해야하는 작업 나열하기
//				//기존 하나하나 했던 작업을 시즌의 selectList 매소드 소환하면 자동으로 해줌
//				list=(ArrayList)session.selectList("memberList");
//				}catch (Exception e) {
//					System.out.println("memberList() ERR");
//					e.printStackTrace();
//				}
//			return list;
//		}
}