package com.weixin.app.web.support;

import java.beans.PropertyEditorSupport;

import com.weixin.app.util.DateQueryIndex;

public class DateIndexEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		return super.getAsText();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		int c = 0;
		try {
			c = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			// print error
		}

		switch (c) {
		case 1:
			this.setValue(DateQueryIndex.Today);
			break;
		case 2:
			this.setValue(DateQueryIndex.LastTwoDay);
			break;
		case 3:
			this.setValue(DateQueryIndex.LastThreeDay);
			break;
		case 4:
			this.setValue(DateQueryIndex.LastOneWeek);
			break;
		case 5:
			this.setValue(DateQueryIndex.LastOneMonth);
			break;
		case 6:
			this.setValue(DateQueryIndex.Custom);
			break;
		default:
			this.setValue("");
			break;
		}
	}
}
