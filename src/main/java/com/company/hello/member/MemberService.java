package com.company.hello.member;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MemberService {

    @Autowired
    MemberDao memberDao;

    public int signUpConfirm(MemberVo memberVo) {
        log.info("[MemberService] signUpConfirm()");

        log.info("m_id: " + memberVo.getM_id());
        log.info("m_pw: " + memberVo.getM_pw());
        log.info("m_mail: " + memberVo.getM_mail());
        log.info("m_phone: " + memberVo.getM_phone());

        memberDao.insertMember(memberVo);

        return 0;
    }

    public MemberVo signInConfirm(MemberVo memberVo) {
        log.info("[MemberService] signInConfirm()");

        MemberVo signInedMember = memberDao.selectMember(memberVo);

        return signInedMember;  // 로그인 성공 시 회원 정보 반환, 실패 시 null 반환
    }

}
