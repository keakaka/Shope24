package com.cafe24.shope24.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shope24.vo.MemberVo;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	private final String key = "FeelSoGoooooood";
	
	public Boolean checkId(String id) {
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setKey(key);
		return sqlSession.selectOne("member.checkId", vo) == null ;
	}

	public Boolean insertMember(MemberVo memberVo) {
		memberVo.setKey(key);
		return sqlSession.insert("member.insertMember", memberVo) == 1;
	}

	public MemberVo login(MemberVo memberVo) {
		memberVo.setKey(key);
		return sqlSession.selectOne("member.login", memberVo);
	}

}
 