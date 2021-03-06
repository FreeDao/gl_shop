package com.appabc.bean.pvo;

import com.appabc.bean.enums.ProductInfo.UnitEnum;
import com.appabc.common.base.bean.BaseBean;

import java.util.Date;

public class TProductPrice extends BaseBean {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7529406211556605868L;

    /**
     * 商品ID
     */
    private String pid;

    /**
     * 价格
     */
    private Float price;

    /**
     * 单位
     */
    private UnitEnum unit;

    /**
     * 时间点
     */
    private Date datepoint;

    /**
     * 地区
     */
    private String area;

    /**
     * 更新人
     */
    private String updater;

    /**
     * 更新时间
     */
    private Date updatetime;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDatepoint() {
        return datepoint;
    }

    public void setDatepoint(Date datepoint) {
        this.datepoint = datepoint;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

	/**  
	 * unit  
	 *  
	 * @return  the unit  
	 * @since   1.0.0  
	*/  
	
	public UnitEnum getUnit() {
		return unit;
	}

	/**  
	 * @param unit the unit to set  
	 */
	public void setUnit(UnitEnum unit) {
		this.unit = unit;
	}
}