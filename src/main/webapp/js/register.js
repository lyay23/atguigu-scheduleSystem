function checkUsername(){
    var usernameReg = /^[a-zA-Z0-9]{5,10}$/;
    var usernameInput = document.getElementById("usernameInput");
    var username = usernameInput.value;
    var usernameMsg = document.getElementById("usernameMsg");

    if (!usernameReg.test(username)) {
        usernameMsg.innerText = "格式必须是5-10位数字或字母";
        return false;
    }
    //格式正确通过之后，继续校验用户名称是否被占用
    var xmltype = new XMLHttpRequest();
    // 设置xmlHttpRequest的回调函数
    xmltype.onreadystatechange = function() {
        if (xmltype.readyState == 4 && xmltype.status == 200) {
            usernameMsg.innerText = xmltype.responseText;
        }
    }
   //设置请求方式和请求参数和请求资源路径
    xmltype.open("GET","/user/checkUsernameUsed?username="+username)
    //发送请求
    xmltype.send();
}

// 校验密码
function checkUserPwd(){
    var userPwdReg = /^[a-zA-Z0-9]{5,10}$/;
    var userPwdInput = document.getElementById("userPwdInput");
    var userPwd = userPwdInput.value;
    var userPwdMsg = document.getElementById("userPwdMsg");

    if (!userPwdReg.test(userPwd)) {
        userPwdMsg.innerText = "格式必须是5-10位数字或字母";
        return false;
    }
    userPwdMsg.innerText = "密码我知道啦";
    return true;
}

// 表单提交时验证账号密码
function checkForm(){
    var flag1 = checkUsername();
    var flag2 = checkUserPwd();

    return flag1 && flag2; // 只有两个条件都通过，表单才会提交
}