package com.example.springkadaitodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.repository.ToDoRepository;

@Service
public class ToDoService {
	
	private final ToDoRepository todoRepository;

	public ToDoService(ToDoRepository todoRepository) {	// 依存性の注入（DI）
		this.todoRepository = todoRepository;
	}

	public List<ToDo> getAllToDos() {
		return todoRepository.findAll();
	}

}