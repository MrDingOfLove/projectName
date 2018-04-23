<%--
  Created by IntelliJ IDEA.
  User: ding
  Date: 2018/4/23
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON测试哦</title>
    <meta charset="UTF-8">
</head>
<body>
    <button onclick="requestJson()">请求json 输出json</button>
    <button onclick="requestKeyValue()">请求key:value 输出json</button>
<script src="./js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    // 请求json 输出json
    function requestJson() {
        console.log('请求json 输出json');
        $.ajax({
            url:'./requestJson',
            type:'post',
            contentType:'application/json;charset=utf-8',
            data:'{"name":"手机","price":2000}',
            success:function(data){
                console.log(data);
            }
        });
    }
    // 请求key:value 输出json
    function requestKeyValue() {
        console.log('请求key:value 输出json');
        $.ajax({
            url:'./requestKeyValue',
            type:'post',
            data:'name=iphone&price=1000',
            success:function(data){
                console.log(data);
            }
        });
    }
</script>
</body>
</html>
