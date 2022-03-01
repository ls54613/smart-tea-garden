package com.wanou.common;

import com.wanou.common.constant.Constants;
import com.wanou.framework.redis.RedisCache;
import com.wanou.project.system.domain.SysDept;
import com.wanou.project.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author txh
 * @date 2021/8/12 17:20
 * redis数据初始化(预热)
 */
@Component
public class RedisDataInit {
    @Autowired
    private ISysDeptService sysDeptService;
    @Autowired
    private RedisCache redisCache;

    @PostConstruct
    public void init(){
        deptNameInit(); //部门名称
    }

    /**
     * 部门名称预热
     */
    private void deptNameInit(){
        List<SysDept> deptList = sysDeptService.selectAllDeptList();
        for (SysDept sysDept : deptList) {
            redisCache.setCacheMapBound(Constants.SYS_DEPT_CACHE,String.valueOf(sysDept.getDeptId()),sysDept);
        }
    }
}
