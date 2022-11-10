package com.orange.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.common.result.Result;
import com.orange.model.system.SysRole;
import com.orange.model.vo.AssginRoleVo;
import com.orange.model.vo.SysRoleQueryVo;
import com.orange.system.exception.OrangeException;
import com.orange.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: Li ZhiCheng
 * @create: 2022-10-2022/10/27 17:05
 * @description:
 */
@RestController
@RequestMapping("/admin/system/sysRole")
@Api(tags = "角色管理")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "获取全部角色")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll() {
        try {
        } catch (Exception e) {
            throw new OrangeException(20001,"出现自定义异常");
        }
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }

    @ApiOperation(value = "分页查询角色列表")
    @GetMapping("/{page}/{limit}")
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    public Result<?> findAllPage(@ApiParam(name = "page", value = "当前页码", required = true) @PathVariable Long page,
                                 @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable Long limit,
                                 @ApiParam(name = "roleQueryVo", value = "查询对象", required = false) SysRoleQueryVo roleQueryVo) {
        Page<SysRole> pageParam = new Page<>(page, limit);
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam, roleQueryVo);
        return Result.ok(pageModel);
    }
    @ApiOperation(value = "获取角色")
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    public Result<?> get(@PathVariable Long id) {
        SysRole role = sysRoleService.getById(id);
        return Result.ok(role);
    }
    @ApiOperation(value = "新增角色")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('bnt.sysRole.add')")
    public Result<?> save(@RequestBody SysRole role) {
        sysRoleService.save(role);
        return Result.ok();
    }
    @ApiOperation(value = "修改角色")
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('bnt.sysRole.update')")
    public Result<?> updateById(@RequestBody SysRole role) {
        sysRoleService.updateById(role);
        return Result.ok();
    }
    @ApiOperation(value = "删除角色")
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    public Result<?> remove(@PathVariable Long id) {
        sysRoleService.removeById(id);
        return Result.ok();
    }
    @ApiOperation(value = "根据id列表批量删除")
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    public Result<?> batchRemove(@RequestBody List<Long> idList) {
        sysRoleService.removeByIds(idList);
        return Result.ok();
    }
    @ApiOperation(value = "根据用户获取角色数据")
    @GetMapping("/toAssign/{userId}")
    public Result<?> toAssign(@PathVariable Long userId) {
        Map<String, Object> roleMap = sysRoleService.getRolesByUserId(userId);
        return Result.ok(roleMap);
    }
    @ApiOperation(value = "根据用户分配角色")
    @PostMapping("/doAssign")
    public Result<?> doAssign(@RequestBody AssginRoleVo assginRoleVo) {
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }
}
