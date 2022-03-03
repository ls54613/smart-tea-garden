package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TeaPeasantAsset;

/**
 * 茶农资产状况Mapper接口
 * 
 * @author MrYao
 * @date 2022-03-02
 */
public interface TeaPeasantAssetMapper 
{
    /**
     * 查询茶农资产状况
     * 
     * @param id 茶农资产状况主键
     * @return 茶农资产状况
     */
    public TeaPeasantAsset selectTeaPeasantAssetById(Long id);

    /**
     * 查询茶农资产状况列表
     * 
     * @param teaPeasantAsset 茶农资产状况
     * @return 茶农资产状况集合
     */
    public List<TeaPeasantAsset> selectTeaPeasantAssetList(TeaPeasantAsset teaPeasantAsset);

    /**
     * 新增茶农资产状况
     * 
     * @param teaPeasantAsset 茶农资产状况
     * @return 结果
     */
    public int insertTeaPeasantAsset(TeaPeasantAsset teaPeasantAsset);

    /**
     * 修改茶农资产状况
     * 
     * @param teaPeasantAsset 茶农资产状况
     * @return 结果
     */
    public int updateTeaPeasantAsset(TeaPeasantAsset teaPeasantAsset);

    /**
     * 删除茶农资产状况
     * 
     * @param id 茶农资产状况主键
     * @return 结果
     */
    public int deleteTeaPeasantAssetById(Long id);

    /**
     * 批量删除茶农资产状况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaPeasantAssetByIds(Long[] ids);
}
