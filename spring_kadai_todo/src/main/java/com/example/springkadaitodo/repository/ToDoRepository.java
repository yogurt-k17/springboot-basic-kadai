package com.example.springkadaitodo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springkadaitodo.entity.ToDo;
	// インターフェースの定義とJpaRepositoryインターフェースを継承
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {	// <エンティティ名, 主キーのデータ型>
	List<ToDo> findByTitle(String title);
}