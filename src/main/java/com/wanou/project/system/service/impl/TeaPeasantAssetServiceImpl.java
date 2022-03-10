package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaPeasantAssetMapper;
import com.wanou.project.system.domain.TeaPeasantAsset;
import com.wanou.project.system.service.ITeaPeasantAssetService;

/**
 * 茶农资产状况Service业务层处理
 *
 * @author MrYao
 * @date 2022-03-02
 */
@Service
public class TeaPeasantAssetServiceImpl implements ITeaPeasantAssetService
{
    @Autowired
    private TeaPeasantAssetMapper teaPeasantAssetMapper;

    /**
     * 查询茶农资产状况
     *
     * @param id 茶农资产状况主键
     * @return 茶农资产状况
     */
    @Override
    public TeaPeasantAsset selectTeaPeasantAssetById(Long id)
    {
        return teaPeasantAssetMapper.selectTeaPeasantAssetById(id);
    }

    /**
     * 查询茶农资产状况列表
     *
     * @param teaPeasantAsset 茶农资产状况
     * @return 茶农资产状况
     */
    @Override
    public List<TeaPeasantAsset> selectTeaPeasantAssetList(TeaPeasantAsset teaPeasantAsset)
    {
        return teaPeasantAssetMapper.selectTeaPeasantAssetList(teaPeasantAsset);
    }

    /**
     * 新增茶农资产状况
     *
     * @param teaPeasantAsset 茶农资产状况
     * @return 结果
     */
    @Override
    public int insertTeaPeasantAsset(TeaPeasantAsset teaPeasantAsset)
    {
        return teaPeasantAssetMapper.insertTeaPeasantAsset(teaPeasantAsset);
    }

    /**
     * 修改茶农资产状况
     *
     * @param teaPeasantAsset 茶农资产状况
     * @return 结果
     */
    @Override
    public int updateTeaPeasantAsset(TeaPeasantAsset teaPeasantAsset)
    {
        return teaPeasantAssetMapper.updateTeaPeasantAsset(teaPeasantAsset);
    }

    /**
     * 批量删除茶农资产状况
     *
     * @param ids 需要删除的茶农资产状况主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantAssetByIds(Long[] ids)
    {
        return teaPeasantAssetMapper.deleteTeaPeasantAssetByIds(ids);
    }

    /**
     * 删除茶农资产状况信息
     *
     * @param id 茶农资产状况主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantAssetById(Long id)
    {
        return teaPeasantAssetMapper.deleteTeaPeasantAssetById(id);
    }

    @Override
    public TeaPeasantAsset getpeasantasset(long teaPeasantId) {
        return teaPeasantAssetMapper.getpeasantasset(teaPeasantId);
    }
}
