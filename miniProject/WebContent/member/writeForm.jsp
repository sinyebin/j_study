<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js">
</script>
</head>
<body>
<form action = "/miniProject/index.jsp" id="form1" name="form1" method="get">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td width="70"><label for="name">이름</label> </td>
				<td>
					<input type="text" name="name" id="name" placeholder="이름 입력"  />
					<div id="nameDiv"></div>
				</td>				
			</tr>
			<tr>
				<td width="70"><label for="id">ID </label> </td>
				<td>
					<input type="text" name="id" id="id"  placeholder="아이디 입력"/>
					<input type="button" value="중복체크" />
					<div id="idDiv"></div>
				</td>				
			</tr>
			<tr>
				<td width="70"><label for="pw">비밀번호 </label> </td>
				<td>
					<input type="password" name="pw" id="pw"  placeholder="비밀번호 입력"/>
					<div id="pwDiv"></div>
				</td>				
			</tr>
			<tr>
				<td width="70"><label for="rePw">재확인 </label> </td>
				<td>
					<input type="password" name="rePw" id="rePw"  placeholder="비밀번호 재입력"/>
					<div id="rePwDiv"></div>
				</td>				
			</tr>
			<tr>
				<td width="70"><label for="gender">성별</label> </td>
				<td>
					<input type="radio" name="gender" id="gender_m" value="0" checked />
					<label for="gender_m">남자</label>
					<input type="radio" name="gender" id="gender_f" value="1" />
					<label for="gender_f">여자</label>
				</td>
			</tr>
			<tr>
				<td width="70"><label for="email">이메일</label> </td>
				<td>
					<input type="text" name="email1" id="email1"/> @ <input type="text" name="email2" id="email2" placeholder="직접 입력"/>
				</td>
			</tr>
			<tr>
				<td width="70"><label for="phone">핸드폰</label> </td>
				<td>
					<select name="phone1" id="phone1" style="width: 80px">
						<option value="010" selected>010</option>
						<option value="011">011</option>
						<option value="019">019</option>					
					</select>
					<input type="text" style="width:80px" name="phone2" id="phone2"/>
					<input type="text" style="width:80px" name="phone3" id="phone3"/>
				</td>
			</tr>
			<tr>
				<td width="70"><label for="address">주소</label> </td>
				<td>
					<input type="text" readonly name="add1" id="add1"/> <input type="button" value="우편번호검색" onclick="search()"/> <br />
					<input type="text" readonly name="add2" id="add2" placeholder="주소" style="width:350px"/><br />
					<input type="text" placeholder="상세주소" style="width:350px" name="add3" id="add3"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
					<input type="button" value="회원가입" onclick="input()"/>
					<input type="reset" value="다시작성" />
				</td>
			</tr>
		</table>		
	</form>
	<script type="text/javascript">
		function input(){
			if(document.getElementById("name").value==""){
				document.getElementById("nameDiv").innerText="이름을 입력하세요";
				document.form1.name.focus();
				return;
			}else if(document.getElementById("id").value==""){
				document.getElementById("idDiv").innerText="아이디를 입력하세요";
				document.form1.id.focus();
				return;
			}else if(document.getElementById("pw").value==""){
				document.getElementById("pwDiv").innerText="비밀번호를 입력하세요";
				document.form1.pw.focus();
				return;
			}else if(document.getElementById("rePw").value==""){
				document.getElementById("rePwDiv").innerText="재확인을 입력하세요";
				document.form1.rePw.focus();
				return;
			}else if(document.getElementById("rePw").value!=document.getElementById("pw").value){
				document.getElementById("rePwDiv").innerText="비밀번호를 확인하세요";
				document.form1.rePw.focus();
				return;
			}else {
				document.form1.submit();
			}
		}
		
		function search(){
			 new daum.Postcode({
		            oncomplete: function(data) {
		                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

		                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var addr = ''; // 주소 변수
		                var extraAddr = ''; // 참고항목 변수

		                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
		                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
		                    addr = data.roadAddress;
		                } else { // 사용자가 지번 주소를 선택했을 경우(J)
		                    addr = data.jibunAddress;
		                }
		                // 우편번호와 주소 정보를 해당 필드에 넣는다.
		                document.getElementById('add1').value = data.zonecode;
		                document.getElementById("add2").value = addr;
		                // 커서를 상세주소 필드로 이동한다.
		                document.getElementById("add3").focus();
		            }
		        }).open();
			
		}
	</script>
</body>
</html>