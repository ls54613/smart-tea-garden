package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TeaPeasantAnnual;
import com.wanou.project.system.domain.TeaPeasantAsset;
import org.apache.ibatis.annotations.Param;

/**
 * 茶农历年年收入Mapper接口
 *
 * @author MrYao
 * @date 2022-03-04
 */
public interface TeaPeasantAnnualMapper
{
    /**
     * 查询茶农历年年收入
     *
     * @param id 茶农历年年收入主键
     * @return 茶农历年年收入
     */
    public TeaPeasantAnnual selectTeaPeasantAnnualById(Long id);

    /**
     * 查询茶农历年年收入列表
     *
     * @param teaPeasantAnnual 茶农历年年收入
     * @return 茶农历年年收入集合
     */
    public List<TeaPeasantAnnual> selectTeaPeasantAnnualList(TeaPeasantAnnual teaPeasantAnnual);

    /**
     * 新增茶农历年年收入
     *
     * @param teaPeasantAnnual 茶农历年年收入
     * @return 结果
     */
    public int insertTeaPeasantAnnual(TeaPeasantAnnual teaPeasantAnnual);

    /**
     * 修改茶农历年年收入
     *
     * @param teaPeasantAnnual 茶农历年年收入
     * @return 结果
     */
    public int updateTeaPeasantAnnual(TeaPeasantAnnual teaPeasantAnnual);

    /**
     * 删除茶农历年年收入
     *
     * @param id 茶农历年年收入主键
     * @return 结果
     */
    public int deleteTeaPeasantAnnualById(Long id);

    /**
     * 批量删除茶农历年年收入
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaPeasantAnnualByIds(Long[] ids);



    TeaPeasantAnnual selectTeaPeasantAnnualByTeaPeasantIdAndYear(@Param("teaPeasantId") Long teaPeasantId,@Param("year") String year);

    void insertOrUpdate(TeaPeasantAnnual teaPeasantAnnual);


    TeaPeasantAnnual getPeasantAnnual(long teaPeasantId);

}
