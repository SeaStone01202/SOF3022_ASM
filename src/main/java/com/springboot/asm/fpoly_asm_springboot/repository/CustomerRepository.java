package com.springboot.asm.fpoly_asm_springboot.repository;

import com.springboot.asm.fpoly_asm_springboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
