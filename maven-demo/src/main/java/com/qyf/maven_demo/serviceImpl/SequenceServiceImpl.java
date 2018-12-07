package com.qyf.maven_demo.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qyf.maven_demo.mapper.SequenceMapper;
import com.qyf.maven_demo.model.Sequence;
import com.qyf.maven_demo.service.ISequenceService;
import com.qyf.maven_demo.utils.Date.DateUtils;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
/**
 *   服务实现类
 *
 * @author qyf
 * @since 2018-12-05
 */
@Component
@Service
public class SequenceServiceImpl extends ServiceImpl<SequenceMapper,Sequence> implements ISequenceService{

	@Autowired
	private SequenceMapper mapper;
	@Override
	public String getSequence(String name,String dateModel, String prefix, int digits) throws Exception{
		String result="";
		if(ObjectUtils.isEmpty(name)) throw new Exception("参数要生成序列号的字段不可为空");
		String currenDate="";
		int maxth=1;
		StringBuffer zeros=new StringBuffer();
		Wrapper<Sequence> wrapper=new EntityWrapper<>();
		wrapper.eq("name", name);
		
		List<Sequence> selectList = mapper.selectList(wrapper);
		if(ObjectUtils.isEmpty(selectList)) {
			Sequence seq=new Sequence();
			seq.setName(name);
			if(!ObjectUtils.isEmpty(dateModel)) {
				currenDate=DateUtils.getDateStr(new Date(), dateModel);
				seq.setCurrenDate(currenDate);
			}
			if(!ObjectUtils.isEmpty(prefix)) {
				seq.setPrefix(prefix);
			}
			seq.setDigits(digits);
			seq.setNum(maxth);
			mapper.insert(seq);
			for(int i=0;i<digits-1;i++) {
				zeros.append(0);
			}
			result=prefix+currenDate+zeros+maxth;
			return result;
			
		}else {
			Sequence seq=selectList.get(0);
			
			String pre="";
			String date="";
			int digit=seq.getDigits();
			int num=seq.getNum();
			
			if(!ObjectUtils.isEmpty(seq.getPrefix())) {
				pre=seq.getPrefix();
			}
			if(!ObjectUtils.isEmpty(seq.getCurrenDate())) {
				date=seq.getCurrenDate();
			}
			if(!ObjectUtils.isEmpty(date)) {
				String currdate=DateUtils.getDateStr(new Date(), dateModel);
				if(currdate.equals(date)) {
					maxth=seq.getNum()+maxth;
					String numMaxthStr=String.valueOf(maxth);
					String numStr=String.valueOf(num);
					if(numMaxthStr.length() != numStr.length()) {
						for(int i=0;i<digit-2;i++) {
							zeros.append(0);
						}
					}
				}
			}else {
				maxth=seq.getNum()+maxth;
				String numMaxthStr=String.valueOf(maxth);
				String numStr=String.valueOf(num);
				if(numMaxthStr.length() != numStr.length()) {
					for(int i=0;i<digit-2;i++) {
						zeros.append(0);
					}
				}
			}
			seq.setNum(maxth);
			mapper.update(seq, wrapper);
			result=prefix+zeros+maxth;
		}
		return null;
	}

}
