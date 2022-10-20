<%--
  Created by IntelliJ IDEA.
  User: kwah
  Date: 2022/10/20
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원가입</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .b-example-divider {
            height: 3rem;
            background-color: rgba(0, 0, 0, .1);
            border: solid rgba(0, 0, 0, .15);
            border-width: 1px 0;
            box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
        }

        .b-example-vr {
            flex-shrink: 0;
            width: 1.5rem;
            height: 100vh;
        }

        .bi {
            vertical-align: -.125em;
            fill: currentColor;
        }

        .nav-scroller {
            position: relative;
            z-index: 2;
            height: 2.75rem;
            overflow-y: hidden;
        }

        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="css/register.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container">
    <main>
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="img/logo.png" alt="" width="72" height="57">
            <h2>회원가입</h2>
        </div>

        <div class="row g-5">
            <div class="col-md-12 col-lg-12">
                <form class="needs-validation" novalidate action="registerOk" method="post">
                    <div class="row g-3">
                        <h4>기본 정보</h4>
                        <div class="col-sm-6">
                            <label for="user_id" class="form-label">아이디</label>
                            <div class="input-group has-validation">
                                <input type="text" class="form-control" id="user_id" placeholder="아이디를 적어주세요." required>
                                <div class="invalid-feedback">
                                    부적절한 아이디입니다.
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="user_name" class="form-label">이름</label>
                            <div class="input-group has-validation">
                                <input type="text" class="form-control" id="user_name" placeholder="이름을 적어주세요." required>
                                <div class="invalid-feedback">
                                    부적절한 이름입니다.
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="user_pwd" class="form-label">비밀번호</label>
                            <div class="input-group has-validation">
                                <input type="text" class="form-control" id="user_pwd" placeholder="이름을 적어주세요." required>
                                <div class="invalid-feedback">
                                    부적합한 비밀번호입니다.
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="user_pwdchk" class="form-label">비밀번호 확인</label>
                            <div class="input-group has-validation">
                                <input type="text" class="form-control" id="user_pwdchk" placeholder="이름을 적어주세요." required>
                                <div class="invalid-feedback">
                                    비밀번호가 동일하지 않습니다.
                                </div>
                            </div>
                        </div>


                        <div class="col-4">
                            <label for="user_tel1" class="form-label">전화번호</label>
                            <div class="input-group has-validation">
                                <!-- <input type="tel" class="form-control" id="user_nickname" required> -->
                                <select class="form-select" id="user_tel1" required>
                                    <option value="">선택</option>
                                    <option>010</option>
                                    <option>02</option>
                                    <option>031</option>
                                    <option>032</option>
                                    <option>033</option>
                                    <option>041</option>
                                    <option>042</option>
                                    <option>043</option>
                                    <option>044</option>
                                    <option>051</option>
                                    <option>052</option>
                                    <option>053</option>
                                    <option>054</option>
                                    <option>055</option>
                                    <option>061</option>
                                    <option>062</option>
                                    <option>063</option>
                                    <option>064</option>
                                </select>
                            </div>
                        </div>


                        <div class="col-4">
                            <label for="user_tel2" class="form-label"> &nbsp; </label>
                            <div class="input-group has-validation">
                                <input type="tel" class="form-control" maxlength="4" id="user_tel2" required>
                            </div>
                        </div>
                        <div class="col-4">
                            <label for="user_tel3" class="form-label"> &nbsp; </label>
                            <div class="input-group has-validation">
                                <input type="tel" class="form-control" maxlength="4" id="user_tel3" required>
                            </div>
                        </div>


                        <div class="col-12">
                            <label for="user_email" class="form-label">이메일</label>
                            <input type="email" class="form-control" id="user_email" placeholder="이메일을 적어주세요." required>
                            <div class="invalid-feedback">
                                이메일을 형식에 맞게 적어주세요.
                            </div>
                        </div>

                        <!-- <input type="text" id="postcode" placeholder="우편번호"> -->
                        <div class="col-md-6">
                            <label for="postcode" class="form-label">우편번호</label>
                            <input type="text" class="form-control" id="postcode" placeholder="우편번호" readonly required>
                            <div class="invalid-feedback">
                                우편번호는 필수입니다.
                            </div>
                        </div>
                        <!-- <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br> -->
                        <div class="col-md-6">
                            <label class="form-label"> &nbsp; </label>
                            <input type="button" class="btn btn-success form-control" onclick="execDaumPostcode()" value="우편번호 찾기"></input>
                        </div>


                        <div id="wrap"
                             style="display:none;border:1px solid;width:100%;height:400px;margin:5px 0;position:relative">
                            <img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
                        </div>

                        <!-- <input type="text" id="address" placeholder="주소"><br> -->
                        <div class="col-md-12">
                            <label for="address" class="form-label">주소</label>
                            <input type="text" class="form-control" id="address" placeholder="주소" readonly required>
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <!-- <input type="text" id="address" placeholder="주소"><br> -->
                        <div class="col-md-6">
                            <label for="extraAddress" class="form-label">참고항목</label>
                            <input type="text" class="form-control" id="extraAddress"  placeholder="참고항목" readonly>
                        </div>

                        <!-- <input type="text" id="address" placeholder="주소"><br> -->
                        <div class="col-md-6">
                            <label for="detailAddress" class="form-label">상세주소 <span class="text-muted">(Optional)</span></label>
                            <input type="text" class="form-control" id="detailAddress">
                        </div>


                    </div>



            <div class="col-12">
                <button class="w-100 btn btn-success btn-lg" type="submit">회원가입 진행</button>
            </div>

            </form>
        </div>
</div>
</main>
</div>
<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017–2022 Company Name</p>
    <ul class="list-inline">
        <li class="list-inline-item"><a href="#">Privacy</a></li>
        <li class="list-inline-item"><a href="#">Terms</a></li>
        <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
</footer>



<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }

    function execDaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

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

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;

                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
</script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/register.js"></script>
</body>
</html>
