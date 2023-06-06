# ArmyPlanner
2023년 국방 공공데이터 활용 경진 대회

## <군생활을 알차게, 플래너 사이트>

### [기능]
0. 회원 기능
1. Calendar기능(FullCalendar, 기간별로 볼 수 있음) 구성 - 계획 CRUD
2. 식단(칼로리, 영양소 등...)
3. 소비기록
4. 장소 추가

### → [OpenAPI]
1. 장병 국가기술자격 취득 정보 : 장병 국가기술자격 취득 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9599  
   국방부_육군 장병 휴가 내역 조회 https://www.milipass.or.kr/html/sub/sub03.html  
2. 농림수산식품교육문화정보원_칼로리 정보 https://www.data.go.kr/data/15050912/fileData.do#/tab-layer-openapi
3. 국방부 PX 인기상품 정보 : PX 인기상품 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9491  
4. 병사 할인 혜택 정보 : 병사 할인 혜택 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9493  
   전군 복지 휴양시설 위치정보 목록 : 군 복지 휴양시설 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9441  
   군병원 정보 : 군병원 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9436  
   TMO(여행장병 안내소) 정보 : TMO(여행장병 안내소) 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9595  


### [제작방향]
1. 회원기능 구현(회원가입, 로그인, 세션...)
2. FullCalendar이용, CRUD구현(OpenAPI사용), DB 연동

### Commit convention (커밋 컨벤션)
feat : 새로운 기능과 관련된 것  
fix : 오류와 같은 것을 수정  
hotfix : 급하게 치명적인 버그 수정  
design : css 등 사용자 UI 디자인 변경  
test : test를 추가하거나 수정  
docs : 문서와 관련하여 수정한 부분이 있을 때 사용한다.  
style : 코드의 변화와 관련없는 포맷이나 세미콜론 수정  
refactor : 코드의 리팩토링  
build : 빌드 관련 파일 수정에 대한 커밋  
chore : 패키지 매니저 설정 등 여러가지 (production code와 무관)  
rename : 파일 혹은 폴더명 수정 또는 옮김  
remove : 파일을 삭제  
