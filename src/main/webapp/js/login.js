// 这里是账号密码输入的时候的校验功能

function checkUsername(){
    // 正则表达式--5到10位a-z0-9的数字
    var usernameReg=/^[a-zA-Z0-9]{5,10}$/

    //获取用户在页面输入的信息
   var usernameInput= document.getElementById("usernameInput")
   var username=usernameInput.value
  
   //获得元素提示的框
   var usernameMsg=document.getElementById("usernameMsg")
   //格式错误
   if(!usernameReg.test(username)){ //如果输入不合法，将提示传给span标签
     usernameMsg.innerText="格式必须是5-10位数字或字母"
     return false
   }
   //格式正确返回ok，提示
   usernameMsg.innerText="太聪明啦"
   return true
   
}

// 校验密码
function checkUserPwd(){
    // 正则表达式--5到10位a-z0-9的数字
    var userPwdReg=/^[a-zA-Z0-9]{5,10}$/

    //获取用户在页面输入的信息
   var userPwdInput= document.getElementById("userPwdInput")
   var userPwd=userPwdInput.value
  
   //获得元素提示的框
   var userPwdMsg=document.getElementById("userPwdMsg")
   //格式错误
   if(!userPwdReg.test(userPwd)){ //如果输入不合法，将提示传给span标签
    userPwdMsg.innerText="格式必须是5-10位数字或字母"
     return false
   }
   //格式正确返回ok，提示
   userPwdMsg.innerText="密码我知道啦"
   return true
   
}

//表单提交时验证账号密码
function checkForm(){

    var flag1=checkUsername()
    var flag2=checkUserPwd()

    return flag1&&flag2
}