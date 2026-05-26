package com.smartlogix.ms_gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"jwt.secret=smartlogix-secret-key-2024-super-segura-para-produccion-abc123"})
class MsGatewayApplicationTests {

	@Test
	void contextLoads() {
	}

}
