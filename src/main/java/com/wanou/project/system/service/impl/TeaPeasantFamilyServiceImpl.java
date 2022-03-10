package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaPeasantFamilyMapper;
import com.wanou.project.system.domain.TeaPeasantFamily;
import com.wanou.project.system.service.ITeaPeasantFamilyService;

/**
 * 茶农家庭成员Service业务层处理
 *
 * @author MrYao
 * @date 2022-03-03
 */
@Service
public class TeaPeasantFamilyServiceImpl implements ITeaPeasantFamilyService
{
    @Autowired
    private TeaPeasantFamilyMapper teaPeasantFamilyMapper;

    /**
     * 查询茶农家庭成员
     *
     * @param id 茶农家庭成员主键
     * @return 茶农家庭成员
     */
    @Override
    public TeaPeasantFamily selectTeaPeasantFamilyById(Long id)
    {
        return teaPeasantFamilyMapper.selectTeaPeasantFamilyById(id);
    }

    /**
     * 查询茶农家庭成员列表
     *
     * @param teaPeasantFamily 茶农家庭成员
     * @return 茶农家庭成员
     */
    @Override
    public List<TeaPeasantFamily> selectTeaPeasantFamilyList(TeaPeasantFamily teaPeasantFamily)
    {
        return teaPeasantFamilyMapper.selectTeaPeasantFamilyList(teaPeasantFamily);
    }

    /**
     * 新增茶农家庭成员
     *
     * @param teaPeasantFamily 茶农家庭成员
     * @return 结果
     */
    @Override
    public int insertTeaPeasantFamily(TeaPeasantFamily teaPeasantFamily)
    {
        return teaPeasantFamilyMapper.insertTeaPeasantFamily(teaPeasantFamily);
    }

    /**
     * 修改茶农家庭成员
     *
     * @param teaPeasantFamily 茶农家庭成员
     * @return 结果
     */
    @Override
    public int updateTeaPeasantFamily(TeaPeasantFamily teaPeasantFamily)
    {
        return teaPeasantFamilyMapper.updateTeaPeasantFamily(teaPeasantFamily);
    }

    /**
     * 批量删除茶农家庭成员
     *
     * @param ids 需要删除的茶农家庭成员主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantFamilyByIds(Long[] ids)
    {
        return teaPeasantFamilyMapper.deleteTeaPeasantFamilyByIds(ids);
    }

    /**
     * 删除茶农家庭成员信息
     *
     * @param id 茶农家庭成员主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantFamilyById(Long id)
    {
        return teaPeasantFamilyMapper.deleteTeaPeasantFamilyById(id);
    }

    @Override
    public TeaPeasantFamily getMemberOfFamily(long teaPeasantId) {

        return teaPeasantFamilyMapper.getMemberOfFamily(teaPeasantId);
    }
}
