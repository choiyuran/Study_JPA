package com.itbank.simpleboard.repository;

import com.itbank.simpleboard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUseridAndUserpw(String userid, String userpw);

    Optional<Member> findUsernameByUserid(Long id);

}
