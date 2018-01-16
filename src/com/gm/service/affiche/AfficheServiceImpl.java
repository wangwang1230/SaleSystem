package com.gm.service.affiche;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gm.dao.affiche.AfficheMapper;
import com.gm.pojo.Affiche;
@Service
public class AfficheServiceImpl implements AfficheService {
	@Resource
	private AfficheMapper afficheMapper;
	@Override
	public List<Affiche> getList(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		return afficheMapper.getList(affiche);
	}

	@Override
	public List<Affiche> getAfficheList(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		return afficheMapper.getAfficheList(affiche);
	}

	@Override
	public Affiche getAffiche(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		return afficheMapper.getAffiche(affiche);
	}

	@Override
	public int addAffiche(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		return afficheMapper.addAffiche(affiche);
	}

	@Override
	public int modifyAffiche(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		return afficheMapper.modifyAffiche(affiche);
	}

	@Override
	public int deleteAffiche(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		return afficheMapper.deleteAffiche(affiche);
	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		return afficheMapper.count();
	}

	@Override
	public int portalCount() throws Exception {
		// TODO Auto-generated method stub
		return afficheMapper.portalCount();
	}

	@Override
	public List<Affiche> getPortalAfficheList(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		return afficheMapper.getPortalAfficheList(affiche);
	}

}
