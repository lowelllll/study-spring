package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(2)
public class ExeTimeAspect {

    @Pointcut("execution(* service..*(..))") // 공통 기능을 적용할 대상 설정
    private void publicTarget() {
    }

    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            return joinPoint.proceed(); // 대상 객체의 메서드 호출
        } finally {
            long end = System.nanoTime();
            Signature sig = joinPoint.getSignature(); // 호출한 메서드의 시그니처
            System.out.printf("signature: %s\n", sig);
            System.out.printf("%s.factorial(%s) 실행시간 = %d\n", joinPoint.getTarget().getClass().getSimpleName(), Arrays.toString(joinPoint.getArgs()), end-start);
        }
    }
}
