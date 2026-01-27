package com.lease.webadmin.controller.system;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lease.common.result.Result;
import com.lease.model.entity.SystemPost;
import com.lease.model.entity.SystemUser;
import com.lease.model.enums.BaseStatus;
import com.lease.webadmin.service.SystemPostService;
import com.lease.webadmin.service.SystemUserService;
import com.lease.webadmin.vo.system.user.SystemUserItemVo;
import com.lease.webadmin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "后台用户信息管理")
@RestController
@RequestMapping("/admin/system/user")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private SystemPostService systemPostService;

    @Operation(summary = "根据条件分页查询后台用户列表")
    @GetMapping("page")
    public Result<IPage<SystemUserItemVo>> page(@RequestParam long current, @RequestParam long size, SystemUserQueryVo queryVo) {

       IPage<SystemUser> systemUserItemVoPage = new Page<>(current,size);
       IPage<SystemUserItemVo> systemUserItemVoIPage = systemUserService.pageSystemUserItemVo(systemUserItemVoPage,queryVo);
        return Result.ok(systemUserItemVoIPage);
    }

    @Operation(summary = "根据ID查询后台用户信息")
    @GetMapping("getById")
    public Result<SystemUserItemVo> getById(@RequestParam Long id) {

        SystemUser systemUser = systemUserService.getById(id);
        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
        BeanUtils.copyProperties(systemUser, systemUserItemVo);

        SystemPost systemPostServiceById = systemPostService.getById(systemUser.getPostId());
        if (systemPostServiceById != null) {
            systemUserItemVo.setPostName(systemPostServiceById.getName());
        }

        return Result.ok(systemUserItemVo);
    }

    @Operation(summary = "保存或更新后台用户信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemUser systemUser) {

        systemUserService.saveOrUpdate(systemUser);

        return Result.ok();
    }

    @Operation(summary = "判断后台用户名是否可用")
    @GetMapping("isUserNameAvailable")
    public Result<Boolean> isUsernameExists(@RequestParam String username) {

        LambdaUpdateWrapper<SystemUser> systemUserLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        systemUserLambdaUpdateWrapper.eq(SystemUser::getUsername, username);
        long count = systemUserService.count(systemUserLambdaUpdateWrapper);

        return Result.ok(count == 0);
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "根据ID删除后台用户信息")
    public Result removeById(@RequestParam Long id) {

        systemUserService.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "根据ID修改后台用户状态")
    @PostMapping("updateStatusByUserId")
    public Result updateStatusByUserId(@RequestParam Long id, @RequestParam BaseStatus status) {

        LambdaUpdateWrapper<SystemUser> systemUserLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        systemUserLambdaUpdateWrapper.set(SystemUser::getStatus, status).eq(SystemUser::getId, id);
        systemUserService.update(systemUserLambdaUpdateWrapper);


        return Result.ok();
    }
}
