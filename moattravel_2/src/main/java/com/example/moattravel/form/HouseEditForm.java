package com.example.moattravel.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//全フィールドに値をセットするための引数つきコンストラクタを自動生成
//編集するために今回はつけた
@AllArgsConstructor

public class HouseEditForm {
	//土のデータを更新するかの情報がいるため
	@NotNull
	private Integer id;
	
	@NotBlank(message = "民宿名を入力してください。")
	private String name;
	
	private MultipartFile imageFile;
	
	@NotBlank(message = "説明を入力してください。")
	private String description;
	
	@NotNull(message = "宿泊料金を入力してください。")
	@Min(value = 1, message = "宿泊料金は１円以上に設定してください。")
	private Integer price;
	
	@NotNull(message = "定員を入力して下さい。")
	@Min(value = 1,message = "定員は１人以上に設定してください。")
	private Integer capacity;
	
	@NotBlank(message = "郵便番号を入力してください。")
	private String postalCode;
	
	@NotBlank(message = "住所を入力して下さい。")
	private String address;
	
	@NotBlank(message = "電話番号を入力してください。")
	private String phoneNumber;
	

}
