package com.wanou.project.system.service.impl;

import java.util.List;

import cn.hutool.json.JSONObject;
import com.wanou.common.utils.SecurityUtils;
import com.wanou.project.system.domain.vo.TeaGardenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaGardenMapper;
import com.wanou.project.system.domain.TeaGarden;
import com.wanou.project.system.service.ITeaGardenService;
import org.springframework.transaction.annotation.Transactional;
import com.wanou.project.system.mapper.TeaGardenTeaTypeMapper;
import com.wanou.project.system.mapper.TeaGardenSoilMonitorMapper;
import com.wanou.project.system.mapper.TeaGardenDiseaseMapper;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-03
 */
@Service
public class TeaGardenServiceImpl implements ITeaGardenService
{
    @Autowired
    private TeaGardenMapper teaGardenMapper;
    @Autowired
    private TeaGardenTeaTypeMapper teaGardenTeaTypeMapper;
    @Autowired
    private TeaGardenSoilMonitorMapper teaGardenSoilMonitorMapper;
    @Autowired
    private TeaGardenDiseaseMapper teaGardenDiseaseMapper;


    /**
     * 查询【请填写功能名称】
     *
     * @param teaGardenId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TeaGarden selectTeaGardenByTeaGardenId(Long teaGardenId)
    {
        return teaGardenMapper.selectTeaGardenByTeaGardenId(teaGardenId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param teaGarden 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TeaGarden> selectTeaGardenList(TeaGarden teaGarden)
    {
        if(teaGarden.getDeptId() == null){
            teaGarden.setDeptId(SecurityUtils.getDeptId());
        }
        return teaGardenMapper.selectTeaGardenList(teaGarden);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param teaGarden 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTeaGarden(TeaGarden teaGarden)
    {
        return teaGardenMapper.insertTeaGarden(teaGarden);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param teaGarden 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTeaGarden(TeaGarden teaGarden)
    {
        return teaGardenMapper.updateTeaGarden(teaGarden);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param teaGardenIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteTeaGardenByTeaGardenIds(Long[] teaGardenIds)
    {
        int i = teaGardenMapper.deleteTeaGardenByTeaGardenIds(teaGardenIds);
        teaGardenTeaTypeMapper.deleteTeaGardenTeaTypeByteaGardenId(teaGardenIds);
        teaGardenSoilMonitorMapper.deleteTeaGardenTeaGardenSoilMonitorByTeaGardenId(teaGardenIds);
        teaGardenDiseaseMapper.deleteTeaGardenDiseaseByTeaGardenId(teaGardenIds);
        return i;
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param teaGardenId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTeaGardenByTeaGardenId(Long teaGardenId)
    {
        return teaGardenMapper.deleteTeaGardenByTeaGardenId(teaGardenId);
    }

    @Override
    public List<TeaGardenVo> listTeaGarden(TeaGarden teaGarden) {
        return teaGardenMapper.listTeaGarden(teaGarden);
    }

    @Override
    public List<JSONObject> getEnterpriseNameAndArea() {
        return teaGardenMapper.getEnterpriseNameAndArea();
    }

    @Override
    public List<JSONObject> getRegionAverageYieldAndTeaArea() {
        return teaGardenMapper.getRegionAverageYieldAndTeaArea();
    }

    @Override
    public List<JSONObject> getProportionYieldAndDictLabel() {
        return teaGardenMapper.getProportionYieldAndDictLabel();
    }

    @Override
    public JSONObject getTeaGardenInformation(String name) {
        return teaGardenMapper.getTeaGardenInformation(name);
    }
}
