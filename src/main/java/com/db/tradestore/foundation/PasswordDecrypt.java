package com.db.tradestore.foundation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;

public class PasswordDecrypt {

	public static void main(String[] args) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		List<String> passwords = Arrays.asList("admin", "user", "swagger");
		passwords.forEach(p -> System.out.println(passwordEncoder.encode(p)));
	}
}
