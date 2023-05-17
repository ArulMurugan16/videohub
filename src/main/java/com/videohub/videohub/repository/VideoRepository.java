package com.videohub.videohub.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videohub.videohub.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}
