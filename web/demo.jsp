<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        //1.创建XHR对象
        function Xhr() {
            var xhr = null;
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xhr=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xhr=new ActiveXObject("Microsoft.XMLHTTP");
            }
            return xhr;
        }

        //ajax的核心操作
        function getText() {
            //1.创建XMLHttpRequest对象
            var xhr = Xhr();
            //2.与服务器建立连接并发送请求
            xhr.open("get","getText",true);
            xhr.send(null);
            //3.服务器端获取到数据然后在前台页面来接收数据
            xhr.onreadystatechange=function()
            {
                if (xhr.readyState==4 && xhr.status==200)
                {
                    //从后台获取到数据并在前端来显示
                    var txt = xhr.responseText;
                   // alert(txt);
                    //需要将从后台返回的json串转换为对象，最后才能获取到对象中的数据
                    var objects = eval("("+txt+")");
                    alert(objects.id);
                }
            }

        }

    </script>
</head>
<body>
<a href="###" onclick="getText()">ajax请求</a>

</body>
</html>
