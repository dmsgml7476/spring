package com.springStudy1.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springStudy1.DTO.User;

@Repository    // DAO 클래스임을 명시하는 애너테이션, Spring이 자동으로 Bean으로 등록하고 예외 처리도 쉽게 해줌
public class UserDao {  // JDBC를 이용한 DAO 클래스로 user 테이블을 조작한다.

	private final JdbcTemplate jdbc;  // 데이터베이스와 상호작용하는 Spring의 JDBC 도구
	// final로 선언하여 객체 불변성을 유지하기 위해서. 생성자에서 초기화한 이후에는 다른 값으로 변경할 수 없다.
	// DAO 객체는 보통 한 번 생성되면 계속 같은 JdbcTemplate를 사용해야하므로 final을 붙이는게 안전함.
	
	@Autowired  // Spring 이 자동으로 JdbcTemplate 을 주입. 즉 별도 new JdbcTemplate()없이 Spring 이 관리하는 객체 사용.
	public UserDao(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	
	// findByUserId를 로그인
	public boolean findByUserId(String userId) { // 아이디 중복 확인(UserService)에서 회원가입할때 중복 아이디 확인용으로 사용.
		String sql="select user_id from user where user_id=?";  
		
		try {
			String id = jdbc.queryForObject(sql, String.class, userId);  // queryForject()
		}catch(EmptyResultDataAccessException e) { // catch 부분이 실행 된다는것은  조회 결과가 없다는 뜻
			return false; // 아이디가 중복이 아니다.
		}
		
		return true;// 아이디가 중복이다.
	}

	public void insert(User user) {  // 회원 정보 를 테이블에 저장
		String sql="insert into user(user_id, user_pw, user_email, user_job,"+
	              "user_addr, user_like) values(?,?,?,?,?,?)";
		
		jdbc.update(sql, user.getUserId(), user.getUserPw(), user.getUserEmail(),
				user.getUserJob(), user.getUserAddr(), user.getUserLike());
		
	}

	public boolean findByUserIdAndUserPw(String id, String pw) {
		
		String sql="select user_id from user where user_id=? and user_pw=?";
		
		try {
			String userId = jdbc.queryForObject(sql, String.class, id, pw);
		}catch(EmptyResultDataAccessException e) {
			return false; // 아이디 또는 비밀번호가 틀려서 결과가 없다.
		}
		
		return true; // 로그인 성공 처리 하기
	}

	public User findById(String id) {
		String sql = "select * from user where user_id=?";
		// 쿼리문을 통해 user 테이블의 정보 전체 조회해서 가져와 user클래스에 넣어줄 거임.
		
		User user = jdbc.queryForObject(sql,
				new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserEmail(rs.getString("user_email"));
				user.setUserAddr(rs.getString("user_addr"));
				user.setUserJob(rs.getString("user_job"));
				user.setUserLike(rs.getString("user_like"));
				
				return user;
				
			}
			
		}, id);
		
		return user;
	}

	public void update(User user) {
		String sql = "update user set user_pw=?, user_email=?, user_addr=?, user_job=?, user_like=? where user_id=?";
		
		jdbc.update(sql, user.getUserPw(), user.getUserEmail(), user.getUserAddr(), user.getUserJob(), user.getUserLike(), user.getUserId());
		
		
	}

}