package cn.asu.mybatisplus.mapper;

import cn.asu.mybatisplus.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author
 * @since 2020-12-19
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询全部
     * @return
     */
    List<SysUser> selectAll();

}
