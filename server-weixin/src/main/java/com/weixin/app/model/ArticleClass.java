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
 * 资讯栏目模型
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_article_classes")
public class ArticleClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 栏目状态：1表示有效, 0表示无效
	 */
	public static final String VALID = "1";
	public static final String INVALID = "0";
	
	/**
	 * 栏目等级
	 */
	public static final Integer DEPTH_LEVEL_1 = 1;
	public static final Integer DEPTH_LEVEL_2 = 2;
	public static final Integer DEPTH_LEVEL_3 = 3;
	public static final Integer DEPTH_LEVEL_4 = 4;
	public static final Integer DEPTH_LEVEL_5 = 5;
	/**
	 * 目录为一级的parentId取值
	 */
	public static final Integer ROOT = 0;
	
	/**
	 * 是否是文章栏目，yes是，no不是
	 */
	public static final String ISARTICLE_YES = "yes";
	public static final String ISARTICLE_NO = "no";
	
	/**
	 * 是否显示为导航条，用于前台页面导航控制，1是，0不是
	 */
	public static final String ISNAV_YES = "1";
	public static final String ISNAV_NO = "0";
	
	/**
     * 内部编号
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;
    
    /**
     * 关联父栏目
     */
    @OneToOne(targetEntity = ArticleClass.class, cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_article_class_id")
    private ArticleClass parentArticleClass;
    
    /**
     * 栏目父ID, 若为一级栏目，此项值为0
     */
    @Column(name = "parent_id", length = 11)
    private Integer parentId;
    
    /**
     * 栏目级别
     */
    @Column(name = "depth", length = 11)
    private Integer depth;
    
    /**
     * 栏目一级目录ID
     */
    @Column(name = "root_id", length = 11)
    private Integer rootId;
    
    /**
     * 栏目概要
     */
    @Column(name = "summary")
    @Lob
    private String summary;
    
    /**
     * 栏目状态
     */
    @Column(name = "status", length = 1)
    private String status;
    
    /**
     * 唯一标识
     */
    @Column(name = "mark")
    private String mark;
    
    /**
	 * 缩略图
	 */
	@Column(name = "thumbnail")
	private String thumbnail;
    
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
	
	/**
	 * 是否是文章栏目
	 */
	@Column(name = "is_article", length = 3)
	private String isArticle;
	
	/**
	 * 是否是文章栏目
	 */
	@Column(name = "is_nav", length = 3)
	private String isNav;
	
	 /**
     * 文章栏目所对应的内容
     */
    /*@Column(name = "content")
    @Lob*/
	@Transient
    private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public Integer getRootId() {
		return rootId;
	}

	public void setRootId(Integer rootId) {
		this.rootId = rootId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public ArticleClass getParentArticleClass() {
		return parentArticleClass;
	}

	public void setParentArticleClass(ArticleClass parentArticleClass) {
		this.parentArticleClass = parentArticleClass;
	}

	public String getIsArticle() {
		return isArticle;
	}

	public void setIsArticle(String isArticle) {
		this.isArticle = isArticle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getIsNav() {
		return isNav;
	}

	public void setIsNav(String isNav) {
		this.isNav = isNav;
	}
	
    
}
