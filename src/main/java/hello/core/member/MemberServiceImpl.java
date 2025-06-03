package hello.core.member;

public class MemberServiceImpl implements MemberService{


    private final MemberRepository memberRepository;

    // 의존관계를 외부(AppConfig)에서 주입되는 형태로 객체를 할당받는다.
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
