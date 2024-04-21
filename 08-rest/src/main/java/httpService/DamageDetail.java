package httpService;

//import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlRootElement;
//import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class DamageDetail {
	
	private DamageType type;
	private String desc;
//	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private String date;

	public DamageDetail() {
		super();
	}
	
	public DamageDetail(DamageType type, String desc, String date) {
		super();
		this.type = type;
		this.desc = desc;
		this.date = date;
	}

//	public DamageDetail(DamageType type, String desc, LocalDate date) {
//		super();
//		this.type = type;
//		this.desc = desc;
//		this.date = date;
//	}

//	public LocalDate getDate() {
//		return date;
//	}
//
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}


	public String getDesc() {
		return desc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public DamageType getType() {
		return type;
	}


	public void setType(DamageType type) {
		this.type = type;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}	
}
