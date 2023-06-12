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

		CCBSign.RSASig rsa = new RSASig();
		rsa.setPublicKey(
				"30819c300d06092a864886f70d010101050003818a003081860281807f7e06318918e4b40e0544af801b065e85b182866bdc1d2b2400c31c9ae64016ec349ba7682352b19372898c693895bbd84e71f03a32c59ee6e39011db3e80b567a413b4ecd76ebc0e82834606fdb0d595264bead63791b650d17cc9d5a4885dc913294d020bdc011e5c14f1d5d60d585528b3c29e1f6280394120a99ac6d979020111");

		String sign = rsa.generateSigature(payload.src);
		boolean res = rsa.verifySigature(sign, payload.src);
		System.out.print(res);
		return res;
	}
}

@Data
class CCBPayloadDto {
	String sign;
	String src;
}