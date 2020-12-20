package cn.asu.mybatisplus.controller;


import cn.asu.mybatisplus.service.SysMenuService;
import cn.asu.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author
 * @since 2020-12-19
 */
@RestController
@RequestMapping("/sys-menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;


    @PostMapping(value = "/findPage")
    public Object findPage(@RequestBody PageRequest pageQuery) {
        return sysMenuService.findPage(pageQuery);
    }

}
