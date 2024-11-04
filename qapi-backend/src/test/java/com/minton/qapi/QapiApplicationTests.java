package com.minton.qapi;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.minton.qapi.interfaceInfo.mapper.InterfaceInfoMapper;
import com.minton.qapi.interfaceInfo.model.InterfaceInfo;
import com.minton.qapi.interfaceInfo.service.InterfaceInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QapiApplicationTests {

	@Autowired
	private InterfaceInfoService interfaceInfoService;
    @Autowired
    private InterfaceInfoMapper interfaceInfoMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void testQApiClient() {
		System.out.println("testQApiClient");
		// QApiClient client = new QApiClient();
		// client.get("https://api.qapi.com/v1/user/info", null);
	}

	@Test
	void testPageQuery() {
		Page<InterfaceInfo> interfaceInfoPage = interfaceInfoService.getInterfaceInfoPage(1, 2, null);
		System.out.println(JSONUtil.toJsonPrettyStr(interfaceInfoPage));
		System.out.println("============");

		Page<InterfaceInfo> page = new Page<>(1, 2);
		Page<InterfaceInfo> interfaceInfoPage1 = interfaceInfoMapper.selectPage(page, null);
		System.out.println(JSONUtil.toJsonPrettyStr(interfaceInfoPage1));

		List<InterfaceInfo> list = interfaceInfoService.list(page);
		System.out.println(JSONUtil.toJsonPrettyStr(list));
	}

}
