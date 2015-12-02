package com.bktravel.sys.account.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bktravel.sys.account.entity.BkAccount;
import com.bktravel.sys.account.service.BkAccountService;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.common.web.BaseController;

/**
 * 用户Controller
 * 
 * @author yourName
 * @version 2015-6-19
 */
@Controller
@RequestMapping("${adminPath}/account")
public class BkAccountController extends BaseController {

	@Autowired
	private BkAccountService accountService;

	@RequestMapping("list")
	public String findbkAccountList(BkAccount account, int pageNum, HttpServletRequest request) {
		List<BkAccount> list = accountService.findPageList(account, true, new HPage<BkAccount>(pageNum), null);
		request.setAttribute("userList", list);
		return "bkAccount/bkAccountList";
	}
}
