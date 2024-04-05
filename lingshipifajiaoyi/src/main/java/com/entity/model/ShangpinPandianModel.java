package com.entity.model;

import com.entity.ShangpinPandianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品盘点
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShangpinPandianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商品
     */
    private Integer shangpinId;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 盘点前数量
     */
    private Integer shangpinPandianQianNumber;


    /**
     * 盘点数量
     */
    private Integer shangpinPandianHouNumber;


    /**
     * 差数量
     */
    private String shangpinPandianChaNumber;


    /**
     * 盘点备注
     */
    private String shangpinPandianContent;


    /**
     * 盘点时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：商品
	 */
    public Integer getShangpinId() {
        return shangpinId;
    }


    /**
	 * 设置：商品
	 */
    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：盘点前数量
	 */
    public Integer getShangpinPandianQianNumber() {
        return shangpinPandianQianNumber;
    }


    /**
	 * 设置：盘点前数量
	 */
    public void setShangpinPandianQianNumber(Integer shangpinPandianQianNumber) {
        this.shangpinPandianQianNumber = shangpinPandianQianNumber;
    }
    /**
	 * 获取：盘点数量
	 */
    public Integer getShangpinPandianHouNumber() {
        return shangpinPandianHouNumber;
    }


    /**
	 * 设置：盘点数量
	 */
    public void setShangpinPandianHouNumber(Integer shangpinPandianHouNumber) {
        this.shangpinPandianHouNumber = shangpinPandianHouNumber;
    }
    /**
	 * 获取：差数量
	 */
    public String getShangpinPandianChaNumber() {
        return shangpinPandianChaNumber;
    }


    /**
	 * 设置：差数量
	 */
    public void setShangpinPandianChaNumber(String shangpinPandianChaNumber) {
        this.shangpinPandianChaNumber = shangpinPandianChaNumber;
    }
    /**
	 * 获取：盘点备注
	 */
    public String getShangpinPandianContent() {
        return shangpinPandianContent;
    }


    /**
	 * 设置：盘点备注
	 */
    public void setShangpinPandianContent(String shangpinPandianContent) {
        this.shangpinPandianContent = shangpinPandianContent;
    }
    /**
	 * 获取：盘点时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：盘点时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
