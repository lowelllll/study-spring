package spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
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
    }

    public void update(Member member) {
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
