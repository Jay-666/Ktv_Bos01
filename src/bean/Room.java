package bean;

import java.awt.List;
import java.util.ArrayList;

public class Room {

	//1�����
	private String id;
	//2����
	private String district;
	//3����
	private String type;
	//4�۸�
	private Integer prices;
	//5״̬
	private String situation;
	//6״̬��ע
	private String remark;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPrices() {
		return prices;
	}
	public void setPrices(Integer prices) {
		this.prices = prices;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Rooms [id=" + id + ", district=" + district + ", type=" + type + ", prices=" + prices + ", situation="
				+ situation + ", remark=" + remark + "]";
	}
	
	
}
