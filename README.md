# 🧩무엇이든 물어보고 알아가는 놀이터, 무물

<div align="center">
  ![무물 타이틀 화면](https://github.com/serethia/serethia/assets/137035446/9e0a114a-e3c8-4f0e-990c-8669a0e2bc00)
</div>

<hr>

## 목차

- [📌 서비스 소개](#-서비스-소개)
- [⏱ 개발 기간](#-개발-기간)
- [👥 팀 소개](#-팀-소개)
- [🛠️ 기술 스택](#️-기술-스택)
- [🌐 포팅 매뉴얼](#-포팅-매뉴얼)
- [📄 설계 문서](#-설계-문서)



### 📌 서비스 소개

##### 익명으로 소통이 가능한 서비스
- ToMe 기능을 통한 소통 기능
- FromMe 기능을 통해 투표 혹은 글 작성 가능



### ⏱ 개발 기간

- 2024.04.08 ~ 2024.05.24 (7주)



### 👥 팀 소개

<table align="center">
  <tr>
    <tr align="center">
        <td style="min-width: 250px;">
            <a href="https://github.com/youkyoungJung">
              <b>정유경</b>
            </a> 
        </td>
        <td style="min-width: 250px;">
            <a href="https://github.com/Seongeuniii">
              <b>김성은</b>
            </a>        
        </td>
        <td style="min-width: 250px;">
            <a href="https://github.com/DeveloperYard">
              <b>김승우</b>
            </a>        
        </td>
    </tr>
    <tr align="center">
        <td style="min-width: 250px;">
              <img src="https://avatars.githubusercontent.com/u/76727102?v=4" width="100">
        </td>
        <td style="min-width: 250px;">
              <img src="https://avatars.githubusercontent.com/u/88070657?v=4" width="100">        
        </td>
        <td style="min-width: 250px;">
              <img src="https://avatars.githubusercontent.com/u/59395755?v=4" width="100">        
        </td>
    </tr>
    <tr align="center">
        <td>
        <b>Team Leader & Backend</b><br>댓글 생성 및 가져오기<br/>
        코드 품질 관리 (Testing)<br/>
        Jmeter 를 통한 TPS 측정
        <br/>
        </td>
        <td>
        <b>Frontend</b><br>로그인 / 회원가입<br>
        무물 투표<br/>
        </td>
        <td>
        <b>Infra</b><br>Nginx 설정<br/> 
        Jenkins CI&CD 파이프라인 작성<br/>
        EKS 쿠버네티스 환경 구성<br/>        
        </td>
    </tr>
  </tr>
  <tr>
    <tr align="center">
        <td style="min-width: 250px;">
            <a href="https://github.com/nahokyun">
              <b>나호균</b>
            </a>
        </td>
        <td style="min-width: 250px;">
            <a href="https://github.com/serethia">
              <b>엄세원</b>
            </a>
        </td>
        <td style="min-width: 250px;">
            <a href="https://github.com/barded1998">
              <b>차재환</b>
            </a>
        </td>
    </tr>
    <tr align="center">
        <td style="min-width: 250px;">
              <img src="https://avatars.githubusercontent.com/u/100259486?v=4" width="100">
        </td>
        <td style="min-width: 250px;">
              <img src="https://avatars.githubusercontent.com/u/137035446?v=4" width="100">
        </td>
        <td style="min-width: 250px;">
              <img src="https://avatars.githubusercontent.com/u/65287117?v=4" width="100">
        </td>
    </tr>
    <tr align="center">
        <td>
        <b>Backend</b><br>로그인 API 구현<br>
        Quiz게임 API 구현<br>
        </td>
        <td>
        <b>Backend</b><br>답글/투표/삭제/좋아요 API 구현<br>
        Post/Option/Vote/PostLike repository 통합테스트<br>
        답글/투표/삭제/좋아요 service 단위테스트<br>
        FromMe controller 통합테스트
        </td>
        <td>
        <b>Backend</b><br> 
        FromMe ToMe 피드 API 구현<br>
        QUIZ 구현<br>
        </td>
    </tr>
  </tr>

</table>



### 🛠️ 기술 스택

##### 📱 Frontend

<img src="https://img.shields.io/badge/typescript-3178C6?style=for-the-badge&logo=typescript&logoColor=black" width="auto" height="25">
<img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black" width="auto" height="25">
<img alt="Styled Components" src="https://img.shields.io/badge/styled--components-DB7093?style=for-the-badge&logo=styled-components&logoColor=white" width="auto" height="25">

##### 💻 Backend

<img alt="Java" src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" width="auto" height="25">
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" width="auto" height="25">
<img src="https://img.shields.io/badge/SPRING DATA JPA-6DB33F?style=for-the-badge&logoColor=white" width="auto" height="25"> 
<img src="https://img.shields.io/badge/SPRING SECURITY-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white" width="auto" height="25">
<img src="https://img.shields.io/badge/jwt-000000?style=for-the-badge&logo=jwt&logoColor=white" width="auto" height="25">
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white" width="auto" height="25">
<br> 
<img src="https://img.shields.io/badge/testcontainers-263238?style=for-the-badge&logo=testcontainers&logoColor=white" width="auto" height="25"> 
<img src="https://img.shields.io/badge/jmeter-D22128?style=for-the-badge&logo=apachejmeter&logoColor=white" width="auto" height="25"> 
<img src="https://img.shields.io/badge/junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white" width="auto" height="25"> 
<img src="https://img.shields.io/badge/BDDMockito-25A162?style=for-the-badge&logo=BDDMockito&logoColor=white" width="auto" height="25">

##### 🚀 Infrastructure

<img  src="https://img.shields.io/badge/Amazon AWS-232F3E?style=for-the-badge&logo=amazon aws&logoColor=white" width="auto" height="25" />
<img  src="https://img.shields.io/badge/Amazon S3-569A31?style=for-the-badge&logo=amazon s3&logoColor=white" width="auto" height="25" />
<img  src="https://img.shields.io/badge/NGINX-009639?style=for-the-badge&logo=nginx&logoColor=white" width="auto" height="25" />
<img  src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" width="auto" height="25" />
<img  src="https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white" width="auto" height="25" />
<img  src="https://img.shields.io/badge/Ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white" width="auto" height="25" />
<img src="https://img.shields.io/badge/EKS-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white" width="auto" height="25" />
<img src="https://img.shields.io/badge/kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white" width="auto" height="25" />

##### ⚙️ Management Tools

<img src="https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=jira&amp;logoColor=white" width="auto" height="25" />
<img src="https://img.shields.io/badge/GitLab-FC6D26?style=for-the-badge&logo=gitlab&logoColor=white" width="auto" height="25" />
<img src="https://img.shields.io/badge/mattermost-0072C6?style=for-the-badge&logo=mattermost&logoColor=white" width="auto" height="25" />
<img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white" width="auto" height="25" />
<img src="https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white" width="auto" height="25" />

##### 🖥️ IDE

<img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=for-the-badge&logo=visual studio code&logoColor=white" width="auto" height="25"/>
<img src="https://img.shields.io/badge/IntelliJ-000000?style=for-the-badge&logo=intellij&logoColor=white"  width="auto" height="25"/>
<img src="https://img.shields.io/badge/Vim-019733?style=for-the-badge&logo=vim&logoColor=white" width="auto" height="25" />



### 🌐 포팅 매뉴얼

[포팅 매뉴얼 보러가기](https://www.notion.so/barded/84aea8f22f314f09853262aa45bf606b)



### 📄 설계 문서

#### 1. ERD

<div width="1000px">
  ![erd](https://github.com/serethia/serethia/assets/137035446/dd3e09eb-1799-497f-8b7f-39db19786219)
</div>

#### 2. 아키텍처

<div width="1000px">
  ![아키텍처](https://github.com/serethia/serethia/assets/137035446/c8c3730e-3ff9-43b1-a7f8-a3933c0669cd)
</div>

#### [3. 요구 사항 명세서](https://www.notion.so/barded/ff168759aa89438b9585d8243a66baac)

#### [4. API 명세서](https://www.notion.so/barded/e8e7cdbc8cdf434c9123e795053b38b4?v=524113749c2842c6bbb55c0318d6f461)
