package com.java.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.java.junit.TodoServiceStub;
import com.java.mockito.service.TodoService;

class TodoBusinessImplStubTest {

	@Test
	void retrieveTodoRelatedToSpringTest() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

}
