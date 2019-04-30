package id.co.maminfaruq.donasiapp.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Data implements Parcelable {

	@SerializedName("password")
	private String password;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("nama_user")
	private String namaUser;

	@SerializedName("jenkel")
	private String jenkel;

	@SerializedName("no_telp")
	private String noTelp;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setNamaUser(String namaUser){
		this.namaUser = namaUser;
	}

	public String getNamaUser(){
		return namaUser;
	}

	public void setJenkel(String jenkel){
		this.jenkel = jenkel;
	}

	public String getJenkel(){
		return jenkel;
	}

	public void setNoTelp(String noTelp){
		this.noTelp = noTelp;
	}

	public String getNoTelp(){
		return noTelp;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.password);
		dest.writeString(this.idUser);
		dest.writeString(this.namaUser);
		dest.writeString(this.jenkel);
		dest.writeString(this.noTelp);
		dest.writeString(this.email);
		dest.writeString(this.username);
	}

	public Data() {
	}

	protected Data(Parcel in) {
		this.password = in.readString();
		this.idUser = in.readString();
		this.namaUser = in.readString();
		this.jenkel = in.readString();
		this.noTelp = in.readString();
		this.email = in.readString();
		this.username = in.readString();
	}

	public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
		@Override
		public Data createFromParcel(Parcel source) {
			return new Data(source);
		}

		@Override
		public Data[] newArray(int size) {
			return new Data[size];
		}
	};
}