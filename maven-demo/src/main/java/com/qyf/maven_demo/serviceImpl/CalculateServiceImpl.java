package com.qyf.maven_demo.serviceImpl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qyf.maven_demo.mapper.CalculateMapper;
import com.qyf.maven_demo.model.Calculate;
import com.qyf.maven_demo.service.ICalculateService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/**
 *   服务实现类
 *
 * @author qyf
 * @since 2018-12-04
 */
@Component
@Service()
public class CalculateServiceImpl extends ServiceImpl<CalculateMapper,Calculate> implements ICalculateService {

}
