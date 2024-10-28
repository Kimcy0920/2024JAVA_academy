package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {

	private MemberRegisterService memberRegisterService;

	public void setMemberRegisterService(
			MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	@GetMapping("/")
	public String root() {
		return "redirect:/register/step1";
	}
	
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@PostMapping("/register/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}

	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/register/step3") // RegisterRequest 커맨드 객체
	public String handleStep3(RegisterRequest regReq, BindingResult errors) { // (regReq, errors)프레임워크가 알아서 객체 생성해줌
		// BindingResult errors = Errors errors
		// RegisterRequestValidator -> @Override public void validate(Object target(1), Errors errors(2)) {
		new RegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors())
			return "register/step2"; // 에러 발생시 step2로 리턴
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException ex) {
//			errors.rejectValue("email", "duplicate"); // label.properties -> duplicate.email=중복된 이메일입니다.
			errors.reject("notMatchingPassword"); // p.335
			return "register/step2";
		}
	}

}