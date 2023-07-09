# ArmyPlanner
![armyPlannerLogo_black](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/05802ad8-9e30-4ed4-bbd6-7a79777e3281)


**11가지의 다양한 공공데이터 API를 통해 실시간으로 정보 제공 및 장병들이 직접 선택, 가공, 저장, 활용할 수 있도록 다양한 기능과 서비스를 제공하여 군생활을 알차게 계획하고 실행할 수 있는 통합 플랫폼 PC/모바일 웹사이트**   
<br>

## 👉  목차  
1. [📰 프로젝트 개요](#-프로젝트-개요)  
   - [🙋‍♀️ 참가자](#-참가자)
   - [📜 사용 공공데이터 API](#-사용-공공데이터-api)
2. [🛠 Tech Stacks](#-tech-stacks)
3. [💡 개발 배경](#-개발-배경)   
4. [🔔 기능](#-기능)
5. [📝 제작방향](#-제작방향)
   - [🚩 개발 절차](#-개발-절차)
   - [:octocat: Commit convention (커밋 컨벤션)](#octocat-commit-convention-커밋-컨벤션)
6. [⭐ skills](#-skills)
7. [📈 Release Note](#-release-note)   
8. [🚀 배포](#-배포)
9. [🙏 마무리하며..](#-마무리하며)

<br>


## 📰 프로젝트 개요

23년 국방공공데이터 활용 경진 대회 참가
### 🙋 참가자
상병 최성현
> "공공데이터를 단순히 보여주는 것을 넘어 사용자가 가공, 저장 등 다양한 방식으로 직접 사용할 수 있어야 한다! 공공데이터를 통해 새로운 가치를 만듭니다."  
    
### 📜 사용 공공데이터 API

1. <국가중점데이터> 식품의약품안전처_식품 영양성분 정보    
  https://www.data.go.kr/data/15057436/openapi.do 
2. <국가중점데이터> 기상청_중기예보 조회서비스    
  https://www.data.go.kr/data/15059468/openapi.do  
3. <국방분야데이터> 국방부 PX 인기상품 정보 : PX 인기상품 정보  
 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9491      
4. <국방분야데이터> 전군 복지 휴양시설 위치정보 목록 : 군 복지 휴양시설 정보  
 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9441     
5. <국방분야데이터> 군병원 정보 : 군병원 정보  
 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9436    
6. <국방분야데이터> TMO(여행장병 안내소) 정보 : TMO(여행장병 안내소) 정보  
 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9595
7. <국방분야데이터> 병사 할인 혜택 정보 : 병사 할인 혜택 정보  
 https://opendata.mnd.go.kr/openinf/sheetview2.jsp?infId=OA-9493       
8. (자치행정기관데이터) 경기도 포천시_군장병할인업소 현황 데이터  
 https://www.data.go.kr/data/15106202/fileData.do    
9. (자치행정기관데이터) 충청남도 논산시_할인업소현황 데이터  
 https://www.data.go.kr/data/3073444/fileData.do    
10. (자치행정기관데이터) 경상북도 영천시_군장병 할인업소현황  
 https://www.data.go.kr/data/15044647/fileData.do    
11. (자치행정기관데이터) 경상남도 창원시_입영장병 가족할인업소현황  
 https://www.data.go.kr/data/15055435/fileData.do  

 
  
<br>  

## 🛠 Tech Stacks
<div style="text-align: left;">
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
<br>    

## 💡 개발 배경
- 군 생활이 얼마 남지 않은 요즘 이때까지의 군 생활을 되돌아보면 물 흐르듯 지내는 것보다는 계획적으로 할 일을 정하고, 목표를 세우고, 남는 시간을 활용하여 자기 계발을 시작하고 나서가 긍정적인 영향과 성취감을 가져다주고 시간도 금세 지나가는 것 같았음.   
하지만 주변 동기나 후임들을 계획적인 군 생활을 시도했다가 쉽게 포기하는 것을 보고 어떻게 하면 군 생활 동안의 목표를 쉽게 계획하고 실천할 수 있을까 고민하다가 서비스 개발을 결심함.  
<br>

## 🔔 기능

0. 회원 기능

|회원가입|로그인|
|---|---|
|![회원가입](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/347763bf-66bc-458e-8b4e-e2de8deefef6)|![로그인](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/a3c42de9-1fd9-4ae8-96b5-9b0c965e766a)|

2. 나의 Planner 서비스
   - 월, 주, 일, 리스트 단위로 볼 수 있음.
  
   |기본 월단위 뷰|주단위 뷰|일단위 뷰|리스트 뷰|
   |---|---|---|---|
   |![플래너예시_기본](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/2c3d385f-08db-4410-bc47-38fc17e2a0fd)|![플래너예시_주간](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/46badf37-6fcc-46c7-94c4-1edfcb62fac1)|![플래너예시_일간](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/9f24908b-35f5-4ac9-8a80-b942c1e155ee)|![플래너예시_리스트](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/973948c4-8eff-441e-8bb9-3da8b3f95888)|
   
   - 휴가, 식단, 소비, 장소, 텍스트 등 다양한 종류의 일정(기록) 추가/삭제
  
   |일정 유형 선택|휴가 입력|식단 기록 입력|소비 기록 입력|장소 등록|텍스트 등록|
   |---|---|---|---|---|---|
   |![일정유형](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/fd06ad14-d27f-4df5-a79f-a5d11b568826)|![휴가일정입력](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/577b9ccf-5dc6-4429-bbfb-42abae678e4f)|![식단입력](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/d65cc20f-c18a-4169-a9f2-46e4039a39dd)|![소비입력](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/193de256-ad31-4d65-a5d6-e8cb2ded136a)|![장소입력](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/2af2623e-184f-4348-8d1c-fba78b186af3)|![텍스트입력](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/57a12866-487f-4ca0-9791-2f7b3d7c582a)|

   - 일정 상세 정보 보기
  
   |휴가 상세|식단 기록 상세|소비 기록 상세|장소 상세|텍스트 상세|
   |---|---|---|---|---|
   |![휴가일정정보예시](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/fe3eacfc-6c8c-4daa-9532-3972cf873847)|![식단정보예시](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/ae99641d-7c43-40b2-89ea-5c489e822927)|![소비정보예시](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/bd9921f3-352a-46d3-9655-c6d93ffef449)|![장소일정정보예시](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/a9d773fb-2ee1-483e-8123-4e21032970ed)|![텍스트일정정보예시](https://github.com/froggy-hyun/ArmyPlanner/assets/111727754/fab3612b-4c74-4c3a-b10e-1605bc23eea2)|
   
4. 군혜택MAP 서비스
    - 키워드로 장소 검색
    - 군인 전용 장소 보기 (군 복지 휴양 시설, 군 병원, TMO)
    - 군인 우대 업소 보기
    - 관심 장소 추가 기능
5. 기타 군혜택 페이지
    - 국방부 MOU 혜택 정보 페이지
6. 회원 전용 홈 서비스(전국 중기예보전망, 전날 식단 영양소 분석, 일/월별 소비 기록 분석), + AI를 이용한 예상치, 예정된 방문 장소 알림 기능 추가 예정



<br>

## 📝 제작방향  
23.06.01 ~ 23.07.09

### 🚩 개발 절차
0. 스프링 부트 프로젝트 생성, sqlite3 DB 사용
1. 기본 회원기능 구현(회원가입, 로그인, 세션...)
2. 나의 Planner 서비스 구현, 모달 창 구현, 기본 텍스트 CRUD구현, sqlite로 DB 변경
3. 나의 Planner 기능 추가 - 식단, 소비 기록, 장소 기록 (공공데이터 API AJAX를 통해 가져오기, 데이터 가공 및 표현 알고리즘 구현)
4. 군혜택 MAP 서비스 (공공데이터 API AJAX를 통해 가져오기, 데이터 가공 및 표현 알고리즘 구현)
5. 회원 전용 홈 구현
6. 기본 웹 디자인
7. 기타 군혜택 페이지 구현
8. 플래너 디자인 강화  
9. index 강화
10. 1차 배포-aws 배포, 도메인 등록
11. 모바일을 위한 최적화 (글씨 드래그 방지 등)
12. 사용법 명시 및 설명 추가
13. api 코드 삭제 후 커밋, 재발급 하여 새로운 코드로 서버 가동
14. 2차 최종 배포 

-------정식 서비스 ------  
15. 회원 기능 및 보안 강화   
16. 회원 전용 홈 서비스 강화(AI를 사용하여 다양한 데이터 추천)  
16. 어드민, 매니저 기능 구현  
17. 군 우대 업소 정보에 리뷰기능 구현, 게시판 기능을 통해 커뮤니티 활성화  
18. 친구기능과 공유 플래너 기능 구현  

###  :octocat: Commit convention (커밋 컨벤션)
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

## ⭐ skills

### 프론트엔드(front-end)
- Html5, css
- Javascript   
- Bootstrap 5.3.0
- Jquery 3.5.1
 
### 백엔드(back-end)
- Java 11  
- Springboot 2.7.12  
- MySql

### API
- 11가지의 공공데이터 API
- 카카오MAP API : 정적, 동적 지도 생성
- 구글캘린더 API : 공휴일 가져오기

<br> 

## 📈 Release Note

| version | log |
| --- | --- |
| beta_v1 | 1차 배포 - AWS EC2, RDS |
| beta_v2 | 2차 배포 - 로딩 시 로딩 바 구현, 디자인 변경, 각종 효과 추가, 모바일 최적화, 각종 버그 수정, API키 교체 |  

<br>

## 🚀 배포 
AWS (아마존 웹 서비스)
- EC2 : Ubuntu Server 22.04 LTS
- RDS : MySQL Community

<br>

## 🙏 마무리하며..

