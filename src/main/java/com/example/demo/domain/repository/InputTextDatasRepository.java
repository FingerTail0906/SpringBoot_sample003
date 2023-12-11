package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.InputTextDatasEntity;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface InputTextDatasRepository extends JpaRepository<InputTextDatasEntity, Integer> {
	
	// 更新用
	@Modifying
	@Query(value = "update input_text_datas  set text_data = :textData where id = :id",nativeQuery=true)
	public void update(
			@Param("id") Integer id,
			@Param("textData") String textData
	);
	
	// 削除用
	@Modifying
	@Query(value = "delete from input_text_datas  where id = :id",nativeQuery=true)
	public void delete(
			@Param("id") Integer id
	);
	
	// 登録用
	@Modifying
	@Query(value = "insert into input_text_datas (text_data) values(:textData)",nativeQuery=true)
	public void insert(
			@Param("textData") String textData
	);

}
