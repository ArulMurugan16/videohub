package com.videohub.videohub.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "video_generator")
	@SequenceGenerator(name = "video_generator")
	@Column(name = "video_id")
	private Long id;

	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;

	@Lob
	@Column(name = "content")
	private byte[] content;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "user_id") // Replace "user_id" with the actual column name in the video table that
									// references the User entity.
	private EndUser user;

	// Constructors, getters, and setters

	public Video() {
		// Empty constructor needed for JPA
	}

	public Video(String title, String description, byte[] content, EndUser user) {
		this.title = title;
		this.description = description;
		this.content = content;
		this.user = user;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public EndUser getUser() {
		return user;
	}

	public void setUser(EndUser user) {
		this.user = user;
	}
}
