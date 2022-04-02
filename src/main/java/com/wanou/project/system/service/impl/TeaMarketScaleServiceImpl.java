package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaMarketScaleMapper;
import com.wanou.project.system.domain.TeaMarketScale;
import com.wanou.project.system.service.ITeaMarketScaleService;

/**
 * 2021年各品种产量占比情况Service业务层处理
 *
 * @author MrYao
 * @date 2022-04-02
 */
@Service
public class TeaMarketScaleServiceImpl implements ITeaMarketScaleService
{
    @Autowired
    private TeaMarketScaleMapper teaMarketScaleMapper;

    /**
     * 查询2021年各品种产量占比情况
     *
     * @param id 2021年各品种产量占比情况主键
     * @return 2021年各品种产量占比情况
     */
    @Override
    public TeaMarketScale selectTeaMarketScaleById(Long id)
    {
        return teaMarketScaleMapper.selectTeaMarketScaleById(id);
    }

    /**
     * 查询2021年各品种产量占比情况列表
     *
     * @param teaMarketScale 2021年各品种产量占比情况
     * @return 2021年各品种产量占比情况
     */
    @Override
    public List<TeaMarketScale> selectTeaMarketScaleList(TeaMarketScale teaMarketScale)
    {
        return teaMarketScaleMapper.selectTeaMarketScaleList(teaMarketScale);
    }

    /**
     * 新增2021年各品种产量占比情况
     *
     * @param teaMarketScale 2021年各品种产量占比情况
     * @return 结果
     */
    @Override
    public int insertTeaMarketScale(TeaMarketScale teaMarketScale)
    {
        return teaMarketScaleMapper.insertTeaMarketScale(teaMarketScale);
    }

    /**
     * 修改2021年各品种产量占比情况
     *
     * @param teaMarketScale 2021年各品种产量占比情况
     * @return 结果
     */
    @Override
    public int updateTeaMarketScale(TeaMarketScale teaMarketScale)
    {
        return teaMarketScaleMapper.updateTeaMarketScale(teaMarketScale);
    }

    /**
     * 批量删除2021年各品种产量占比情况
     *
     * @param ids 需要删除的2021年各品种产量占比情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaMarketScaleByIds(Long[] ids)
    {
        return teaMarketScaleMapper.deleteTeaMarketScaleByIds(ids);
    }

    /**
     * 删除2021年各品种产量占比情况信息
     *
     * @param id 2021年各品种产量占比情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaMarketScaleById(Long id)
    {
        return teaMarketScaleMapper.deleteTeaMarketScaleById(id);
    }
}
