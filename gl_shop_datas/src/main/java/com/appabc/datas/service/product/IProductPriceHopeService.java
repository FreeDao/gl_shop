/**
 *
 */
package com.appabc.datas.service.product;

import com.appabc.bean.pvo.TProductPriceHope;
import com.appabc.common.base.service.IBaseService;

import java.util.List;
import java.util.Map;


/**
 * @Description : 洞口预测SERVICE接口
 * @Copyright   : GL. All Rights Reserved
 * @Company     : 江苏国立网络技术有限公司
 * @author      : 杨跃红
 * @version     : 1.0
 * Create Date  : 2014年8月28日 上午10:03:36
 */
public interface IProductPriceHopeService extends IBaseService<TProductPriceHope>{
	
	/**
	 * 查询商品当天价格+未来1周价格+未来2周价格
	 * @param area
	 * @param pcode
	 * @return
	 */
	public List<Map<String, Object>> queryHopePrice(String area, String pcode);
}
