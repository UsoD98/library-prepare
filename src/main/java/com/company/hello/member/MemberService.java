package com.company.hello.member;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MemberService {

    public int signUpConfirm(MemberVo memberVo) {
        log.info("[MemberService] signUpConfirm()");

        log.info("m_id: " + memberVo.getM_id());
        log.info("m_pw: " + memberVo.getM_pw());
        log.info("m_mail: " + memberVo.getM_mail());
        log.info("m_phone: " + memberVo.getM_phone());

        return 0;
    }

}
