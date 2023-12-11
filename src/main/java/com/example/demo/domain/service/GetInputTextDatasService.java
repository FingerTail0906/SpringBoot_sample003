package com.example.demo.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.app.bean.InputTextDatasBean;
import com.example.demo.app.form.DisplayDataForm;
import com.example.demo.domain.entity.InputTextDatasEntity;
import com.example.demo.domain.repository.InputTextDatasRepository;


@Service
public class GetInputTextDatasService {
	
	@Autowired
	InputTextDatasRepository inputTextDatasRepository;
	
	
	public List<InputTextDatasBean> getAllDatas() {
		
		
		List<InputTextDatasEntity> listInputTextDatasEntity = inputTextDatasRepository.findAll();
		List<InputTextDatasBean> listInputTextDatasBean = new ArrayList();
		
		listInputTextDatasEntity.forEach(inputTextDatasEntity -> {
			InputTextDatasBean inputTextDatasBean = new InputTextDatasBean();
			inputTextDatasBean.setId(inputTextDatasEntity.getId());
			inputTextDatasBean.setTextData(inputTextDatasEntity.getTextData());
			listInputTextDatasBean.add(inputTextDatasBean);
		});
		
		return listInputTextDatasBean;
	}
	
	public InputTextDatasBean getIdDatas(Integer id) {
		
		Optional<InputTextDatasEntity> inputTextDatasEntity = inputTextDatasRepository.findById(id);
		InputTextDatasBean inputTextDatasBean = new InputTextDatasBean();
		inputTextDatasBean.setId(inputTextDatasEntity.get().getId());
		inputTextDatasBean.setTextData(inputTextDatasEntity.get().getTextData());
		
		return inputTextDatasBean;
	}
	
	public void updateInputTextDatas(DisplayDataForm displayDataForm) {
		
		inputTextDatasRepository.update( displayDataForm.getId(), displayDataForm.getTextData());
	}
	
	public void deleteInputTextDatas(Integer id) {
		
		inputTextDatasRepository.delete( id );
		
	}
	
	public void insertInputTextDatas(String textData) {
		
		inputTextDatasRepository.insert(textData);
		
	}
	
	

}
