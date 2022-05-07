package com.atynine.fflogsprogress.entities;

import lombok.Data;

@Data
public class ReportWrapper {
	private Data data;

	public ReportData getReportData(){
		return this.data.reportData;
	}
	@lombok.Data
	protected class Data {
		public ReportData reportData;
	}
}

