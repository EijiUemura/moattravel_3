package com.example.moattravel.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class HouseRegisterForm {
	@NotBlank(message = "民宿名を入力してください。")
	private String name;
	private MultipartFile imageFile;
	
	@NotBlank(message = "説明を入力してください。")
	private String description;
	
	@NotNull(message = "宿泊料金を入力してください。")
	@Min(value = 1, message = "宿泊料金は１円以上に設定してください。")
	private Integer price;
	
	@NotBlank(message = "郵便番号を入力してください。")
	private String postalCode;
	
	@NotBlank(message = "郵便番号を入力してください。")
	private String phoneNumber;
	
	

}
