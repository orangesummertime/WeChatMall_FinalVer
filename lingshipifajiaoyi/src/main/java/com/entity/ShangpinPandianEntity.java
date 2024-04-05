package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 商品盘点
 *
 * @author 
 * @email
 */
@TableName("shangpin_pandian")
public class ShangpinPandianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShangpinPandianEntity() {

	}

	public ShangpinPandianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 商品
     */
    @ColumnInfo(comment="商品",type="int(11)")
    @TableField(value = "shangpin_id")

    private Integer shangpinId;


    /**
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 盘点前数量
     */
    @ColumnInfo(comment="盘点前数量",type="int(11)")
    @TableField(value = "shangpin_pandian_qian_number")

    private Integer shangpinPandianQianNumber;


    /**
     * 盘点数量
     */
    @ColumnInfo(comment="盘点数量",type="int(11)")
    @TableField(value = "shangpin_pandian_hou_number")

    private Integer shangpinPandianHouNumber;


    /**
     * 差数量
     */
    @ColumnInfo(comment="差数量",type="varchar(200)")
    @TableField(value = "shangpin_pandian_cha_number")

    private String shangpinPandianChaNumber;


    /**
     * 盘点备注
     */
    @ColumnInfo(comment="盘点备注",type="text")
    @TableField(value = "shangpin_pandian_content")

    private String shangpinPandianContent;


    /**
     * 盘点时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="盘点时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "ShangpinPandian{" +
            ", id=" + id +
            ", shangpinId=" + shangpinId +
            ", yuangongId=" + yuangongId +
            ", shangpinPandianQianNumber=" + shangpinPandianQianNumber +
            ", shangpinPandianHouNumber=" + shangpinPandianHouNumber +
            ", shangpinPandianChaNumber=" + shangpinPandianChaNumber +
            ", shangpinPandianContent=" + shangpinPandianContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
