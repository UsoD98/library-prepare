package com.company.hello.member;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/signUp")
    public String signUp() {
        log.info("signUp");
        return "sign_up";
    }

    @RequestMapping("/signIn")
    public String signIn() {
        log.info("signIn");
        return "sign_in";
    }

    @RequestMapping("/signUpConfirm")
    public String signUpConfirm(MemberVo memberVo) {
        log.info("[MemberController] signupConfirm()");

        log.info("m_id: " + memberVo.getM_id());
        log.info("m_pw: " + memberVo.getM_pw());
        log.info("m_mail: " + memberVo.getM_mail());
        log.info("m_phone: " + memberVo.getM_phone());

        memberService.signUpConfirm(memberVo);

        return "sign_up_ok";
    }

    @RequestMapping("/signInConfirm")
    public String signInConfirm(MemberVo memberVo) {
        log.info("[MemberController] signInConfirm()");

        MemberVo signInedMember = memberService.signInConfirm(memberVo);

        if (signInedMember != null) {
            log.info("Login Success");
            return "sign_in_ok";
        } else {
            return "sign_in_ng";
        }
    }
}
