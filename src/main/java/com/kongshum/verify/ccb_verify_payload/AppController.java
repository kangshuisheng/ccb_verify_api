package com.kongshum.verify.ccb_verify_payload;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import CCBSign.RSASig;

@RestController
@RequestMapping("/ccb")
public class AppController {

	@PostMapping
	@ResponseBody
	public boolean verify(
			@RequestBody CCBPayloadDto payload) {

		System.out.println(payload.sign);
		System.out.println(payload.src);
		System.err.println(payload.publicKey);

		CCBSign.RSASig rsa = new RSASig();
		rsa.setPublicKey(payload.publicKey);
		
		boolean res = rsa.verifySigature(payload.sign, payload.src);

		System.out.print(res);
		
		return res;
	}
}

@Data
class CCBPayloadDto {
	String sign;
	String src;
	String publicKey;
}