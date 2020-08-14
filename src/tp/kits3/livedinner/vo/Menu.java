package tp.kits3.livedinner.vo;

public class Menu {

	private Integer muid;

	private Integer ctgid;

	private String muname;

	private String intro;

	private String details;

	private Double price;

	private String currency;

	private String img;

	public Menu() {
		super();
	}

	public Menu(Integer muid, Integer ctgid, String muname, String intro, String details, Double price, String currency,
			String img) {
		super();
		this.muid = muid;
		this.ctgid = ctgid;
		this.muname = muname;
		this.intro = intro;
		this.details = details;
		this.price = price;
		this.currency = currency;
		this.img = img;
	}

	/**
	 * @return the muid
	 */
	public Integer getMuid() {
		return muid;
	}

	/**
	 * @param muid the muid to set
	 */
	public void setMuid(Integer muid) {
		this.muid = muid;
	}

	/**
	 * @return the ctgid
	 */
	public Integer getCtgid() {
		return ctgid;
	}

	/**
	 * @param ctgid the ctgid to set
	 */
	public void setCtgid(Integer ctgid) {
		this.ctgid = ctgid;
	}

	/**
	 * @return the muname
	 */
	public String getMuname() {
		return muname;
	}

	/**
	 * @param muname the muname to set
	 */
	public void setMuname(String muname) {
		this.muname = muname;
	}

	/**
	 * @return the intro
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * @param intro the intro to set
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	// Menu 모델 복사
	public void CopyData(Menu param) {
		this.muid = param.getMuid();
		this.ctgid = param.getCtgid();
		this.muname = param.getMuname();
		this.intro = param.getIntro();
		this.details = param.getDetails();
		this.price = param.getPrice();
		this.currency = param.getCurrency();
	}
}