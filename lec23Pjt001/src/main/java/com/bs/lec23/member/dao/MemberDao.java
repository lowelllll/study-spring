package com.bs.lec23.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bs.lec23.member.Member;

@Repository
public class MemberDao implements IMemberDao {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/lowell?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
	private String userid = "root";
	private String userpw = "";

	private DriverManagerDataSource dataSource;
	private JdbcTemplate template;

	public MemberDao() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(userid);
		dataSource.setPassword(userpw);

		template = new JdbcTemplate();
		template.setDataSource(dataSource);
	}

	@Override
	public int memberInsert(Member member) {
		String sql = "INSERT INTO member (memId, memPw, memMail) values (?,?,?)";

		return template.update(sql, member.getMemId(), member.getMemPw(), member.getMemMail());
	}

	@Override
	public Member memberSelect(Member member) {
		
		List<Member> members = null;
		final String sql = "SELECT * FROM member WHERE memId = ? AND memPw = ?";

		members = template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMemId());
				pstmt.setString(2, member.getMemPw());
			}
		}, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member mem = new Member();
				mem.setMemId(rs.getString("memId"));
				mem.setMemPw(rs.getString("memPw"));
				mem.setMemMail(rs.getString("memMail"));
				mem.setMemPurchaseNum(rs.getInt("memPurchaseNum"));
				return mem;
			}
		});

		if (members.isEmpty()) return null;

		return members.get(0);
	}

	@Override
	public int memberUpdate(Member member) {
		String sql = "UPDATE member SET memPw = ?, memMail = ? WHERE memId = ?";
		return template.update(sql, member.getMemPw(), member.getMemMail(), member.getMemId());
	}

	@Override
	public int memberDelete(Member member) {
		String sql = "DELETE member WHERE memId = ? AND memPw = ?";
		return template.update(sql, member.getMemId(), member.getMemPw());
	}

}