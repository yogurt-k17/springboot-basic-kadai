package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	@GetMapping("/form") //URLアクセス時にメソッドが呼び出される
	public String form(Model model) { //modelにデータを格納
		if (!model.containsAttribute("form")) { // リダイレクトされた時に上書きされないため
			model.addAttribute("form", new ContactForm()); //フォームクラスのインスタンスを渡す
		}
		return "contactFormView";
	}

	@PostMapping("/confirm") //フォームからPOSTされたデータを受ける
	public String confirm(RedirectAttributes redirectAttributes, //リダイレクト後に一度きりで表示されるデータを保持するためのオブジェクト
			@Validated ContactForm form, // バリデーションを行うクラス
			BindingResult result, Model model) { // バリデーション結果を格納するオブジェクト

		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("form", form); //Flash:リダイレクト後の1回だけ使用

			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "form", result); //バリデーション結果をビューに受け渡す
			return "redirect:/form"; //再表示
		}
		model.addAttribute("form", form);
		return "confirmView";

	}
}