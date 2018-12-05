package cn.ok.demos.druidmonitordemo.repository;

import cn.ok.demos.druidmonitordemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
