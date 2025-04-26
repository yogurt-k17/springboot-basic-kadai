package com.example.springkadaitodo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity					//クラスをエンティティとして機能させる
@Table(name = "todos")	//クラスにデータベースのテーブルを紐づける
@Data					//Lombokでゲッターやセッターなどを自動生成する
public class ToDo {
	@Id					//フィールドを、主キーのカラムとして機能させる
	@GeneratedValue(strategy = GenerationType.IDENTITY) //主キーのカラムに設定する値を自動生成
	@Column(name = "id")	//フィールドにデータベースのカラムを紐づける
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "status")
	private String status;

}
