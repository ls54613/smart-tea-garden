package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaMarketProportionMapper;
import com.wanou.project.system.domain.TeaMarketProportion;
import com.wanou.project.system.service.ITeaMarketProportionService;

/**
 * 2021年各品种产量占比情况Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-02
 */
@Service
public class TeaMarketProportionServiceImpl implements ITeaMarketProportionService
{
    @Autowired
    private TeaMarketProportionMapper teaMarketProportionMapper;

    /**
     * 查询2021年各品种产量占比情况
     *
     * @param id 2021年各品种产量占比情况主键
     * @return 2021年各品种产量占比情况
     */
    @Override
    public TeaMarketProportion selectTeaMarketProportionById(Long id)
    {
        return teaMarketProportionMapper.selectTeaMarketProportionById(id);
    }

    /**
     * 查询2021年各品种产量占比情况列表
     *
     * @param teaMarketProportion 2021年各品种产量占比情况
     * @return 2021年各品种产量占比情况
     */
    @Override
    public List<TeaMarketProportion> selectTeaMarketProportionList(TeaMarketProportion teaMarketProportion)
    {
        return teaMarketProportionMapper.selectTeaMarketProportionList(teaMarketProportion);
    }

    /**
     * 新增2021年各品种产量占比情况
     *
     * @param teaMarketProportion 2021年各品种产量占比情况
     * @return 结果
     */
    @Override
    public int insertTeaMarketProportion(TeaMarketProportion teaMarketProportion)
    {
        return teaMarketProportionMapper.insertTeaMarketProportion(teaMarketProportion);
    }

    /**
     * 修改2021年各品种产量占比情况
     *
     * @param teaMarketProportion 2021年各品种产量占比情况
     * @return 结果
     */
    @Override
    public int updateTeaMarketProportion(TeaMarketProportion teaMarketProportion)
    {
        return teaMarketProportionMapper.updateTeaMarketProportion(teaMarketProportion);
    }

    /**
     * 批量删除2021年各品种产量占比情况
     *
     * @param ids 需要删除的2021年各品种产量占比情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaMarketProportionByIds(Long[] ids)
    {
        return teaMarketProportionMapper.deleteTeaMarketProportionByIds(ids);
    }

    /**
     * 删除2021年各品种产量占比情况信息
     *
     * @param id 2021年各品种产量占比情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaMarketProportionById(Long id)
    {
        return teaMarketProportionMapper.deleteTeaMarketProportionById(id);
    }
}
