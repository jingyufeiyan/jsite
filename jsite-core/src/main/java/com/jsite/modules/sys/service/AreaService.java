package com.jsite.modules.sys.service;

import com.jsite.common.service.CrudService;
import com.jsite.modules.sys.dao.AreaDao;
import com.jsite.modules.sys.entity.Area;
import com.jsite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 区域Service
 ** @author liuruijun
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class AreaService extends CrudService<AreaDao, Area> {
	
	public Area get(String id) {
		return super.get(id);
	}
	
	public List<Area> findAll(){
		return UserUtils.getAreaList();
	}

	@Transactional(readOnly = false)
	public void save(Area area) {
		super.save(area);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(Area area) {
		super.delete(area);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
}