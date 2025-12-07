package com.vmc.netcracker;

import java.util.Objects;

public class Error {

	String code;
	Integer priority;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Error(String code, Integer priority) {
		super();
		this.code = code;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Error [code=" + code + ", priority=" + priority + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, priority);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Error other = (Error) obj;
		return Objects.equals(code, other.code) && Objects.equals(priority, other.priority);
	}

}
