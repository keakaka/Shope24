package com.cafe24.shope24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shope24.repository.MemberDao;
import com.cafe24.shope24.vo.DeliveryAddressVo;
import com.cafe24.shope24.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public boolean checkId(String id) {
		return memberDao.checkId(id);
	}

	public Boolean insertMember(MemberVo memberVo) {
		
		return memberDao.insertMember(memberVo);
	}

	public MemberVo login(MemberVo memberVo) {
		
		return memberDao.login(memberVo);
	}

	public Boolean myPage(Long memberNo) {
		return true;
	}

	public Boolean myDelivery(Long memberNo) {
		return true;
	}

	public Boolean myDeliveryAdd(Long memberNo, DeliveryAddressVo daVo) {
		return true;
	}

	public Boolean myDeliveryDel(Long memberNo, DeliveryAddressVo daVo) {
		return true;
	}

	public Boolean getMyInfo(Long memberNo) {
		return true;
	}

	public Boolean updateMyInfo(MemberVo memberVo) {
		return true;
	}

	public Boolean getShowCart(String param) {
		return true;
	}

	public MemberVo getAdmin(MemberVo memberVo) {
		return memberDao.getAdmin(memberVo);
	}

}
