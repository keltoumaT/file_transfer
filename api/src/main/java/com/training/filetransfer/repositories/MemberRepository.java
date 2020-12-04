package com.training.filetransfer.repositories;

import com.training.filetransfer.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

        Member getByEmail(String email);
}
