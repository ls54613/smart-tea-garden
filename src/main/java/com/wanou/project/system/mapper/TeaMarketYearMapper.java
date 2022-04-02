package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TeaMarketYear;

/**
 * 茶市基本情况表Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-02
 */
public interface TeaMarketYearMapper 
{
    /**
     * 查询茶市基本情况表
     * 
     * @param id 茶市基本情况表主键
     * @return 茶市基本情况表
     */
    public TeaMarketYear selectTeaMarketYearById(Long id);

    /**
     * 查询茶市基本情况表列表
     * 
     * @param teaMarketYear 茶市基本情况表
     * @return 茶市基本情况表集合
     */
    public List<TeaMarketYear> selectTeaMarketYearList(TeaMarketYear teaMarketYear);

    /**
     * 新增茶市基本情况表
     * 
     * @param teaMarketYear 茶市基本情况表
     * @return 结果
     */
    public int insertTeaMarketYear(TeaMarketYear teaMarketYear);

    /**
     * 修改茶市基本情况表
     * 
     * @param teaMarketYear 茶市基本情况表
     * @return 结果
     */
    public int updateTeaMarketYear(TeaMarketYear teaMarketYear);

    /**
     * 删除茶市基本情况表
     * 
     * @param id 茶市基本情况表主键
     * @return 结果
     */
    public int deleteTeaMarketYearById(Long id);

    /**
     * 批量删除茶市基本情况表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaMarketYearByIds(Long[] ids);
}
