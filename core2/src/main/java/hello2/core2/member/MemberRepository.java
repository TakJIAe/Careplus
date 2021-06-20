package hello2.core2.member;

public interface MemberRepository {

    void save(Member member); //회원 저장

    Member findById(Long memberId); //회원 아이디찾기
}
