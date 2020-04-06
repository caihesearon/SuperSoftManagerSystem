package hecai.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hecai.entity.ResultType;
import hecai.entity.Task;
/**
 * 任务操作的控制层
 * @author caihe
 * @date 2019年12月10日下午8:25:49
 */
@RequestMapping("task")
@Controller
public class TaskController {

	/**
	 * 添加任务
	 * 将前端的task实体类添加到数据库中
	 * @param task 前端传进来的参数task实体类
	 * @return
	 */
	@RequestMapping(value="addtask", method=RequestMethod.POST)
	@ResponseBody		//@RequestParam Map<String,Object> map
	public ResultType addTask(Task task) {
		//获取from的数据 task
		//将获取的任务信息存入 数据中
		
		System.out.println(task.toString());
		
		return ResultType.ok();
	}
	
}
