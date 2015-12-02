package com.bkweb.common.utils.email;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.AuthenticationFailedException;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;

public class EmailSender {
	private String host; // 服务器地址

	private String from; // 发件人

	private String to; // 收件人 多个收件人以,分隔

	private String title; // 主题

	private String content; // 内容

	private List<File> attachmentlist; // 附件集

	private String username; // 用户名

	private String password; // 密码
	/** 发件人员工编号 */
	private String sendEmployeeId;

	public String getSendEmployeeId() {
		return sendEmployeeId;
	}

	public void setSendEmployeeId(String sendEmployeeId) {
		this.sendEmployeeId = sendEmployeeId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<File> getAttachmentlist() {
		return attachmentlist;
	}

	public void setAttachmentlist(List<File> attachmentlist) {
		this.attachmentlist = attachmentlist;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	private String port;

	public EmailSender(String host, String from, String to, String title, String content, List<File> attachmentlist,
			String username, String password, String port) {
		this.host = host;
		this.from = from;
		this.to = to;
		this.title = title;
		this.content = content;
		this.attachmentlist = attachmentlist;
		this.username = username;
		this.password = password;
		this.port = port;
	}

	public EmailSender(String to, String title, String content, List<File> attachmentlist) {
		this.to = to;
		this.title = title;
		this.content = content;
		this.attachmentlist = attachmentlist;
	}

	public EmailSender() {
	}

	/**
	 * 发送Html邮件
	 * 
	 * @return 发送状态信息 index0：状态 0成功 1失败;index1：描述错误信息
	 */
	public String[] sendHtmlMail() {
		String[] result = new String[2];

		Session session = null;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.sendpartial", "true");
		props.put("mail.smtp.port", port);

		if (StringUtils.isBlank(username)) {// 不需要验证用户名密码
			session = Session.getDefaultInstance(props, null);
		} else {
			props.put("mail.smtp.auth", "true");
			EmailAuthenticator auth = new EmailAuthenticator(username, password);
			session = Session.getInstance(props, auth);
		}

		// 设置邮件发送信息
		try {
			// 创建邮件
			MimeMessage message = new MimeMessage(session);
			// 设置发件人地址
			message.setFrom(new InternetAddress(from));
			// 设置收件人地址（多个邮件地址）
			InternetAddress[] toAddr = InternetAddress.parse(to);
			message.addRecipients(Message.RecipientType.TO, toAddr);
			// 设置邮件主题
			message.setSubject(title);
			// 设置发送时间
			message.setSentDate(new Date());
			// 设置发送内容
			Multipart multipart = new MimeMultipart();
			// 设置附件
			if (attachmentlist != null && attachmentlist.size() > 0) {
				for (int i = 0, l = attachmentlist.size(); i < l; i++) {
					MimeBodyPart attachmentPart = new MimeBodyPart();
					if (!attachmentlist.get(i).isFile()) {
						try{
							throw new Exception();
						}catch(MessagingException mex){
							System.out.println("文件出现问题");
						}
					}
					FileDataSource source = new FileDataSource(attachmentlist.get(i));
					attachmentPart.setDataHandler(new DataHandler(source));
					attachmentPart.setFileName(MimeUtility.encodeWord(attachmentlist.get(i).getName(), "gb2312", null));
					multipart.addBodyPart(attachmentPart);
				}
			}

			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(content, "text/html; charset=utf-8");
			multipart.addBodyPart(html);

			message.setContent(multipart);

			// 登录SMTP服务器
			if (StringUtils.isBlank(username)) {
				// 不需验证
				Transport.send(message);
			} else {
				// 需要验证
				Transport transport = session.getTransport("smtp");
				transport.connect();
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			}

			result[0] = "0";
			result[1] = "发送成功";

			System.out.println("邮件发送成功!发送人：" + from);

		} catch (MessagingException mex) {
			result[0] = "500";
			result[1] = "邮件服务器发生错误";

			if (mex instanceof AuthenticationFailedException) {
				result[1] = "用户名或密码错误";
			}
		} catch (Exception e) {
			result[0] = "1";
			result[1] = "系统异常";
		}

		return result;
	}

	/**
	 * 发送纯文字邮件
	 * 
	 * @return 发送状态信息 index0：状态 0成功 1失败;index1：描述错误信息
	 */
	public String[] sendTextMail() {
		String[] result = new String[2];

		Session session = null;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.sendpartial", "true");
		props.put("mail.smtp.port", port);

		if (StringUtils.isBlank(username)) {// 不需要验证用户名密码
			session = Session.getDefaultInstance(props, null);
		} else {
			props.put("mail.smtp.auth", "true");
			EmailAuthenticator auth = new EmailAuthenticator(username, password);
			session = Session.getInstance(props, auth);
		}

		// 设置邮件发送信息
		try {
			// 创建邮件
			MimeMessage message = new MimeMessage(session);
			// 设置发件人地址
			message.setFrom(new InternetAddress(from));
			// 设置收件人地址（多个邮件地址）
			InternetAddress[] toAddr = InternetAddress.parse(to);
			message.addRecipients(Message.RecipientType.TO, toAddr);
			// 设置邮件主题
			message.setSubject(title);
			// 设置发送时间
			message.setSentDate(new Date());
			// 设置发送内容
			Multipart multipart = new MimeMultipart();
			MimeBodyPart contentPart = new MimeBodyPart();
			contentPart.setText(content);
			multipart.addBodyPart(contentPart);
			// 设置附件
			if (attachmentlist != null && attachmentlist.size() > 0) {
				for (int i = 0; i < attachmentlist.size(); i++) {
					MimeBodyPart attachmentPart = new MimeBodyPart();

					FileDataSource source = new FileDataSource(attachmentlist.get(i));
					attachmentPart.setDataHandler(new DataHandler(source));
					attachmentPart.setFileName(MimeUtility.encodeWord(attachmentlist.get(i).getName(), "gb2312", null));
					multipart.addBodyPart(attachmentPart);
				}
			}

			message.setContent(multipart);

			// 登录SMTP服务器
			if (StringUtils.isBlank(username)) {
				// 不需验证
				Transport.send(message);
			} else {
				// 需要验证
				Transport transport = session.getTransport("smtp");
				transport.connect();
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			}

			result[0] = "200";
			result[1] = "发送成功";

			System.out.println("邮件发送成功!发送人：" + from);

		} catch (MessagingException mex) {
			result[0] = "500";
			result[1] = "邮件服务器发生错误";

			if (mex instanceof AuthenticationFailedException) {
				result[1] = "用户名或密码错误";
			}
		} catch (Exception e) {
			result[0] = "1";
			result[1] = "系统异常";
		}

		return result;
	}
}