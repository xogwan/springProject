package com.codefarm.codefarmer.repository.member;

import com.codefarm.codefarmer.entity.member.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {
}
