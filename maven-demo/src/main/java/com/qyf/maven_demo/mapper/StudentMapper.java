package com.qyf.maven_demo.mapper;

import com.qyf.maven_demo.model.Student;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 * @author qyf
 * @since 2018-10-16
 */
public interface StudentMapper extends BaseMapper<Student> {
	
	Integer insertCommon(@Param("mapperMap") Map<String, Object> mapperMap);

	List<Map<String, Object>> selectCommon(@Param("rowBounds") RowBounds rowBounds, @Param("mapperMap") Map<String, Object> mapperMap);

	Integer deleteCommon(@Param("mapperMap") Map<String, Object> mapperMap);

	Integer updateCommon(@Param("mapperMap") Map<String, Object> mapperMap);
	List<Student> mapperXmlTest(@Param("name")String name,@Param("creatDate")String creatDate);
}