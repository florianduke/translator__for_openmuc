package de.isc.konstanz.aml;

import java.util.ArrayList;

public class Channel {
	public ArrayList description = new ArrayList();
	public ArrayList name = new ArrayList();
	public ArrayList adress = new ArrayList();
	public ArrayList valueType = new ArrayList();
	public ArrayList valueUnit = new ArrayList();
	public ArrayList key = new ArrayList();
	public ArrayList keyColumn = new ArrayList();
	public ArrayList dataColumn = new ArrayList();
	public ArrayList subFolder = new ArrayList();
	public ArrayList folder = new ArrayList();
	
	public ArrayList getDescription() {
		return description;
	}
	public void setDescription(ArrayList description) {
		this.description = description;
	}
	public ArrayList getName() {
		return name;
	}
	public void setName(ArrayList name) {
		this.name = name;
	}
	public ArrayList getAdress() {
		return adress;
	}
	public void setAdress(ArrayList adress) {
		this.adress = adress;
	}
	public ArrayList getValueType() {
		return valueType;
	}
	public void setValueType(ArrayList valueType) {
		this.valueType = valueType;
	}
	public ArrayList getValueUnit() {
		return valueUnit;
	}
	public void setValueUnit(ArrayList valueUnit) {
		this.valueUnit = valueUnit;
	}
	public ArrayList getKey() {
		return key;
	}
	public void setKey(ArrayList key) {
		this.key = key;
	}
	public ArrayList getKeyColumn() {
		return keyColumn;
	}
	public void setKeyColumn(ArrayList keyColumn) {
		this.keyColumn = keyColumn;
	}
	public ArrayList getDataColumn() {
		return dataColumn;
	}
	public void setDataColumn(ArrayList dataColumn) {
		this.dataColumn = dataColumn;
	}
	public void setSubfolder(ArrayList subFolder) {
		this.subFolder = subFolder;
	}
	public ArrayList getSubfolder() {
		return subFolder;
	}
	public void setFolder(ArrayList folder) {
		this.folder = folder;
	}
	public ArrayList getFolder() {
		return folder;
	}
}
