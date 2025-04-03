package com.talk.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberSignUpDto {
	
	@NotEmpty(message="아이디는 필수입니다.")
	@Size(min=5, max=12, message="5자 이상 12자 이하로 입력하세요")
	@Pattern(regexp = "^[a-z0-9]*$", message="영어 소문자와 숫자만 입력하세요")
	private String memberId;
	
	@NotEmpty(message="비밀번호는 필수입니다.")
	@Size(min=6, max=16, message="6자 이상 16자 이하로 입력하세요")
	@Pattern(regexp="^[a-zA-Z0-9]*$", message="영어 대소문자와 숫자만 입력하세요")
	private String password;

	@NotBlank(message = "이름은 필수입니다")  // 자카르타.으로 시작하는것/ 유효성 검사후 나타남. 
	private String name;
	
	@NotEmpty(message = "이메일은 필수입니다")
	private String email;
	private String tel;
	
	
}

/*

 validation 데이터 유효성 검증
 
 @NotEmpty : null, 빈문자열 불가
 @NotBlank : null, 빈문자열, 공백 불가
 @Null : null 만 허용
 @NotNull : null 불가(빈문자열, 공백 허용)
 
 @Min(value= 4) : value 이상의 값만 허용
 
 	@Min(value=10, message="10 이상만 입력하세요.")
 	private int num;
 @Max(value= ) : value 이하의 값만 허용
 	@Max(value=5, message="5이하만 입력하세요")
 	private int num;
 	
 @Size(min = , max = ) : 길이를 제한 할때 사용
	@Size(min=10, max=20, message="10자이상 20자 이하 만 입력")
	private String title;
 @Positive : 양수만 허용
 @PositiveOrZero : 양수와 0만 허용
 @Negative : 음수만 허용
 @NegativeOrZero : 음수와 0만 허용
 
 @Email : 이메일 형식 검사, 빈 문자열은 패스
 
 @Pattern(regexp=)	: 정규식 검사	
 

 */





// null : empty(true), blank(true)
// ""	: empty(true), blank(true)
// "a"  : empty(false), blank(false)
// " "  : empty(false), blank(true)
// "v aw " : empty(false), blank(false)
