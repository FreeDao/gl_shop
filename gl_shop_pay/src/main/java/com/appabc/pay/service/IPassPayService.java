/**  
 * com.appabc.pay.service.IPassPayService.java  
 *   
 * 2014年9月17日 下午8:02:29  
 * Copyright APPABC Information System Co.Ltd. All rights reserved.
 */
package com.appabc.pay.service;

import java.util.List;

import com.appabc.bean.enums.PurseInfo.ExtractStatus;
import com.appabc.bean.enums.PurseInfo.PayDirection;
import com.appabc.bean.enums.PurseInfo.PurseType;
import com.appabc.bean.enums.PurseInfo.TradeType;
import com.appabc.common.base.QueryContext;
import com.appabc.pay.bean.OInfo;
import com.appabc.pay.bean.TAcceptBank;
import com.appabc.pay.bean.TOfflinePay;
import com.appabc.pay.bean.TPassbookDraw;
import com.appabc.pay.bean.TPassbookInfo;
import com.appabc.pay.bean.TPassbookPay;
import com.appabc.pay.exception.ServiceException;

/**
 * @Description : 支付模块的service
 * @Copyright   : GL. All Rights Reserved
 * @Company     : 江苏国立网络技术有限公司
 * @author      : 黄建华
 * @version     : 1.0
 * @Create_Date  : 2014年9月17日 下午8:02:29
 */

public interface IPassPayService {
	
	/**  
	 * initializePurseAccount (钱包和保证金账户的初始化)  
	 * @param cid:type  
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean initializePurseAccount(String cid,PurseType type);
	
	/**  
	 * getPurseAccountInfo (获取我的账户信息)  
	 * @param cid:type  
	 * @author Bill huang 
	 * @return Object  
	 * @exception   
	 * @since  1.0.0  
	 */
	TPassbookInfo getPurseAccountInfo(String cid,PurseType type);
	
	/**  
	 * saveAcceptBank (增加收款人账户信息)  
	 * @param tAcceptBank  
	 * @author Bill huang 
	 * @return void  
	 * @exception   
	 * @since  1.0.0  
	 */
	void saveAcceptBank(TAcceptBank tAcceptBank) throws ServiceException;
	
	/**  
	 * getAcceptBankList (获取收款人账户信息列表)  
	 * @param cid   ...args
	 * @author Bill huang 
	 * @return List<TAcceptBank>  
	 * @exception   
	 * @since  1.0.0  
	 */
	List<TAcceptBank> getAcceptBankList(String cid,String...args);
	
	/**  
	 * getAcceptBankList (获取收款人账户信息列表,支持分页查询)  
	 * @param cid   ...args
	 * @author Bill huang 
	 * @return List<TAcceptBank>  
	 * @exception   
	 * @since  1.0.0  
	 */
	QueryContext<TAcceptBank> getAcceptBankList(QueryContext<TAcceptBank> qContext);
	
	/**  
	 * depositAccountOnline (线上充值(保证金和货款))  
	 * @param cid:type:balance:payNo  
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean depositAccountOnline(String cid,PurseType type,float balance,String payNo);
	
	/**  
	 * depositAccountOfflineRequest (线下充值(保证金和货款)申请)  
	 * @param cid:type
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean depositAccountOfflineRequest(String cid,PurseType type);
	
	/**  
	 * depositAccountOffline (线下充值(保证金和货款)账户充钱)  
	 * @param cid:type
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean depositAccountOffline(String cid,PurseType type,float balance,String payNo);
	
	/**  
	 * payAccountOfflineRequest (线下付款申请)  
	 * @param cid:type
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean payAccountOfflineRequest(String cid,PurseType type,OInfo oid);
	
	/**  
	 * depositThirdOrgRecord (充值三方机构对账)  
	 * @param cid:type:balance:payNo  
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean depositThirdOrgRecord(String cid,PurseType type,float balance,String payNo);
	
	/**  
	 * payRecordList (流水信息列表查询)  
	 * @param passId  
	 * @author Bill huang 
	 * @return List<?>  
	 * @exception   
	 * @since  1.0.0  
	 */
	List<TPassbookPay> payRecordList(String passId);
	
	/**  
	 * payRecordList (流水信息列表查询)  
	 * @param cid:type  
	 * @author Bill huang 
	 * @return List<?>  
	 * @exception   
	 * @since  1.0.0  
	 */
	List<TPassbookPay> payRecordList(String cid,PurseType type);
	
	/**  
	 * payRecordList (流水信息列表查询)  
	 * @param cid:  type: payDirection
	 * @author Bill huang 
	 * @return List<TPassbookPay>  
	 * @exception   
	 * @since  1.0.0  
	 */
	List<TPassbookPay> payRecordList(String cid,PurseType type,PayDirection payDirection);
	
