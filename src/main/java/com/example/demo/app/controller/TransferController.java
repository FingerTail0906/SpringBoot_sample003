package com.example.demo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.app.bean.InputTextDatasBean;
import com.example.demo.app.form.DisplayDataForm;
import com.example.demo.domain.service.GetInputTextDatasService;


@Controller
public class TransferController {
	
	@Autowired
	GetInputTextDatasService getInputTextDatasService;
		
	
	@GetMapping("/index")
    public String getFrom(ModelMap modelMap) {
		List<InputTextDatasBean> listInputTextDatasBean = getInputTextDatasService.getAllDatas();
		modelMap.addAttribute("listInputTextDatasBean", listInputTextDatasBean);
		return "view/index";
	}
	
	@PostMapping("/save")
	public String saveAction(ModelMap modelMap,@RequestParam String textData) {
		
		getInputTextDatasService.insertInputTextDatas(textData);
		return "redirect:/index";
	}
	
	@GetMapping("/edit")
	public String editAction(ModelMap modelMap,@RequestParam Integer id ) {
		
		InputTextDatasBean inputTextDatasBean = getInputTextDatasService.getIdDatas(id);
		modelMap.addAttribute("inputTextDatasBean",inputTextDatasBean);
		return "view/edit";
	}
	
	@PostMapping("/update")
    public String updateAction(ModelMap modelMap,@ModelAttribute("DisplayDataForm") DisplayDataForm displayDataForm) {
		
		getInputTextDatasService.updateInputTextDatas(displayDataForm);
		return "redirect:/index";
	}
	
	@PostMapping("/delete")
    public String deleteAction(ModelMap modelMap,@RequestParam Integer id) {
		
		getInputTextDatasService.deleteInputTextDatas(id);
		return "redirect:/index";
	}
}
