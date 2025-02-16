function checkUsername(){
    var usernameReg = /^[a-zA-Z0-9]{5,10}$/;
    var usernameInput = document.getElementById("usernameInput");
    var username = usernameInput.value;
    var usernameMsg = document.getElementById("usernameMsg");

    if (!usernameReg.test(username)) {
        usernameMsg.innerText = "格式必须是5-10位数字或字母";
        return false;
    }

    /*
    第四期第二集-解决已知问题
    1.响应乱码问题
    2.响应信息不规范，处理方式不规范
       后端响应回来的信息应当有一个统一格式，前后端共同遵守
       响应一个JSON串
       {“code”：“100/200/300/400”,业务状态码 本次请求的业务是否成功？如果失败了是什么原因导致的，不是响应报文中的响应码【自义定】
       “massage”："业务状态码的补充说明",
       "data":{} 本次响应的数据 成功/不成功 list<Schedule>
       ...}
    3.校验不通过，无法阻止表单提交的问题 未来使用VUE axios结合promise处理
     */


    //格式正确通过之后，继续校验用户名称是否被占用
    var xmltype = new XMLHttpRequest();
    // 设置xmlHttpRequest的回调函数
    xmltype.onreadystatechange = function() {
        if (xmltype.readyState == 4 && xmltype.status == 200) {
         var result=   JSON.parse(xmltype.responseText)
            if(result.code!=200){
                usernameMsg.innerText="用户名被占用"
            }
        }
    }
   //设置请求方式和请求参数和请求资源路径
    xmltype.open("GET","/user/checkUsernameUsed?username="+username)
    //发送请求
    xmltype.send();

    usernameMsg.innerText="可用"
    return true

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