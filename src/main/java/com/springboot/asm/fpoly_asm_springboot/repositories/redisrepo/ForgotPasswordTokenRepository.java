package com.springboot.asm.fpoly_asm_springboot.repositories.redisrepo;

import com.springboot.asm.fpoly_asm_springboot.entity.ForgotPasswordToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForgotPasswordTokenRepository extends CrudRepository<ForgotPasswordToken, String> {

}
