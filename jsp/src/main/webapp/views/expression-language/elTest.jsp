<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:useBean id="memberVO" class="member.MemberVO" />
<jsp:setProperty property="name" name="memberVO" />
<jsp:useBean id="list" class="java.util.ArrayList" />

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>표현 언어</title>
</head>

<body>
	<h2>자료형</h2>
	<div>
		\${100}: ${100}<br>
		\${"안녕하세요"}: ${"안녕하세요"}<br>
		\${10 + 1}: ${10 + 1}<br>
		\${"10" + 1}: ${"10" + 1 }<br>
		\${null + 10 }: ${null + 10 }<br> 
		<%-- 		\${"안녕" + 11 }: ${"안녕" + 11 }<br>  --%>
		<%-- 		\${"hello" + "world"}: ${"hello" + "world"}<br>  --%>
	</div>
	
	<h2>산술 연산자</h2>
	<div>
		\${10 + 10}: ${10 + 10}<br>
		\${20 - 10}: ${20 - 10}<br>
		\${10 * 10}: ${10 * 10}<br>
		\${100 / 9}: ${100 / 9}<br>
		\${100 div 9}: ${100 div 9}<br>
		\${100 % 9}: ${100 % 9}<br>
		\${100 mod 9}: ${100 mod 9}<br>
	</div>
	
	<h2>비교 연산자</h2>
	<div>
		\${10 == 10}: ${10 == 10}<br>
		\${10 eq 10}: ${10 eq 10}<br><br>
		
		\${"hello" == "hello"}: ${"hello" == "hello"}<br>
		\${"hello" eq "hello"}: ${"hello" eq "hello"}<br><br>
		
		\${20! = 10}: ${20 != 10}<br>
		\${20 ne 10}: ${20 ne 10}<br><br>
		
		\${"hello" != "apple"}: ${"hello" != "apple"}<br>
		\${"hello" ne "apple"}: ${"hello" ne "apple"}<br><br>
		
		\${10 < 10}: ${10 < 10}<br>
		\${10 lt 10}: ${10 lt 10}<br><br>
		
		\${100 > 10}: ${100 > 10}<br>
		\${100 gt 10}: ${100 gt 10}<br><br>
		
		\${100 <= 10}: ${100 <= 10}<br>
		\${100 le 10}: ${100 le 10}<br><br>
		
		\${100 >= 10}: ${100 >= 10}<br>
		\${100 ge 10}: ${100 ge 10}<br><br>
	</div>

	<h2>논리 연산자</h2>
	<div>
		\${(10 == 10) && (20 == 20)}: ${(10 == 10) && (20 == 20)}<br>
		\${(10 == 10) and (20 == 20)}: ${(10 == 10) and (20 == 20)}<br><br>
		
		\${(10 == 10) || (20 != 30)}: ${(10 == 10) || (20 == 30)}<br>
		\${(10 == 10) or (20 != 30)}: ${(10 == 10) or (20 == 30)}<br><br>
		
		\${!(20 == 10)}: ${!(20 == 10)}<br>
		\${not (20 == 10)}: ${not (20 == 10)}<br><br>
		
		\${!(20 != 10)}: ${!(20 != 10)}<br>
		\${not(20 != 10)}: ${not (20 != 10)}<br><br>
	</div>
  
	<h2>empty 연산자</h2>
	<div>
		\${empty memberVO}: ${empty memberVO}<br>
		\${not empty memberVO}: ${not empty memberVO}<br><br>
		
		\${empty list}: ${empty list}<br>
		\${not empty list}: ${not empty list}<br><br>
		
		\${empty "hello"}: ${empty "hello"}<br>
		\${empty null}: ${empty null}<br>
		\${empty ""}: ${empty ""}<br>
	</div>
	
</body>

</html>