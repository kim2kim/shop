package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.SecurityLevel;

/**
 * Allows users to make comments on news.
 * 
 * @author khim.ung
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="news_comment")
public class NewsComment extends DomainObject {

	@ManyToOne
	private News news;

	/**
	 * This is the person who made the comment on the news. If security level is
	 * set to private, they are the only person who can see their own comment.
	 */
	@ManyToOne
	private Person commenter;

	@Column(length = 500)
	private String message;

	/**
	 * Unless you specifically specify the security leve, all security level
	 * will be set to public.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="security_level")
	private SecurityLevel securityLevel = SecurityLevel.PUBLIC;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Person getCommenter() {
		return commenter;
	}

	public void setCommenter(Person commenter) {
		this.commenter = commenter;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(SecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}

}
