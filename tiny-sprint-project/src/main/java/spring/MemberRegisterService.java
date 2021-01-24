package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;

//    public MemberRegisterService(MemberDao memberDao) {
//        this.memberDao = memberDao;
//    }

    public Long register(RegisterRequest request) {
        Member member = memberDao.selectByEmail(request.getEmail());
        if (member != null)
            throw new DuplicateMemberException("이메일이 중복됩니다.");

        Member newMember = new Member(request.getEmail(), request.getPassword(), request.getName(), LocalDateTime.now());
        memberDao.insert(newMember);

        return newMember.getId();
    }
}
