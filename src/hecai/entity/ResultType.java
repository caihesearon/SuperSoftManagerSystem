package hecai.entity;

public class ResultType {

	private int status;
	private Object data;
	
	
	public static ResultType ok() {
		return new ResultType(200);
	}
	public static ResultType fail() {
		return new ResultType(500);
	}
	
	public static ResultType build(int status, Object data) {
		return new ResultType(status, data);
	}
	
	public ResultType() {}
	
	public ResultType(int status, Object data) {
		this.status = status;
		this.data = data;
	}

	public ResultType(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
}
