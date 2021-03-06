package com.glshop.net.ui.basic.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.glshop.net.R;
import com.glshop.net.logic.model.MenuItemInfo;
import com.glshop.net.logic.syscfg.mgr.SysCfgUtils;
import com.glshop.net.ui.basic.adapter.base.BasicExpandListAdapter;
import com.glshop.net.ui.basic.adapter.base.ViewHolder;
import com.glshop.platform.api.buy.data.model.ForecastPriceModel;
import com.glshop.platform.utils.StringUtils;

/**
 * @Description : 未来价格趋势适配器(目前用于显示黄沙)
 * @Copyright   : GL. All Rights Reserved
 * @Company     : 深圳市国立数码动画有限公司
 * @author      : 叶跃丰
 * @version     : 1.0
 * Create Date  : 2014-7-30 上午11:26:26
 */
public class ForecastPriceExAdapter extends BasicExpandListAdapter<MenuItemInfo, ForecastPriceModel> {

	public ForecastPriceExAdapter(Context context, List<MenuItemInfo> groupIndexList, Map<MenuItemInfo, ArrayList<ForecastPriceModel>> groupMap) {
		super(context, groupIndexList, groupMap);
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(mContext, R.layout.adapter_price_trend_group_item, null);
		}
		MenuItemInfo groupModel = getGroupItem(groupPosition);
		if (groupModel != null) {
			// group 展开icon
			ImageView mIvGroupExpand = ViewHolder.get(convertView, R.id.iv_product_group_expand);
			if (isExpanded) {
				mIvGroupExpand.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_listview_expand));
			} else {
				mIvGroupExpand.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_listview_collapse));
			}
			// group 分类类型
			TextView mTvGroupName = ViewHolder.get(convertView, R.id.tv_product_group_name);
			mTvGroupName.setText(groupModel.menuText);
		}
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(mContext, R.layout.adapter_price_trend_item, null);
		}

		ForecastPriceModel model = getChild(groupPosition, childPosition);

		// 规格&大小
		TextView mTvProductSpec = ViewHolder.get(convertView, R.id.tv_product_spec);
		TextView mTvProductSpecSize = ViewHolder.get(convertView, R.id.tv_product_spec_size);

		if (model.productInfo != null) {
			// 显示规格名称
			String specName = model.productInfo.mSubCategoryName;
			if (StringUtils.isNotEmpty(specName)) {
				mTvProductSpec.setText(specName);
				mTvProductSpec.setVisibility(View.VISIBLE);
			} else {
				mTvProductSpec.setVisibility(View.GONE);
			}
			// 显示规格大小
			String specSize = SysCfgUtils.getSize(model.productInfo);
			if (StringUtils.isNotEmpty(specSize)) {
				mTvProductSpecSize.setText(specSize);
				mTvProductSpecSize.setVisibility(View.VISIBLE);
			} else {
				mTvProductSpecSize.setVisibility(View.GONE);
			}
		} else {
			mTvProductSpec.setVisibility(View.GONE);
			mTvProductSpecSize.setVisibility(View.GONE);
		}

		// 显示今日报价
		TextView mTvTodayPrice = ViewHolder.get(convertView, R.id.tv_product_today_price);
		if (StringUtils.isNEmpty(model.todayPrice)) {
			mTvTodayPrice.setText(mContext.getString(R.string.price_data_empty));
		} else {
			mTvTodayPrice.setText(model.todayPrice/* + mContext.getString(R.string.unit_price_ton)*/);
		}

		// 显示未来一周预测
		TextView mTvOneWeekPrice = ViewHolder.get(convertView, R.id.tv_product_oneweek_price);
		ImageView mIvOneWeekTrend = ViewHolder.get(convertView, R.id.iv_one_week_trend);
		if (StringUtils.isNEmpty(model.oneWeekForecastPrice)) {
			mTvOneWeekPrice.setText(mContext.getString(R.string.price_data_empty));
			mIvOneWeekTrend.setVisibility(View.GONE);
		} else {
			mTvOneWeekPrice.setText(model.oneWeekForecastPrice/* + mContext.getString(R.string.unit_price)*/);
			mIvOneWeekTrend.setVisibility(View.VISIBLE);
			if (StringUtils.isNEmpty(model.todayPrice)) {
				mIvOneWeekTrend.setVisibility(View.GONE);
			} else {
				if (Float.parseFloat(model.oneWeekForecastPrice) > Float.parseFloat(model.todayPrice)) {
					mIvOneWeekTrend.setBackgroundResource(R.drawable.ic_price_up);
				} else if (Float.parseFloat(model.oneWeekForecastPrice) < Float.parseFloat(model.todayPrice)) {
					mIvOneWeekTrend.setBackgroundResource(R.drawable.ic_price_down);
				} else {
					mIvOneWeekTrend.setVisibility(View.GONE);
				}
			}
		}

		// 显示未来两周预测
		TextView mTvTwoWeekPrice = ViewHolder.get(convertView, R.id.tv_product_twoweek_price);
		ImageView mIvTwoWeekTrend = ViewHolder.get(convertView, R.id.iv_two_week_trend);
		if (StringUtils.isNEmpty(model.twoWeekForecastPrice)) {
			mTvTwoWeekPrice.setText(mContext.getString(R.string.price_data_empty));
			mIvTwoWeekTrend.setVisibility(View.GONE);
		} else {
			mTvTwoWeekPrice.setText(model.twoWeekForecastPrice/* + mContext.getString(R.string.unit_price)*/);
			mIvTwoWeekTrend.setVisibility(View.VISIBLE);
			if (StringUtils.isNEmpty(model.todayPrice)) {
				mIvTwoWeekTrend.setVisibility(View.GONE);
			} else {
				if (Float.parseFloat(model.twoWeekForecastPrice) > Float.parseFloat(model.todayPrice)) {
					mIvTwoWeekTrend.setBackgroundResource(R.drawable.ic_price_up);
				} else if (Float.parseFloat(model.twoWeekForecastPrice) < Float.parseFloat(model.todayPrice)) {
					mIvTwoWeekTrend.setBackgroundResource(R.drawable.ic_price_down);
				} else {
					mIvTwoWeekTrend.setVisibility(View.GONE);
				}
			}
		}

		return convertView;
	}

}
