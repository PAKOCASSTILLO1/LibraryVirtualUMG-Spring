package gt.edu.umg.demo.controller;

import java.util.List;

public class ApiResponse {
	private String status;
	private Object message;
	private List<?> data;
	private String singleResponse;



	public ApiResponse(String status, Object message, List<?> data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public String getSingleResponse() {
		return singleResponse;
	}

	public void setSingleResponse(String singleResponse) {
		this.singleResponse = singleResponse;
	}

}