package com.lsm.frame.controller.system;


import com.lsm.frame.controller.BaseController;
import com.lsm.frame.model.dto.TableDataInfo;
import com.lsm.frame.model.entity.SysConfig;
import com.lsm.frame.service.intf.ISysConfigService;
import com.lsm.frame.utils.AjaxResult;
import com.lsm.frame.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 参数配置 信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/config")
public class SysConfigController extends BaseController
{

    @Autowired
    private ISysConfigService configService;

    @RequiresRoles("root")
    @GetMapping()
    public String config()
    {
        return "system/config/config";
    }

    /**
     * 查询参数配置列表
     */
    @RequiresRoles("root")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysConfig config)
    {
        startPage();
        List<SysConfig> list = configService.selectConfigList(config);
        return getDataTable(list);
    }


    /**
     * 新增参数配置
     */
    @RequiresRoles("root")
    @GetMapping("/add")
    public String add()
    {
        logger.info("进入添加参数界面");
        return "system/config/add";
    }

    /**
     * 新增保存参数配置
     */
    @RequiresRoles("root")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SysConfig config)
    {
        String t = "1";
        if (t.equals(configService.checkConfigKeyUnique(config)))
        {
            return error("新增参数'" + config.getConfigName() + "'失败，参数键名已存在");
        }
        config.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(configService.insertConfig(config));
    }

    /**
     * 修改参数配置
     */
    @RequiresRoles("root")
    @GetMapping("/edit/{configId}")
    public String edit(@PathVariable("configId") Long configId, ModelMap mmap)
    {
        mmap.put("config", configService.selectConfigById(configId));
        return "system/config/edit";
    }

    /**
     * 修改保存参数配置
     */
    @RequiresRoles("root")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysConfig config)
    {
        String t = "1";
        if (t.equals(configService.checkConfigKeyUnique(config)))
        {
            return error("修改参数'" + config.getConfigName() + "'失败，参数键名已存在");
        }
        config.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(configService.updateConfig(config));
    }

    /**
     * 删除参数配置
     */
    @RequiresRoles("root")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(configService.deleteConfigByIds(ids));
    }

    /**
     * 清空缓存
     */
    @RequiresRoles("root")
    @GetMapping("/clearCache")
    @ResponseBody
    public AjaxResult clearCache()
    {
        configService.clearCache();
        return success();
    }

    /**
     * 校验参数键名
     */
    @PostMapping("/checkConfigKeyUnique")
    @ResponseBody
    public String checkConfigKeyUnique(SysConfig config)
    {
        return configService.checkConfigKeyUnique(config);
    }
}
