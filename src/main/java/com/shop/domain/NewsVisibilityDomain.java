package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "news_visibility_domain")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class NewsVisibilityDomain extends DomainObject {

	public NewsVisibilityDomain(){}
	
	public NewsVisibilityDomain(News news, VisibilityDomain vd){
		super();
		this.news = news;
		this.visibilityDomain = vd;
	}
	
	@ManyToOne
	private News news;

	/**
	 * What visibility type does this news have and what is the name of the
	 * group
	 **/
	@ManyToOne
	private VisibilityDomain visibilityDomain;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public VisibilityDomain getVisibilityDomain() {
		return visibilityDomain;
	}

	public void setVisibilityDomain(VisibilityDomain visibilityDomain) {
		this.visibilityDomain = visibilityDomain;
	}

}
