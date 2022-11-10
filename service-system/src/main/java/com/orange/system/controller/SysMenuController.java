package com.orange.system.controller;

import com.orange.common.result.Result;
import com.orange.model.system.SysMenu;
import com.orange.model.vo.AssginMenuVo;
import com.orange.system.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Li ZhiCheng
 * @create: 2022-11-2022/11/2 18:54
 * @description:
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "获取菜单")
    @GetMapping("findNodes")
    public Result<?> findNodes() {
        List<SysMenu> list = sysMenuService.findNodes();
        return Result.ok(list);
    }

    @ApiOperation(value = "新增菜单")
    @PostMapping("save")
    public Result<?> save(@RequestBody SysMenu permission) {
        sysMenuService.save(permission);
        return Result.ok();
    }

    @ApiOperation(value = "修改菜单")
    @PutMapping("update")
    public Result<?> updateById(@RequestBody SysMenu permission) {
        sysMenuService.updateById(permission);
        return Result.ok();
    }

    @ApiOperation(value = "删除菜单")
    @DeleteMapping("remove/{id}")
    public Result<?> remove(@PathVariable Long id) {
        sysMenuService.removeById(id);
        return Result.ok();
    }
    @ApiOperation(value = "根据角色获取菜单")
    @GetMapping("/toAssign/{roleId}")
    public Result<?> toAssign(@PathVariable Long roleId) {
        List<SysMenu> list = sysMenuService.findSysMenuByRoleId(roleId);
        return Result.ok(list);
    }

    @ApiOperation(value = "给角色分配权限")
    @PostMapping("/doAssign")
    public Result<?> doAssign(@RequestBody AssginMenuVo assginMenuVo) {
        sysMenuService.doAssign(assginMenuVo);
        return Result.ok();
    }
}