package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TeaMarketProportion;

/**
 * 2021年各品种产量占比情况Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-02
 */
public interface TeaMarketProportionMapper 
{
    /**
     * 查询2021年各品种产量占比情况
     * 
     * @param id 2021年各品种产量占比情况主键
     * @return 2021年各品种产量占比情况
     */
    public TeaMarketProportion selectTeaMarketProportionById(Long id);

    /**
     * 查询2021年各品种产量占比情况列表
     * 
     * @param teaMarketProportion 2021年各品种产量占比情况
     * @return 2021年各品种产量占比情况集合
     */
    public List<TeaMarketProportion> selectTeaMarketProportionList(TeaMarketProportion teaMarketProportion);

    /**
     * 新增2021年各品种产量占比情况
     * 
     * @param teaMarketProportion 2021年各品种产量占比情况
     * @return 结果
     */
    public int insertTeaMarketProportion(TeaMarketProportion teaMarketProportion);

    /**
     * 修改2021年各品种产量占比情况
     * 
     * @param teaMarketProportion 2021年各品种产量占比情况
     * @return 结果
     */
    public int updateTeaMarketProportion(TeaMarketProportion teaMarketProportion);

    /**
     * 删除2021年各品种产量占比情况
     * 
     * @param id 2021年各品种产量占比情况主键
     * @return 结果
     */
    public int deleteTeaMarketProportionById(Long id);

    /**
     * 批量删除2021年各品种产量占比情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaMarketProportionByIds(Long[] ids);
}
