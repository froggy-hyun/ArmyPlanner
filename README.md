# ArmyPlanner
군생활을 알차게, 플래너 사이트  
**장병들의 군생활을 다양한 정보를 활용하여 직접 알차게 계획하고 실행할 수 있도록 서비스 제공**

### 프로젝트 소개
2023년 국방 공공데이터 활용 경진 대회 참가 - 상병 최성현
> 공공데이터를 단순히 보여주는 것을 넘어 사용자가 가공, 저장 등 다양한 방식으로 직접 사용할 수 있어야 한다.

<div style="text-align: left;"> 
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;">  </h2>  
    <div style="font-weight: 700; font-size: 15px; text-align: left; color: #282d33;">  </div> 
</div>
<div style="text-align: left;">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 🛠️ Tech Stacks </h2> <br> 
    <div style="margin: ; text-align: left;" "text-align: left;"> <img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white">
        <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white">
        <img src="https://img.shields.io/badge/Javascript-F7DF1E?style=for-the-badge&logo=Javascript&logoColor=white">
        <img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white">
        <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white">
        <br/><img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
        <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white">
        <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">
        <img src="https://img.shields.io/badge/Amazon AWS-232F3E?style=for-the-badge&logo=Amazon AWS&logoColor=white">
    </div>
</div>    

### [기능]
0. 회원 기능
1. Calendar기능(FullCalendar, 기간별로 볼 수 있음) 구성 (휴가, 식단, 소비, 장소, 텍스트)
   - 일정 추가/삭제
   - 일정 상세 정보 보기
2. 군혜택 맵 + 관심 장소 추가 기능
    - 장소 검색
    - 군인 전용 장소 보기 (군 복지 휴양 시설, 군 병원, TMO)
    - 군인 우대 업소 보기
3. 기타 군혜택 페이지
    - 국방부 MOU 혜택 정보
4. 회원 전용 홈(전국 중기예보전망, 전날 식단 영양소 분석, 일별 소비 기록 분석 및 예상, 예정된 방문 장소) 

### [사용 API]

- 공공데이터 API
1. <국가중점데이터> 식품의약품안전처_식품 영양성분 정보 https://www.data.go.kr/data/15057436/openapi.do  
   <국방분야데이터> 국방부 PX 인기상품 정보 : PX 인기상품 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9491    
2. <국방분야데이터> 전군 복지 휴양시설 위치정보 목록 : 군 복지 휴양시설 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9441    
   <국방분야데이터> 군병원 정보 : 군병원 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9436    
   <국방분야데이터> TMO(여행장병 안내소) 정보 : TMO(여행장병 안내소) 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9595  
   경기도 포천시_군장병할인업소 현황 데이터 https://www.data.go.kr/data/15106202/fileData.do    
   충청남도 논산시_할인업소현황 데이터 https://www.data.go.kr/data/3073444/fileData.do    
   경상북도 영천시_군장병 할인업소현황 https://www.data.go.kr/data/15044647/fileData.do    
   경상남도 창원시_입영장병 가족할인업소현황 https://www.data.go.kr/data/15055435/fileData.do  
3. <국방분야데이터> 병사 할인 혜택 정보 : 병사 할인 혜택 정보 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9493     
4. <국가중점데이터> 기상청_중기예보 조회서비스 https://www.data.go.kr/data/15059468/openapi.do  
   
- 카카오 API     
1. 카카오 지도 API  

### [제작방향]
1. 기본 회원기능 구현(회원가입, 로그인, 세션...)
2. FullCalendar이용, 기본 텍스트 CRUD구현(OpenAPI사용), DB 연동
3. 기능 추가 - 식단, 소비기록, 지도 검색 + 장소 기록 추가
4. 회원 전용 홈 구현
5. 기타 군혜택 페이지 구현
6. 회원 기능 보안
7. 보안 강화
8. 어드민, 매니저 기능 구현

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
