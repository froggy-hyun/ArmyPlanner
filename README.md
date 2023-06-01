# ArmyPlanner
2023년 국방 공공데이터 활용 경진 대회

<군생활을 알차게, 플래너 사이트>

[기능]
1. 회원 기능
2. 플래너 : 할 일, 소비 기록, 식단 등
3. 군인 할인 혜택 정보 제공

[OpenAPI]
국방부 PX 인기상품 정보 : PX 인기상품 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9491
병사 할인 혜택 정보 : 병사 할인 혜택 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9493
전군 복지 휴양시설 위치정보 목록 : 군 복지 휴양시설 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9441
군병원 정보 : 군병원 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9436
TMO(여행장병 안내소) 정보 : TMO(여행장병 안내소) 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9595
장병 국가기술자격 취득 정보 : 장병 국가기술자격 취득 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9599
국방부_육군 장병 휴가 내역 조회 https://www.milipass.or.kr/html/sub/sub03.html
농림수산식품교육문화정보원_칼로리 정보 https://www.data.go.kr/data/15050912/fileData.do#/tab-layer-openapi

[제작방향]
1. 회원기능 구현(회원가입, 로그인, 세션...)
2. FullCalendar이용, CRUD구현(OpenAPI사용), DB 연동
