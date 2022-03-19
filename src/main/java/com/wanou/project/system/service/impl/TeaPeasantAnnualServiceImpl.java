package com.wanou.project.system.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.wanou.project.system.domain.TeaPeasantAsset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaPeasantAnnualMapper;
import com.wanou.project.system.domain.TeaPeasantAnnual;
import com.wanou.project.system.service.ITeaPeasantAnnualService;

/**
 * 茶农历年年收入Service业务层处理
 *
 * @author MrYao
 * @date 2022-03-04
 */
@Service
public class TeaPeasantAnnualServiceImpl implements ITeaPeasantAnnualService
{
    @Autowired
    private TeaPeasantAnnualMapper teaPeasantAnnualMapper;

    /**
     * 查询茶农历年年收入
     *
     * @param id 茶农历年年收入主键
     * @return 茶农历年年收入
     */
    @Override
    public TeaPeasantAnnual selectTeaPeasantAnnualById(Long id)
    {
        return teaPeasantAnnualMapper.selectTeaPeasantAnnualById(id);
    }

    /**
     * 查询茶农历年年收入列表
     *
     * @param teaPeasantAnnual 茶农历年年收入
     * @return 茶农历年年收入
     */
    @Override
    public List<TeaPeasantAnnual> selectTeaPeasantAnnualList(TeaPeasantAnnual teaPeasantAnnual)
    {

        return teaPeasantAnnualMapper.selectTeaPeasantAnnualList(teaPeasantAnnual);
    }

    /**
     * 新增茶农历年年收入
     *
     * @param teaPeasantAnnual 茶农历年年收入
     * @return 结果
     */
    @Override
    public int insertTeaPeasantAnnual(TeaPeasantAnnual teaPeasantAnnual)
    {
        /*TeaPeasantAnnual teaPeasantAnnualInDB = teaPeasantAnnualMapper.selectTeaPeasantAnnualByTeaPeasantIdAndYear(teaPeasantAnnual.getTeaPeasantId(), teaPeasantAnnual.getYear());
        if(teaPeasantAnnualInDB == null){
            return teaPeasantAnnualMapper.insertTeaPeasantAnnual(teaPeasantAnnual);
        }
        teaPeasantAnnual.setId(teaPeasantAnnualInDB.getId());
        return teaPeasantAnnualMapper.updateTeaPeasantAnnual(teaPeasantAnnual);*/
        teaPeasantAnnualMapper.insertOrUpdate(teaPeasantAnnual);
        return 1;
    }

    /**
     * 修改茶农历年年收入
     *
     * @param teaPeasantAnnual 茶农历年年收入
     * @return 结果
     */
    @Override
    public int updateTeaPeasantAnnual(TeaPeasantAnnual teaPeasantAnnual)
    {
        return teaPeasantAnnualMapper.updateTeaPeasantAnnual(teaPeasantAnnual);
    }

    /**
     * 批量删除茶农历年年收入
     *
     * @param ids 需要删除的茶农历年年收入主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantAnnualByIds(Long[] ids)
    {
        return teaPeasantAnnualMapper.deleteTeaPeasantAnnualByIds(ids);
    }

    /**
     * 删除茶农历年年收入信息
     *
     * @param id 茶农历年年收入主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantAnnualById(Long id)
    {
        return teaPeasantAnnualMapper.deleteTeaPeasantAnnualById(id);
    }

    @Override
    public JSONObject getPeasantAnnual(long teaPeasantId) {
        return teaPeasantAnnualMapper.getPeasantAnnual(teaPeasantId);
    }


}
