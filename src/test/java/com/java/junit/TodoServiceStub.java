package com.java.junit;

import java.util.Arrays;
import java.util.List;

import com.java.mockito.service.TodoService;

public class TodoServiceStub implements TodoService {

	@Override
	public List<String> retrieveTodos(String user) {
		// TODO Auto-generated method stub
		return Arrays.asList("SpringMVC", "SpringBoot", "RestApi");
	}

}
