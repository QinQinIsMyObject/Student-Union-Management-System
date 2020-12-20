package cn.asu.mybatisplus.service.impl;

import cn.asu.mybatisplus.entity.SysMenu;
import cn.asu.mybatisplus.mapper.SysMenuMapper;
import cn.asu.mybatisplus.service.SysMenuService;
import cn.asu.page.PageRequest;
import cn.asu.page.PageResult;
import cn.asu.page.PageUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author
 * @since 2020-12-19
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageQuery
     * @return
     */
    private PageInfo<SysMenu> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SysMenu> sysMenus = sysMenuMapper.selectPage();
        return new PageInfo<SysMenu>(sysMenus);
    }

}
