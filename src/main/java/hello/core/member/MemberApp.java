package hello.core.member;

import hello.core.AppConfig;

public class MemberApp
{
    public static void main(String[] args) {
        AppConfig config = new AppConfig();

        MemberService memberService = config.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("Member = = find member" + member.equals(findMember));

    }
}
