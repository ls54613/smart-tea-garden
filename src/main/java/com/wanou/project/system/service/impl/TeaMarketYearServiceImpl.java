package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaMarketYearMapper;
import com.wanou.project.system.domain.TeaMarketYear;
import com.wanou.project.system.service.ITeaMarketYearService;

/**
 * 茶市基本情况表Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-02
 */
@Service
public class TeaMarketYearServiceImpl implements ITeaMarketYearService
{
    @Autowired
    private TeaMarketYearMapper teaMarketYearMapper;

    /**
     * 查询茶市基本情况表
     *
     * @param id 茶市基本情况表主键
     * @return 茶市基本情况表
     */
    @Override
    public TeaMarketYear selectTeaMarketYearById(Long id)
    {
        return teaMarketYearMapper.selectTeaMarketYearById(id);
    }

    /**
     * 查询茶市基本情况表列表
     *
     * @param teaMarketYear 茶市基本情况表
     * @return 茶市基本情况表
     */
    @Override
    public List<TeaMarketYear> selectTeaMarketYearList(TeaMarketYear teaMarketYear)
    {
        return teaMarketYearMapper.selectTeaMarketYearList(teaMarketYear);
    }

    /**
     * 新增茶市基本情况表
     *
     * @param teaMarketYear 茶市基本情况表
     * @return 结果
     */
    @Override
    public int insertTeaMarketYear(TeaMarketYear teaMarketYear)
    {
        return teaMarketYearMapper.insertTeaMarketYear(teaMarketYear);
    }

    /**
     * 修改茶市基本情况表
     *
     * @param teaMarketYear 茶市基本情况表
     * @return 结果
     */
    @Override
    public int updateTeaMarketYear(TeaMarketYear teaMarketYear)
    {
        return teaMarketYearMapper.updateTeaMarketYear(teaMarketYear);
    }

    /**
     * 批量删除茶市基本情况表
     *
     * @param ids 需要删除的茶市基本情况表主键
     * @return 结果
     */
    @Override
    public int deleteTeaMarketYearByIds(Long[] ids)
    {
        return teaMarketYearMapper.deleteTeaMarketYearByIds(ids);
    }

    /**
     * 删除茶市基本情况表信息
     *
     * @param id 茶市基本情况表主键
     * @return 结果
     */
    @Override
    public int deleteTeaMarketYearById(Long id)
    {
        return teaMarketYearMapper.deleteTeaMarketYearById(id);
    }
}
