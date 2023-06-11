package com.kongshum.verify.ccb_verify_payload;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import CCBSign.RSASig;

@RestController
@RequestMapping("/ccb")
public class AppController {
	@GetMapping("/verify")
	public String verify() {
		CCBSign.RSASig rsa = new RSASig();
		boolean res = rsa.verifySigature("111",
				"POSID=000000&BRANCHID=110000000&ORDERID=00320995&PAYMENT=0.01&CURCODE=01&REMARK1=test1&REMARK2=test2&SUCCESS=Y");
		System.out.print(res);
		return "Hello World!";
	}
}
