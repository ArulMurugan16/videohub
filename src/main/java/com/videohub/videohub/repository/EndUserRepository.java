package com.videohub.videohub.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videohub.videohub.model.EndUser;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser, Long> {
}
