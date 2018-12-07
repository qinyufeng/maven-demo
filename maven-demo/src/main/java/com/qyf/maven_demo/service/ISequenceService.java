package com.qyf.maven_demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.qyf.maven_demo.model.Sequence;

/**
 *   服务类
 * 
 * @author qyf
 * @since 2018-12-05
 */
public interface ISequenceService extends IService<Sequence> {
	String getSequence(String name,String dateModel,String prefix,int zereos) throws Exception;
}
