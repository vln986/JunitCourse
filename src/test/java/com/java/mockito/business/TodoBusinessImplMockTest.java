package com.java.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.java.junit.TodoServiceStub;
import com.java.mockito.service.TodoService;

class TodoBusinessImplMockTest {

	@Test
	void retrieveTodosMockTest() {
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("SpringMVC", "SpringBoot", "RestApi");

		List<String> list = todoServiceMock.retrieveTodos("dummy");

		when(todoServiceMock.retrieveTodos("dummy")).thenReturn(todos);

		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());

	}

	@Test
	void retrieveTodosMockBDDTest() {

		// Given
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("SpringMVC", "SpringBoot", "RestApi");

		List<String> list = todoServiceMock.retrieveTodos("dummy");

		given(todoServiceMock.retrieveTodos("dummy")).willReturn(todos);

		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

		// When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");

		// Then
		assertEquals(2, filteredTodos.size());

	}

}
