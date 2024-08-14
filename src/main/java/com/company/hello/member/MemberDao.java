package com.company.hello.member;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Log4j2
@Component
public class MemberDao {

    private Map<String, MemberVo> memberDB = new HashMap<>();

    public void insertMember(MemberVo memberVo) {
        log.info("[MemberDao] insertMember()");

        log.info("m_id: " + memberVo.getM_id());
        log.info("m_pw: " + memberVo.getM_pw());
        log.info("m_mail: " + memberVo.getM_mail());
        log.info("m_phone: " + memberVo.getM_phone());

        memberDB.put(memberVo.getM_id(), memberVo);
        printAllMember();   // 모든 회원 정보 출력
    }

    private void printAllMember() {
        log.info("[MemberDao] printAllMember()");

        Set<String> keys = memberDB.keySet();
        Iterator<String> iterator = keys.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            MemberVo memberVo = memberDB.get(key);

            log.info("m_id: " + memberVo.getM_id());
            log.info("m_pw: " + memberVo.getM_pw());
            log.info("m_mail: " + memberVo.getM_mail());
            log.info("m_phone: " + memberVo.getM_phone());
        }
    }

    public MemberVo selectMember(MemberVo memberVo) {
        log.info("[MemberDao] selectMember()");

        MemberVo signInedMember = memberDB.get(memberVo.getM_id());

        if (signInedMember != null && memberVo.getM_pw().equals(signInedMember.getM_pw())) {
            return signInedMember;
        } else {
            return null;
        }
    }
}
