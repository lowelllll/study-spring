package main;

import config.AppConfig;
import config.AppCtx;
import config.DbConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForSpring {

    private static ApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class, AppCtx.class, DbConfig.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("명령어를 입력하세용");
            String command = reader.readLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다");
                break;
            }

            if (command.startsWith("new")) {
                processNewCommand(command.split(" "));
            } else if (command.startsWith(("change"))) {
                processChangeCommand(command.split(" "));
            } else if (command.startsWith("list")) {
                processListCommand();
            } else if (command.startsWith("info")) {
                processInfoCommand(command.split(" "));
            } else if (command.startsWith("version")) {
                processVersionCommand();
            } else {
                printHelp();
            }
        }
    }

    private static void processNewCommand(String[] args) {
        if (args.length != 5) {
            printHelp();
            return;
        }

        MemberRegisterService registerService = ctx.getBean( MemberRegisterService.class);
        RegisterRequest request = new RegisterRequest();

        request.setEmail(args[1]);
        request.setName(args[2]);
        request.setPassword(args[3]);
        request.setConfirmPassword(args[4]);

        if (!request.isPasswordEqualToConfirmPassword()){
            System.out.println("암호와 확인이 일치하지 않습니다");
            return;
        }

        try {
            registerService.register(request);
            System.out.println("등록했습니다");
        } catch (DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일입니다");
        }
    }

    public static void processChangeCommand(String[] args) {
        if (args.length != 4) {
            printHelp();
            return;
        }

        ChangePasswordService changePasswordService = ctx.getBean(ChangePasswordService.class);

        try {
            changePasswordService.changePassword(args[1], args[2], args[3]);
            System.out.println("암호를 변경했습니다!");
        } catch (MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일입니다.");
        } catch (WrongIdPasswordException e) {
            System.out.println("이메일과 암호가 일치하지 않습니다");
        }
    }

    public static void processListCommand() {
        MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
        listPrinter.printAll();
    }

    public static void processInfoCommand(String[] args) {
        if (args.length != 2) {
            printHelp();
            return;
        }

        MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
        infoPrinter.printMemberInfo(args[1]);
    }

    public static void processVersionCommand() {
        VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
        versionPrinter.print();
    }

    public static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인해보세요");
        System.out.println("멤버 생성: new [이메일] [이름] [암호] [암호확인]");
        System.out.println("멤버 비밀번호 수정: change [이메일] [현재 비밀번호] [변경 비밀번호]");
        System.out.println();
    }
}
