package com.mg.dev.postgres.api.Member.repository;

import com.mg.dev.postgres.api.Member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
