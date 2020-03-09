package com.vd.project.vital.vital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@TypeDef(
	    name = "jsonb",
	    typeClass = JsonBinaryType.class
	    
	)
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Mother  {
	@Id 
private Long id;
	
	@Type(type="jsonb")
@Column(columnDefinition ="jsonb")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private String basicinfo;
	public Mother()
	{}
public Mother(Long id, String basicinfo) {
		super();
		this.id = id;
		this.basicinfo = basicinfo;
	}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getBasicinfo() {
	return basicinfo;
}
public void setBasicinfo(String basicinfo) {
	this.basicinfo = basicinfo;
}
public String print()
{return basicinfo;
	}

	
}