	/**  
	 * payRecordList (流水信息列表查询,支持分页查询和参数查询)  
	 * @param qContext
	 * @author Bill huang 
	 * @return List<TPassbookPay>  
	 * @exception   
	 * @since  1.0.0  
	 */
	QueryContext<TPassbookPay> payRecordList(QueryContext<TPassbookPay> qContext);
	
	/**  
	 * payRecordDetail (流水信息明细查询)  
	 * @param pid  
	 * @author Bill huang 
	 * @return Object  
	 * @exception   
	 * @since  1.0.0  
	 */
	TPassbookPay payRecordDetail(String pid);
	
	/**  
	 * extractCashRequest (提现申请接口)  
	 * @param cid:type:balance:acceptId  
	 * @author Bill huang 
	 * @return Float  
	 * @exception   
	 * @since  1.0.0  
	 */
	TPassbookDraw extractCashRequest(String cid,PurseType type,Float balance,String acceptId);
	
	/**  
	 * extractCashAudit (提现审批接口)  
	 * @param tid:result:reson:cid  
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean extractCashAudit(String tid,boolean result,String reson,String cid);
	
	/**  
	 * extractCashDeduct (提现扣款接口)  
	 * @param tid  
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean extractCashDeduct(String tid);
	
	/**  
	 * extractCashRequestList (查询提现申请记录)  
	 * @param cid:type  
	 * @author Bill huang 
	 * @return List<?>  
	 * @exception   
	 * @since  1.0.0  
	 */
	List<TPassbookDraw> extractCashRequestList(String cid,PurseType type);
	
	/**  
	 * extractCashRequestList (查询提现申请记录)  
	 * @param status  
	 * @author Bill huang 
	 * @return List<?>  
	 * @exception   
	 * @since  1.0.0  
	 */
	List<TPassbookDraw> extractCashRequestList(ExtractStatus status);
	
	/**  
	 * extractCashRequestList (查询提现申请记录,支持分页查询和参数查询)  
	 * @param qContext  
	 * @author Bill huang 
	 * @return List<?>  
	 * @exception   
	 * @since  1.0.0  
	 */
	QueryContext<TPassbookDraw> extractCashRequestList(QueryContext<TPassbookDraw> qContext);
	
	/**  
	 * depositToGuaranty (货款充值保证金)  
	 * @param cid:balance  
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean depositToGuaranty(String cid,Float balance);
	
	/**  
	 * transferAccounts (账户付款,转账接口)  
	 * @param sourPassId:destPassId:balance:type  
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean transferAccounts(String sourPassId,String destPassId,Float balance,PurseType type);
	
	/**  
	 * transferAccounts (账户付款,转账接口)  
	 * @param sourPassId:destPassId:balance:purseType:tradeType  
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean transferAccounts(String sourPassId,String destPassId,Float balance,TradeType tradeType);
	
	/**  
	 * guarantyToGelation (保证金冻结接口)  
	 * @param cid:balance:oid
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean guarantyToGelation(String cid,float balance,String oid);
	
	/**  
	 * guarantyToUngelation (保证金解冻接口)  
	 * @param cid:balance:oid  
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean guarantyToUngelation(String cid,float balance,String oid);
	
	/**  
	 * guarantyToDeduct (保证金扣除接口)  
	 * @param sourPassId:destPassId:balance
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean guarantyToDeduct(String sourPassId,String destPassId,Float balance);
	
	/**  
	 * getGuarantyTotal (获取保证金总额:包含保证金账户现有的金额和冻结的保证金)  
	 * @param cid
	 * @author Bill huang 
	 * @return float  
	 * @exception   
	 * @since  1.0.0  
	 */
	float getGuarantyTotal(String cid);
	
	/**  
	 * saveOfflinePay (保存线下收款记录)  
	 * @param tOfflinePay  
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	void saveOfflinePay(TOfflinePay tOfflinePay) throws ServiceException;
	
	/**  
	 * auditeOfflinePay (审核和更新线下收款记录)  
	 * @param tOfflinePay  
	 * @author Bill huang 
	 * @return boolean  
	 * @exception   
	 * @since  1.0.0  
	 */
	boolean auditeOfflinePay(TOfflinePay tOfflinePay);
	
	/**  
	 * getOfflinePayList (获取线下收款记录)  
	 * @param contractId  
	 * @author Bill huang 
	 * @return List<TOrderPay>  
	 * @exception   
	 * @since  1.0.0  
	 */
	List<TOfflinePay> getOfflinePayList(String contractId,String...args);
	
	/**  
	 * getOfflinePayList (获取线下收款记录,支持分页查询和参数查询)  
	 * @param contractId  
	 * @author Bill huang 
	 * @return List<TOrderPay>  
	 * @exception   
	 * @since  1.0.0  
	 */
	QueryContext<TOfflinePay> getOfflinePayList(QueryContext<TOfflinePay> qContext);
}
