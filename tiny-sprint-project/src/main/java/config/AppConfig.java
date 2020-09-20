package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.MemberDao;
import spring.MemberPrinter;
import spring.MemberSummaryPrinter;

@Configuration
public class AppConfig {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(); // 싱글톤
    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    } // 빈 한정자 memberPrinter

    @Bean
    @Qualifier("summaryPrinter")
    public MemberPrinter memberPrinter2() { return new MemberSummaryPrinter(); } // 빈 한정자 printer

}
