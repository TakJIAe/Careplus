package hello.hellospring;
import hello.hellospring.aop.TImeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

   /* @Bean
    public TImeTraceAop tImeTraceAop(){
        return new TImeTraceAop();//Spring bean에 직접 등록하면 쓰인다는걸 알 수 있다.
    }*/
}