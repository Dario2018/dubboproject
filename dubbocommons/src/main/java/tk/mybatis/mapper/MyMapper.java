package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
*  注意不能被扫描到
* */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
