package cn.asu.mybatisplus.mapper;

import cn.asu.mybatisplus.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author
 * @since 2020-12-19
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 分页查询
     *
     * @return
     */
    List<SysMenu> selectPage();

}
