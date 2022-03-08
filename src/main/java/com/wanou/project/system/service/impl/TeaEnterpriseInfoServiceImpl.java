package com.wanou.project.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollUtil;
import com.wanou.project.system.domain.TeaEnterpriseTeaType;
import com.wanou.project.system.mapper.TeaEnterpriseTeaTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaEnterpriseInfoMapper;
import com.wanou.project.system.domain.TeaEnterpriseInfo;
import com.wanou.project.system.service.ITeaEnterpriseInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 茶企基本信息Service业务层处理
 *
 * @author MrYao
 * @date 2022-03-01
 */
@Service
public class TeaEnterpriseInfoServiceImpl implements ITeaEnterpriseInfoService
{
    @Autowired
    private TeaEnterpriseInfoMapper teaEnterpriseInfoMapper;
    @Autowired
    private TeaEnterpriseTeaTypeMapper teaEnterpriseTeaTypeMapper;

    /**
     * 查询茶企基本信息
     *
     * @param id 茶企基本信息主键
     * @return 茶企基本信息
     */
    @Override
    public TeaEnterpriseInfo selectTeaEnterpriseInfoById(Long id)
    {
        return teaEnterpriseInfoMapper.selectTeaEnterpriseInfoById(id);
    }

    /**
     * 查询茶企基本信息列表
     *
     * @param teaEnterpriseInfo 茶企基本信息
     * @return 茶企基本信息
     */
    @Override
    public List<TeaEnterpriseInfo> selectTeaEnterpriseInfoList(TeaEnterpriseInfo teaEnterpriseInfo)
    {
        return teaEnterpriseInfoMapper.selectTeaEnterpriseInfoList(teaEnterpriseInfo);
    }

    /**
     * 新增茶企基本信息
     *
     * @param teaEnterpriseInfo 茶企基本信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertTeaEnterpriseInfo(TeaEnterpriseInfo teaEnterpriseInfo)
    {
        int i = teaEnterpriseInfoMapper.insertTeaEnterpriseInfo(teaEnterpriseInfo);
        if (teaEnterpriseInfo.getTeaType()!=null){
            List<Integer> teaType = teaEnterpriseInfo.getTeaType();
            List<TeaEnterpriseTeaType> saveList = new ArrayList<>(teaType.size());
            teaType.forEach(item -> {
                TeaEnterpriseTeaType teaEnterpriseTeaType = new TeaEnterpriseTeaType();
                teaEnterpriseTeaType.setTeaType(item.longValue());
                teaEnterpriseTeaType.setTeaEnterpriseId(teaEnterpriseInfo.getId());
                saveList.add(teaEnterpriseTeaType);
            });
            teaEnterpriseTeaTypeMapper.batchInsert(saveList);
        }
        return i;
    }

    /**
     * 修改茶企基本信息
     *
     * @param teaEnterpriseInfo 茶企基本信息
     * @return 结果
     */
    @Override
    public int updateTeaEnterpriseInfo(TeaEnterpriseInfo teaEnterpriseInfo)
    {
//        teaEnterpriseInfoMapper.updateTeaEnterpriseInfo(teaEnterpriseInfo);
        List<Integer> teaType = teaEnterpriseInfo.getTeaType();
        if(CollUtil.isEmpty(teaType)){
            //如果本次修改传入的茶品种为空 删除表中该企业所有茶品种记录
            teaEnterpriseTeaTypeMapper.deleteTeaEnterpriseTeaTypeByTeaEnterpriseId(teaEnterpriseInfo.getId());
        }else {
            List<TeaEnterpriseTeaType> teaEnterpriseTeaTypeListInDB = teaEnterpriseTeaTypeMapper
                    .selectTeaEnterpriseTeaTypeListByTeaEnterpriseId(teaEnterpriseInfo.getId()); //查询该茶企数据库中有哪些茶品种
            if(CollUtil.isEmpty(teaEnterpriseTeaTypeListInDB)){
                //数据库中没有该企业的茶品种 所以本次提交的茶品种全部新增
                List<TeaEnterpriseTeaType> saveList = new ArrayList<>(teaType.size()); //需要新增
                teaType.forEach(type -> {
                    TeaEnterpriseTeaType teaEnterpriseTeaType = new TeaEnterpriseTeaType();
                    teaEnterpriseTeaType.setTeaType(type.longValue());
                    teaEnterpriseTeaType.setTeaEnterpriseId(teaEnterpriseInfo.getId());
                    saveList.add(teaEnterpriseTeaType);
                });
                teaEnterpriseTeaTypeMapper.batchInsert(saveList);
            }else {
                //数据库有该茶企茶品种数据 对比数据库数据以及本次提交的差异
                List<Integer> teaTypeInDB = teaEnterpriseTeaTypeListInDB.stream().map(item -> item.getTeaType().intValue()).collect(Collectors.toList());
                for (Integer type : teaType) {
                    if(!teaTypeInDB.contains(type)){
                        //本次提交有 数据库中没有的 新增
                        TeaEnterpriseTeaType teaEnterpriseTeaType = new TeaEnterpriseTeaType();
                        teaEnterpriseTeaType.setTeaType(type.longValue());
                        teaEnterpriseTeaType.setTeaEnterpriseId(teaEnterpriseInfo.getId());
                        teaEnterpriseTeaTypeMapper.insertTeaEnterpriseTeaType(teaEnterpriseTeaType);
                    }
                }
                for (TeaEnterpriseTeaType teaEnterpriseTeaType : teaEnterpriseTeaTypeListInDB) {
                    if(!teaType.contains(teaEnterpriseTeaType.getTeaType().intValue())){
                        //数据库中有 本次提交没有 删除
                        teaEnterpriseTeaTypeMapper.deleteTeaEnterpriseTeaTypeById(teaEnterpriseTeaType.getId());
                    }
                }
            }
        }
            return teaEnterpriseInfoMapper.updateTeaEnterpriseInfo(teaEnterpriseInfo);
    }

    /**
     * 批量删除茶企基本信息
     *
     * @param ids 需要删除的茶企基本信息主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteTeaEnterpriseInfoByIds(Long[] ids)
    {
        teaEnterpriseTeaTypeMapper.deleteTeaEnterpriseTeaTypeByTeaEnterpriseIds(ids);
        return teaEnterpriseInfoMapper.deleteTeaEnterpriseInfoByIds(ids);
    }

    /**
     * 删除茶企基本信息信息
     *
     * @param id 茶企基本信息主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteTeaEnterpriseInfoById(Long id)
    {
        teaEnterpriseTeaTypeMapper.deleteTeaEnterpriseTeaTypeByTeaEnterpriseId(id);
        return teaEnterpriseInfoMapper.deleteTeaEnterpriseInfoById(id);
    }
}
