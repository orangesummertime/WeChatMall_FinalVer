package com.entity.vo;

import com.entity.ShangpinPandianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品盘点
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shangpin_pandian")
public class ShangpinPandianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商品
     */

    @TableField(value = "shangpin_id")
    private Integer shangpinId;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 盘点前数量
     */

    @TableField(value = "shangpin_pandian_qian_number")
    private Integer shangpinPandianQianNumber;


    /**
     * 盘点数量
     */

    @TableField(value = "shangpin_pandian_hou_number")
    private Integer shangpinPandianHouNumber;


    /**
     * 差数量
     */

    @TableField(value = "shangpin_pandian_cha_number")
    private String shangpinPandianChaNumber;


    /**
     * 盘点备注
     */

    @TableField(value = "shangpin_pandian_content")
    private String shangpinPandianContent;


    /**
     * 盘点时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：商品
	 */
    public Integer getShangpinId() {
        return shangpinId;
    }


    /**
	 * 获取：商品
	 */

    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：盘点前数量
	 */
    public Integer getShangpinPandianQianNumber() {
        return shangpinPandianQianNumber;
    }


    /**
	 * 获取：盘点前数量
	 */

    public void setShangpinPandianQianNumber(Integer shangpinPandianQianNumber) {
        this.shangpinPandianQianNumber = shangpinPandianQianNumber;
    }
    /**
	 * 设置：盘点数量
	 */
    public Integer getShangpinPandianHouNumber() {
        return shangpinPandianHouNumber;
    }


    /**
	 * 获取：盘点数量
	 */

    public void setShangpinPandianHouNumber(Integer shangpinPandianHouNumber) {
        this.shangpinPandianHouNumber = shangpinPandianHouNumber;
    }
    /**
	 * 设置：差数量
	 */
    public String getShangpinPandianChaNumber() {
        return shangpinPandianChaNumber;
    }


    /**
	 * 获取：差数量
	 */

    public void setShangpinPandianChaNumber(String shangpinPandianChaNumber) {
        this.shangpinPandianChaNumber = shangpinPandianChaNumber;
    }
    /**
	 * 设置：盘点备注
	 */
    public String getShangpinPandianContent() {
        return shangpinPandianContent;
    }


    /**
	 * 获取：盘点备注
	 */

    public void setShangpinPandianContent(String shangpinPandianContent) {
        this.shangpinPandianContent = shangpinPandianContent;
    }
    /**
	 * 设置：盘点时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：盘点时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
