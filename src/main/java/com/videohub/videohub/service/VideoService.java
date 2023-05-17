package com.videohub.videohub.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videohub.videohub.model.Video;
import com.videohub.videohub.repository.VideoRepository;

import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideoById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }

    public Video updateVideo(Long id, Video video) {
        Video existingVideo = videoRepository.findById(id).orElse(null);
        if (existingVideo != null) {
            existingVideo.setTitle(video.getTitle());
            existingVideo.setDescription(video.getDescription());
            existingVideo.setContent(video.getContent());
            return videoRepository.save(existingVideo);
        }
        return null;
    }

    public boolean deleteVideo(Long id) {
        Video existingVideo = videoRepository.findById(id).orElse(null);
        if (existingVideo != null) {
            videoRepository.delete(existingVideo);
            return true;
        }
        return false;
    }
}
