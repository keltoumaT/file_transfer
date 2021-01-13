package com.training.filetransfer.repositories;

import com.training.filetransfer.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

        Member getByEmail(String email);
}
