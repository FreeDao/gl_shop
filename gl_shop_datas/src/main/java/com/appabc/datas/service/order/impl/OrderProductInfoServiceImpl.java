/**
 *
 */
package com.appabc.datas.service.order.impl;

import com.appabc.bean.pvo.TOrderProductInfo;
import com.appabc.common.base.QueryContext;
import com.appabc.datas.dao.order.IOrderProductInfoDao;
import com.appabc.datas.service.order.IOrderProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description : 交易中的商品信息SERVICE实现
 * @Copyright   : GL. All Rights Reserved
 * @Company     : 江苏国立网络技术有限公司
 * @author      : 杨跃红
 * @version     : 1.0
 * Create Date  : 2014年9月11日 上午9:50:01
 */
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class OrderProductInfoServiceImpl implements IOrderProductInfoService{
	
	@Autowired
	private IOrderProductInfoDao orderProductInfoDao;

	public void add(TOrderProductInfo entity) {
		this.orderProductInfoDao.save(entity);
	}

	public void modify(TOrderProductInfo entity) {
		this.orderProductInfoDao.update(entity);
	}

	public void delete(TOrderProductInfo entity) {
		this.orderProductInfoDao.delete(entity);
	}

	public void delete(Serializable id) {
		this.orderProductInfoDao.delete(id);
	}

	public TOrderProductInfo query(TOrderProductInfo entity) {
		return this.orderProductInfoDao.query(entity);
	}

	public TOrderProductInfo query(Serializable id) {
		return this.orderProductInfoDao.query(id);
	}

	public List<TOrderProductInfo> queryForList(TOrderProductInfo entity) {
		return this.orderProductInfoDao.queryForList(entity);
	}

	public List<TOrderProductInfo> queryForList(Map<String, ?> args) {
		return this.orderProductInfoDao.queryForList(args);
	}

	public QueryContext<TOrderProductInfo> queryListForPagination(
			QueryContext<TOrderProductInfo> qContext) {
		return this.orderProductInfoDao.queryListForPagination(qContext);
	}

}
