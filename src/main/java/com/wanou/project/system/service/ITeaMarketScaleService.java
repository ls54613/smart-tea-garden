package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaMarketScale;

/**
 * 2021年各品种产量占比情况Service接口
 * 
 * @author MrYao
 * @date 2022-04-02
 */
public interface ITeaMarketScaleService 
{
    /**
     * 查询2021年各品种产量占比情况
     * 
     * @param id 2021年各品种产量占比情况主键
     * @return 2021年各品种产量占比情况
     */
    public TeaMarketScale selectTeaMarketScaleById(Long id);

    /**
     * 查询2021年各品种产量占比情况列表
     * 
     * @param teaMarketScale 2021年各品种产量占比情况
     * @return 2021年各品种产量占比情况集合
     */
    public List<TeaMarketScale> selectTeaMarketScaleList(TeaMarketScale teaMarketScale);

    /**
     * 新增2021年各品种产量占比情况
     * 
     * @param teaMarketScale 2021年各品种产量占比情况
     * @return 结果
     */
    public int insertTeaMarketScale(TeaMarketScale teaMarketScale);

    /**
     * 修改2021年各品种产量占比情况
     * 
     * @param teaMarketScale 2021年各品种产量占比情况
     * @return 结果
     */
    public int updateTeaMarketScale(TeaMarketScale teaMarketScale);

    /**
     * 批量删除2021年各品种产量占比情况
     * 
     * @param ids 需要删除的2021年各品种产量占比情况主键集合
     * @return 结果
     */
    public int deleteTeaMarketScaleByIds(Long[] ids);

    /**
     * 删除2021年各品种产量占比情况信息
     * 
     * @param id 2021年各品种产量占比情况主键
     * @return 结果
     */
    public int deleteTeaMarketScaleById(Long id);
}
