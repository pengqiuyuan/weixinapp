package com.weixin.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 文章模型
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_article")
public class Article implements Serializable {
	
	/**
	 * 文章状态：1表示有效, 0表示无效
	 */
	public static final String VALID = "1";
	public static final String INVALID = "0";

	/**
     * 内部编号
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @OneToOne(targetEntity = ArticleClass.class, cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "article_class_id")
    private ArticleClass articleClass;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;
    
    /**
	 * 缩略图，用于手机展示
	 */
	@Column(name = "thumbnail")
	private String thumbnail;
	
	/**
	 * 缩略图，用于PC端展示
	 */
	@Column(name = "large_thumbnail")
	private String largeThumbnail;
    
	/**
     * 文章概要
     */
    @Column(name = "summary")
    @Lob
    private String summary;
	
    /**
     * 文章内容
     */
    @Column(name = "content")
    @Lob
    private String content;
    
    /**
     * 状态
     */
    @Column(name = "status", length = 1)
    private String status;
    
    /**
     * 继承所属栏目的标识
     */
    @Column(name = "article_class_mark")
    private String articleClassMark;
    
    /**
   	 * 数据生成时间
   	 */
   	@Column(name = "crt_date")
   	private Date crtDate;
   	
   	/**
   	 * 数据更改时间
   	 */
   	@Column(name = "update_date")
   	private Date updateDate;
   	
   	@Transient
   	private String isArticle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArticleClass getArticleClass() {
		return articleClass;
	}

	public void setArticleClass(ArticleClass articleClass) {
		this.articleClass = articleClass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getArticleClassMark() {
		return articleClassMark;
	}

	public void setArticleClassMark(String articleClassMark) {
		this.articleClassMark = articleClassMark;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getLargeThumbnail() {
		return largeThumbnail;
	}

	public void setLargeThumbnail(String largeThumbnail) {
		this.largeThumbnail = largeThumbnail;
	}

	public String getIsArticle() {
		return isArticle;
	}

	public void setIsArticle(String isArticle) {
		this.isArticle = isArticle;
	}
	
}
