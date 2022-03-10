package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaPeasantFamily;

/**
 * 茶农家庭成员Service接口
 *
 * @author MrYao
 * @date 2022-03-03
 */
public interface ITeaPeasantFamilyService
{
    /**
     * 查询茶农家庭成员
     *
     * @param id 茶农家庭成员主键
     * @return 茶农家庭成员
     */
    public TeaPeasantFamily selectTeaPeasantFamilyById(Long id);

    /**
     * 查询茶农家庭成员列表
     *
     * @param teaPeasantFamily 茶农家庭成员
     * @return 茶农家庭成员集合
     */
    public List<TeaPeasantFamily> selectTeaPeasantFamilyList(TeaPeasantFamily teaPeasantFamily);

    /**
     * 新增茶农家庭成员
     *
     * @param teaPeasantFamily 茶农家庭成员
     * @return 结果
     */
    public int insertTeaPeasantFamily(TeaPeasantFamily teaPeasantFamily);

    /**
     * 修改茶农家庭成员
     *
     * @param teaPeasantFamily 茶农家庭成员
     * @return 结果
     */
    public int updateTeaPeasantFamily(TeaPeasantFamily teaPeasantFamily);

    /**
     * 批量删除茶农家庭成员
     *
     * @param ids 需要删除的茶农家庭成员主键集合
     * @return 结果
     */
    public int deleteTeaPeasantFamilyByIds(Long[] ids);

    /**
     * 删除茶农家庭成员信息
     *
     * @param id 茶农家庭成员主键
     * @return 结果
     */
    public int deleteTeaPeasantFamilyById(Long id);


    public TeaPeasantFamily getMemberOfFamily(long teaPeasantId);
}
