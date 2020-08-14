package tp.kits3.livedinner.vo;

public class Contact {

    private Integer coid;

    private String coname;

    private String priphone;

    private String subphone;

    private String email;

	private String address;

    private Boolean unused;

    private String opening;

    private String weekday;

    private String weekend;

    private String aboutus;

    private Double latitude;

    private Double logitude;

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public String getPriphone() {
        return priphone;
    }

    public void setPriphone(String priphone) {
        this.priphone = priphone;
    }

    public String getSubphone() {
        return subphone;
    }

    public void setSubphone(String subphone) {
        this.subphone = subphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getUnused() {
        return unused;
    }

    public void setUnused(Boolean unused) {
        this.unused = unused;
    }

    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getWeekend() {
        return weekend;
    }

    public void setWeekend(String weekend) {
        this.weekend = weekend;
    }

    public String getAboutus() {
        return aboutus;
    }

    public void setAboutus(String aboutus) {
        this.aboutus = aboutus;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLogitude() {
        return logitude;
    }

    public void setLogitude(Double logitude) {
        this.logitude = logitude;
    }

    @Override
	public String toString() {
    	return "Contact [coid=" + coid + ", priphone="+priphone + ", coname=" + coname + ", email=" + email + ", address=" + address +  ""
    			+ ", unused=" + (unused?1:0) + ", opening=" + opening +  ", weekday=" + weekday +  ", weekend=" + weekend + ", aboutus=" + aboutus +  ""
    					+ ", latitude=" + latitude + ", logitude=" + logitude + "]";
	}

	// Contact 모델 복사
    public void CopyData(Contact param)
    {
        this.coid = param.getCoid();
        this.coname = param.getConame();
        this.priphone = param.getPriphone();
        this.subphone = param.getSubphone();
        this.email = param.getEmail();
        this.address = param.getAddress();
        this.unused = param.getUnused();
        this.opening = param.getOpening();
        this.weekday = param.getWeekday();
        this.weekend = param.getWeekend();
        this.aboutus = param.getAboutus();
        this.latitude = param.getLatitude();
        this.logitude = param.getLogitude();
    }
    
}