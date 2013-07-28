package com.weixin.app.web.tags;

import javax.servlet.jsp.PageContext;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.tags.HtmlEscapingAwareTag;
import org.springframework.web.util.ExpressionEvaluationUtils;

@SuppressWarnings("serial")
public class BindFieldErrorTag extends HtmlEscapingAwareTag {

	public static final String ERRORS_VARIABLE_NAME = "errors";
	
	private String name;
	
	private Errors errors;
	
	private String field;
	
	
	@Override
	protected int doStartTagInternal() throws Exception {
		String resolvedName = ExpressionEvaluationUtils.evaluateString("name", this.name, pageContext);
		String resolvedField = ExpressionEvaluationUtils.evaluateString("field", this.field, pageContext);
		this.errors = getRequestContext().getErrors(resolvedName, isHtmlEscape());
		if( this.errors != null && this.errors.hasErrors()){
			FieldError fieldError = errors.getFieldError(resolvedField);
			if( fieldError != null){
				return EVAL_BODY_INCLUDE;
			}else return SKIP_BODY;
			
		}else return SKIP_BODY;
	}

	@Override
	public int doEndTag() {
		this.pageContext.removeAttribute(ERRORS_VARIABLE_NAME, PageContext.REQUEST_SCOPE);
		return EVAL_PAGE;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}
	
	@Override
	public void doFinally() {
		super.doFinally();
		this.errors = null;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	
}
