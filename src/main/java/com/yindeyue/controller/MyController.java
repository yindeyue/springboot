package com.yindeyue.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yindeyue.entity.Person;
import com.yindeyue.entity.Result;

@RestController
public class MyController {
	@RequestMapping(value="person",method=RequestMethod.POST)
	public Person getPerson(@RequestBody Person person) {
		System.out.println(person);
		return  person;
	}
	@RequestMapping(value="person2",produces="shiyan/yindeyue")
	public String getPerson2(String person) {
		System.out.println(person);
		return  person;
	}

	@Autowired
	private JdbcTemplate jdbcTemple;

	@GetMapping("/shdbcenter/v1/asset/gateway")
	public Result<Object> mockController(HttpServletRequest request) {
		String parameter = request.getParameter("method");
		switch (parameter) {
		// 推送非脱敏数据以及非脱敏图片
		case "postRealDataFile":

			return null;
		// 接受资产状态变更接口
		case "syncStatus":

			break;
		// 接受新建资产，并脱敏返回
		// 推送脱敏数据到北京
		// 非脱敏数据准备完成通知北京
		default:
			break;

		}

		return new Result<Object>(200, "ok");
	}

	@Transactional
	@GetMapping("hi")
	public void hi() {
		jdbcTemple.execute("insert into shiyan(name,age) value('yindeyue2',23)");
	}

	@Transactional
	@GetMapping("shiyan")
	public String shiyan() {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void beforeCommit(boolean readOnly) {
				System.out.println("beforeCommit: " + readOnly);
				super.beforeCommit(readOnly);
			}

			@Override
			public void beforeCompletion() {
				System.out.println("beforeCompletion");
				super.beforeCompletion();
			}

			@Override
			public void afterCommit() {
				System.out.println("afterCommit");
				super.afterCommit();
			}

			@Override
			public void afterCompletion(int status) {
				System.out.println("afterCompletion: " + status);
				super.afterCompletion(status);
			}
		});
		jdbcTemple.execute("insert into shiyan(name,age) value('yindeyue',23)");
		// throw new RuntimeException();
		return "ok";

	}
}
