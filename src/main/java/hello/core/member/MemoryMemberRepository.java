package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    //TODO HashMap으로 사용하면 동시성 이슈가 있기 때문에 ConcurrnetHashMap을 적용 해야한다.  -추가 공부 필요
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    public static class MemberApp
    {
        public static void main(String[] args) {
            MemberService memberService = new MemberServiceImpl();
            Member member = new Member(1L, "memberA", Grade.VIP);
            memberService.join(member);

            Member findMember = memberService.findMember(1L);

            System.out.println("Member = = find member" + member.equals(findMember));

        }
    }
}
