package jdbc.insert2;

public class ItemDto {
	private int itemNo;
	private String itemName;
	private String itemType;
	private int itemPrice;
	private int itemDiscountRate;
	private int itemQty;
	private String itemEarly;
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemDiscountRate() {
		return itemDiscountRate;
	}
	public void setItemDiscountRate(int itemDiscountRate) {
		this.itemDiscountRate = itemDiscountRate;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	public String getItemEarly() {
		return itemEarly;
	}
	public void setItemEarly(String itemEarly) {
		this.itemEarly = itemEarly;
	}
	public ItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ItemDto [itemNo=" + itemNo + ", itemName=" + itemName + ", itemType=" + itemType + ", itemPrice="
				+ itemPrice + ", itemDiscountRate=" + itemDiscountRate + ", itemQty=" + itemQty + ", itemEarly="
				+ itemEarly + "]";
	}
}
