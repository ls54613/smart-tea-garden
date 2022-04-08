package com.wanou.project.system.service;

import java.util.List;

import cn.hutool.json.JSONObject;
import com.wanou.project.system.domain.TeaMarketYear;

/**
 * 茶市基本情况表Service接口
 *
 * @author ruoyi
 * @date 2022-04-02
 */
public interface ITeaMarketYearService
{
    /**
     * 查询茶市基本情况表
     *
     * @param id 茶市基本情况表主键
     * @return 茶市基本情况表
     */
    public TeaMarketYear selectTeaMarketYearById(Long id);

    /**
     * 查询茶市基本情况表列表
     *
     * @param teaMarketYear 茶市基本情况表
     * @return 茶市基本情况表集合
     */
    public List<TeaMarketYear> selectTeaMarketYearList(TeaMarketYear teaMarketYear);

    /**
     * 新增茶市基本情况表
     *
     * @param teaMarketYear 茶市基本情况表
     * @return 结果
     */
    public int insertTeaMarketYear(TeaMarketYear teaMarketYear);

    /**
     * 修改茶市基本情况表
     *
     * @param teaMarketYear 茶市基本情况表
     * @return 结果
     */
    public int updateTeaMarketYear(TeaMarketYear teaMarketYear);

    /**
     * 批量删除茶市基本情况表
     *
     * @param ids 需要删除的茶市基本情况表主键集合
     * @return 结果
     */
    public int deleteTeaMarketYearByIds(Long[] ids);

    /**
     * 删除茶市基本情况表信息
     *
     * @param id 茶市基本情况表主键
     * @return 结果
     */
    public int deleteTeaMarketYearById(Long id);

    List<JSONObject> getTeaSalesChina();

    List<JSONObject> getProportionOfSalesVolume();

    List<JSONObject> getPerCapitaConsumption();

    List<JSONObject> getTeaConsumption();

    List<JSONObject> getChangNingTeaYield();

    List<JSONObject> getTypeProportion();
}
