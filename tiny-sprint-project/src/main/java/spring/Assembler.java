package spring;

public class Assembler {
    // 객체 조립
    // 객체를 생성하고 의존 객체를 주입하는 기능을 제공 

    private MemberDao memberDao;
    private MemberRegisterService registerService;
    private ChangePasswordService changePasswordService;

    public Assembler() {
        memberDao = new MemberDao();

        registerService = new MemberRegisterService(memberDao);
        changePasswordService = new ChangePasswordService();
        changePasswordService.setMemberDao(memberDao);
    }


    public MemberRegisterService getRegisterService() {
        return registerService;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public ChangePasswordService getChangePasswordService() {
        return changePasswordService;
    }
}
