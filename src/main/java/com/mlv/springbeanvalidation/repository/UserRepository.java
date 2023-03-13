package com.mlv.springbeanvalidation.repository;

import com.mlv.springbeanvalidation.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
