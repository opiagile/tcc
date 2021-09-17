package br.com.bitwiselab.jano.taglibs;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectTag extends SimpleTagSupport {
	private String id;
	private String name;
	private String width;
	private List<?> options;
	private String optionValue;
	private String optionLabel;
	private Object selected;
	private String primeira;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public List<?> getOptions() {
		return options;
	}

	public void setOptions(List<?> options) {
		this.options = options;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public String getOptionLabel() {
		return optionLabel;
	}

	public void setOptionLabel(String optionLabel) {
		this.optionLabel = optionLabel;
	}

	public Object getSelected() {
		return selected;
	}

	public void setSelected(Object selected) {
		this.selected = selected;
	}

	public String getPrimeira() {
		return primeira;
	}

	public void setPrimeira(String primeira) {
		this.primeira = primeira;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		StringBuilder sb = new StringBuilder();
		sb.append("<select class=\"input-sm\"");
		sb.append("id=\"");
		sb.append(id);
		sb.append("\"");
		sb.append("name=\"");
		sb.append(name);
		sb.append("\"");
		sb.append("style=\"width: ");
		sb.append(width);
		sb.append("\" >");
		sb.append("\n");
		if (primeira != null) {
			sb.append("<option value=\"\">");
			sb.append(primeira);
			sb.append("</option>\n");
		}
		for (Object option : options) {
			Object value = PropertyResolver.getValue(option, optionValue);
			Object label = PropertyResolver.getValue(option, optionLabel);

			sb.append("<option value=\"");
			sb.append(value);
			sb.append("\"");
			if (selected != null
					&& (selected.equals(option) || selected.equals(value))) {
				sb.append(" selected=\"selected\"");
			}
			sb.append(">");
			sb.append(label);
			sb.append("</option>\n");
		}
		sb.append("</select>");
		out.println(sb.toString());
	}
}
