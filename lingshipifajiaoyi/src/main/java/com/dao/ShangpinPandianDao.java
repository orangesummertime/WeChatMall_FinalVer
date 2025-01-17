package com.dao;

import com.entity.ShangpinPandianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpinPandianView;

/**
 * 商品盘点 Dao 接口
 *
 * @author 
 */
public interface ShangpinPandianDao extends BaseMapper<ShangpinPandianEntity> {

   List<ShangpinPandianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
