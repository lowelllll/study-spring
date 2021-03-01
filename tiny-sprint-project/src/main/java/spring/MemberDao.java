package spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collection;
import java.util.List;

@Component
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query(
                "select * from member where email = ?",
                (ResultSet rs, int rowNum) -> {
                    Member member = new Member(
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getTimestamp("registered_at").toLocalDateTime()
                    );
                    member.setId(rs.getLong("id"));
                    return member;
                },
                email
        );
        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "insert into member (email, name, password, registered_at) values (?, ?, ?, ?)",
                        new String[]{"id"}
                );
                preparedStatement.setString(1, member.getEmail());
                preparedStatement.setString(2, member.getName());
                preparedStatement.setString(3, member.getPassword());
                preparedStatement.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
                return preparedStatement;
            }
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }

    public void update(Member member) {
        jdbcTemplate.update(
                "update member set name = ?, password = ? where email = ?",
                member.getName(),
                member.getPassword(),
                member.getEmail()
        );
    }

    public Collection<Member> selectAll() {
        return jdbcTemplate.query(
                "select * from member",
                (ResultSet rs, int rowNum) -> {
                    Member member = new Member(
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getTimestamp("registered_at").toLocalDateTime()
                    );
                    member.setId(rs.getLong("id"));
                    return member;
                }
        );
    }

    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
    }


}
