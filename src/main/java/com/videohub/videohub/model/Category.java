package com.videohub.videohub.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
	@SequenceGenerator(name = "category_generator")
	@Column(name = "category_id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	@Column(name = "language")
	private String language;

	@OneToMany
	@JoinColumn(name = "video_id")
	private List<Video> videos;

	// Constructors, getters, and setters

	public Category() {
		// Empty constructor needed for JPA
	}

	public Category(String title, String language) {
		this.title = title;
		this.language = language;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
}
