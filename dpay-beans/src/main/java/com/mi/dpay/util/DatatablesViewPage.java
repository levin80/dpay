package com.mi.dpay.util;

import java.util.List;

/**
 * json分页
 * 
 * @author levin
 *
 * @param <T>
 */
public class DatatablesViewPage<T> {
	private int draw;  // Client request times
	private List<T> data; // aaData 与datatales 加载的“dataSrc"对应
	private int recordsTotal;// Total records number without conditions
	private int recordsFiltered;// Total records number with conditions

	public DatatablesViewPage() {
		super();
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}
	

}
