package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * # 의존 관계 주입(Dependency Injection)
 * : Application의 실제 동작에 필요한 구현 객체를
 * 생성자를 통해서 의존 객체(Dependency)를 생성 후 주입(연결, Injection)하는 역할을 수행
 */
public class AppConfig {

    // 구현 정의 -------------------------------------------------------------
    //생성자 주입 : 생성자를 통해서 객체를 주입 한다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 역할 정의 ------------------------------------------------------------
    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
