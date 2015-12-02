package com.bkweb.common.utils.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * class MyAuthenticator用于邮件服务器认证 构造器需要用户名、密码作参数
 */
public class EmailAuthenticator extends Authenticator {

	private String username = null;

	private String password = null;

	public EmailAuthenticator(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}