package id.co.maminfaruq.donasiapp.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("result")
	private int result;

	@SerializedName("data")
	private Data data;

	@SerializedName("message")
	private String message;

	public void setResult(int result){
		this.result = result;
	}

	public int getResult(){
		return result;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}


}