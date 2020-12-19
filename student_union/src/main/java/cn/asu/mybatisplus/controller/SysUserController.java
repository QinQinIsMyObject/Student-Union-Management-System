package cn.asu.mybatisplus.controller;


import cn.asu.mybatisplus.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户管理 前端控制器
 * </p>
 *
 * @author
 * @since 2020-12-19
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/{id}")
    public Object test(@PathVariable("id") Long id) {
        return sysUserService.getById(id);
    }

    @GetMapping(value="/findByUserId")
    public Object findByUserId(@RequestParam Long userId) {
        return sysUserService.findByUserId(userId);
    }

    @GetMapping(value="/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

}
