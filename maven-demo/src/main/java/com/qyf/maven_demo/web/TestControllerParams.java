package com.qyf.maven_demo.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.qyf.maven_demo.model.RequestMaterialStock;
import com.qyf.maven_demo.model.RequestParams;
import com.qyf.maven_demo.model.RespModel;
import com.qyf.maven_demo.service.TestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("test")
public class TestControllerParams {
	@Autowired
	private TestService testService;
	/**
	 * @author qyf
	 * @param data
	 * @return Object
	 */
	@PostMapping("valid")
	@ApiOperation(value="输入输出格式，参数校验")
	@ApiResponses({@ApiResponse(code = 200, message = "返回值说明", response = RespModel.class)})
	public Object validTest(@Valid @RequestBody @ApiParam(name="参数",value="传入json格式",required=true)  RequestParams params) {
	     return null;
	}
	@GetMapping("valid2")
	@ApiOperation(value="参数校验")
	@ApiResponses({@ApiResponse(code=200,message="返回值说明",response=RespModel.class)})
	public Object validTest2(@RequestParam @ApiParam(name="account",value="账号",defaultValue="11") String account,@RequestParam @ApiParam(name="state",value="状态",defaultValue="0") String state) {
		StringBuffer msg=new StringBuffer();
		if(StringUtils.isEmpty(account)) {
			msg.append("账号不能为空");
		}
		if(ObjectUtils.isEmpty(state)) {
			msg.append("状态不能为空");
		}
		return msg.toString();
	}
	@GetMapping("paramsType/{data}")
	@ApiOperation(value="请求参数格式一")
	public Object paramsTypeOne(@PathVariable @ApiParam(value="查询参数",defaultValue="{\"size\":30,\"current\":1,\"WHTCode\":\"\",\"matCode\":[\"8020010140\",\"8020010174\"]}")
	String data) {
		//@Pathvariable注解绑定它传过来的值到方法的参数上,获得请求url中的动态参数
		Map<String,Object> params=JSON.parseObject(data);
		return null;
	}
	@GetMapping("paramsType/{data}")
	@ApiOperation(value="参数转成实体对象")
	public Object paramsType2(@PathVariable @ApiParam(value="查询参数",defaultValue="{\"size\":30,\"current\":1,\"WHTCode\":\"\",\"matCode\":[\"8020010140\",\"8020010174\"]}")
	String data) {
		//参数转成实体类对象
		RequestMaterialStock params=JSON.parseObject(data,RequestMaterialStock.class);
		return null;
	}
	
}
