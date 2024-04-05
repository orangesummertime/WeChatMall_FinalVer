
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 商品盘点
 * 后端接口

*/
@RestController
@Controller
@RequestMapping("/shangpinPandian")
public class ShangpinPandianController {
    private static final Logger logger = LoggerFactory.getLogger(ShangpinPandianController.class);

    private static final String TABLE_NAME = "shangpinPandian";

    @Autowired
    private ShangpinPandianService shangpinPandianService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private ShangpinService shangpinService;
    //注册表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = shangpinPandianService.queryPage(params);

        //字典表数据转换
        List<ShangpinPandianView> list =(List<ShangpinPandianView>)page.getList();
        for(ShangpinPandianView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShangpinPandianEntity shangpinPandian = shangpinPandianService.selectById(id);
        if(shangpinPandian !=null){
            //entity转view
            ShangpinPandianView view = new ShangpinPandianView();
            BeanUtils.copyProperties( shangpinPandian , view );//把实体数据重构到view中
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(shangpinPandian.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //级联表 商品
            //级联表
            ShangpinEntity shangpin = shangpinService.selectById(shangpinPandian.getShangpinId());
            if(shangpin != null){
            BeanUtils.copyProperties( shangpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShangpinId(shangpin.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinPandianEntity shangpinPandian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shangpinPandian:{}",this.getClass().getName(),shangpinPandian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            shangpinPandian.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));


        ShangpinEntity shangpinEntity = shangpinService.selectById(shangpinPandian.getShangpinId());
        if(shangpinEntity == null){
            return R.error("查不到商品");
        }

        Integer shangpinKucunNumber = shangpinEntity.getShangpinKucunNumber();
        Integer shangpinPandianHouNumber = shangpinPandian.getShangpinPandianHouNumber();
        shangpinPandian.setShangpinPandianQianNumber(shangpinKucunNumber);
        shangpinPandian.setShangpinPandianChaNumber(String.valueOf(shangpinPandianHouNumber-shangpinKucunNumber));
        shangpinPandian.setInsertTime(new Date());
        shangpinPandian.setCreateTime(new Date());
        shangpinPandianService.insert(shangpinPandian);
        if(shangpinKucunNumber.intValue() != shangpinPandianHouNumber.intValue()){
            shangpinEntity.setShangpinKucunNumber(shangpinPandianHouNumber);
            shangpinService.updateById(shangpinEntity);
        }

            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpinPandianEntity shangpinPandian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shangpinPandian:{}",this.getClass().getName(),shangpinPandian.toString());
        ShangpinPandianEntity oldShangpinPandianEntity = shangpinPandianService.selectById(shangpinPandian.getId());//查询原先数据

            shangpinPandianService.updateById(shangpinPandian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShangpinPandianEntity> oldShangpinPandianList =shangpinPandianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shangpinPandianService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShangpinPandianEntity> shangpinPandianList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShangpinPandianEntity shangpinPandianEntity = new ShangpinPandianEntity();
//                            shangpinPandianEntity.setShangpinId(Integer.valueOf(data.get(0)));   //商品 要改的
//                            shangpinPandianEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            shangpinPandianEntity.setShangpinPandianQianNumber(Integer.valueOf(data.get(0)));   //盘点前数量 要改的
//                            shangpinPandianEntity.setShangpinPandianHouNumber(Integer.valueOf(data.get(0)));   //盘点数量 要改的
//                            shangpinPandianEntity.setShangpinPandianChaNumber(data.get(0));                    //差数量 要改的
//                            shangpinPandianEntity.setShangpinPandianContent("");//详情和图片
//                            shangpinPandianEntity.setInsertTime(date);//时间
//                            shangpinPandianEntity.setCreateTime(date);//时间
                            shangpinPandianList.add(shangpinPandianEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        shangpinPandianService.insertBatch(shangpinPandianList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shangpinPandianService.queryPage(params);

        //字典表数据转换
        List<ShangpinPandianView> list =(List<ShangpinPandianView>)page.getList();
        for(ShangpinPandianView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShangpinPandianEntity shangpinPandian = shangpinPandianService.selectById(id);
            if(shangpinPandian !=null){


                //entity转view
                ShangpinPandianView view = new ShangpinPandianView();
                BeanUtils.copyProperties( shangpinPandian , view );//把实体数据重构到view中

                //级联表
                    YuangongEntity yuangong = yuangongService.selectById(shangpinPandian.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
                //级联表
                    ShangpinEntity shangpin = shangpinService.selectById(shangpinPandian.getShangpinId());
                if(shangpin != null){
                    BeanUtils.copyProperties( shangpin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangpinId(shangpin.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinPandianEntity shangpinPandian, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shangpinPandian:{}",this.getClass().getName(),shangpinPandian.toString());
        Wrapper<ShangpinPandianEntity> queryWrapper = new EntityWrapper<ShangpinPandianEntity>()
            .eq("shangpin_id", shangpinPandian.getShangpinId())
            .eq("yuangong_id", shangpinPandian.getYuangongId())
            .eq("shangpin_pandian_qian_number", shangpinPandian.getShangpinPandianQianNumber())
            .eq("shangpin_pandian_hou_number", shangpinPandian.getShangpinPandianHouNumber())
            .eq("shangpin_pandian_cha_number", shangpinPandian.getShangpinPandianChaNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpinPandianEntity shangpinPandianEntity = shangpinPandianService.selectOne(queryWrapper);
        if(shangpinPandianEntity==null){
            shangpinPandian.setInsertTime(new Date());
            shangpinPandian.setCreateTime(new Date());
        shangpinPandianService.insert(shangpinPandian);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
