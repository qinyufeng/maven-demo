package com.qyf.maven_demo.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.qyf.maven_demo.entity.DmRalPositionStcok;
import com.qyf.maven_demo.entity.Students;
import com.qyf.maven_demo.entity.Teachers;
import com.qyf.maven_demo.mapper.PositionStcokMapper;
import com.qyf.maven_demo.service.OptimizeService;

public class OptimizeServiceImpl implements OptimizeService{
	@Autowired
	private PositionStcokMapper maper;

	@Override
	public List<Map<String, Object>> queryInfo(Map<String, Object> data) {
		List<Map<String, Object>> list = new ArrayList<>();
		Wrapper<DmRalPositionStcok> wrapper = new EntityWrapper<DmRalPositionStcok>();
		if (!ObjectUtils.isEmpty(data.get("matName"))) {
			wrapper.like("matName", (String) data.get("matName"));
			list =new ArrayList<>(); //list =mapper.selectList(wrapper);
		}
		//拼接非本地数据库字段	
		List<String> stuCodeList = new ArrayList<>();
		List<String> teaCodeList = new ArrayList<>();
		
		for (Map<String, Object> dataMap : list) {
			// rpc调用dm工厂信息
//			Wrapper<DmMstOrganize> organizeWrapper = new EntityWrapper<DmMstOrganize>();
//			organizeWrapper.eq("orgCode", dataMap.get("werks"));
//			DmMstOrganize dmMstFactoryInfo = organizeService.selectOne(organizeWrapper);// rpc调用dm工厂
//			if (dmMstFactoryInfo != null) {
//				dataMap.put("werksShortName", dmMstFactoryInfo.getShortName());
//			} else {
//				dataMap.put("werksShortName", "");
//			}
//			// rpc调用dm物料信息
//			Wrapper<DmMstMaterial> wrapper = new EntityWrapper<DmMstMaterial>();
//			wrapper.eq("matCode", dataMap.get("matCode"));
//			DmMstMaterial materialInfo = materialService.selectOne(wrapper);// rpc调用dm工厂
//			if (materialInfo != null) {
//				dataMap.put("matName", materialInfo.getMatName());
//				dataMap.put("matType", materialInfo.getMatType());
//			} else {
//				dataMap.put("matName", "");
//				dataMap.put("matType", "");
//			}
			if(!ObjectUtils.isEmpty(dataMap.get("stuCode")))
				stuCodeList.add(dataMap.get("stuCode").toString());
			if(!ObjectUtils.isEmpty(dataMap.get("teaCode")))
				teaCodeList.add(dataMap.get("teaCode").toString());
			
			dataMap.put("stuName", "");
			dataMap.put("teaName", "");
		}

		Map<String, String> stuMap = new HashMap<>();
		Map<String, Teachers> teaMap = new HashMap<>();
		
		if(stuCodeList.size() > 0) {
			Wrapper<Students> organizeWrapper = new EntityWrapper<Students>();
			organizeWrapper.setSqlSelect("studentCode", "studentName").in("studentCode", stuCodeList).eq("state", 0);
			List<Students> stuList = new ArrayList<>();//mapper.selectList(organizeWrapper);
			stuMap = stuList.stream().collect(Collectors.toMap(Students::getStudentCode, Students::getStudentName));
		}
		
		if(teaCodeList.size() > 0) {
			Wrapper<Teachers> matWrapper = new EntityWrapper<Teachers>();
			matWrapper.setSqlSelect("teacherCode", "teacherName", "matType").in("teacherCode", teaCodeList).eq("state", 0);
			List<Teachers> teaList = new ArrayList<>();//matList=mapper.selectList(matWrapper);
			teaMap = teaList.stream().collect(Collectors.toMap(Teachers::getTeacherCode, Teachers -> Teachers));
		}
		
		for (Map<String, Object> dataMap : list) {
			if(!ObjectUtils.isEmpty(dataMap.get("studentCode"))) {
				String studentCode = dataMap.get("studentCode").toString();
				if(stuMap.containsKey(studentCode)) {
					dataMap.put("werksShortName", stuMap.get(studentCode));
				}
			}
			if(!ObjectUtils.isEmpty(dataMap.get("teacherCode"))) {
				String teacherCode = dataMap.get("teacherCode").toString();
				if(teaMap.containsKey(teacherCode)) {
					Teachers teacher = teaMap.get(teacherCode);
					dataMap.put("teacherName", teacher.getTeacherName());
					//dataMap.put("teacherType", teacher.getMatType());
				}	
			}
		}
		return list;

	}

}
