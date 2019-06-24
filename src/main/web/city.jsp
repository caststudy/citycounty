<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/11
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="web/js/jquery.min.js"></script>
    <script>
        function getcity() {
            $.ajax({
                type: "post",
                url: "city/getcity",
                success: function (data) {
                    // alert(data.length)
                    $("#city").html("");
                    $("#city").append("<option>请选择...</option>");
                    $.each(data,function (i,item) {
                        $("#city").append("<option>"+item+"</option>")
                    });
                }
            });

        }

    </script>
</head>
<body>
 <select id="city"> </select>
 <select id="county"><option>请选择...</option> </select>
 <script>
     $(function () {
        $("#city").change(function () {
            var city=$(this).val();
            if(city=="请选择..."){
                $("#county").html("<option>请选择...</option>");
                return;
            }
            // alert(city);
            $.ajax({
                type: "post",
                url: "city/getcounty?city="+city,

                success: function (data) {
                    // alert(data);
                    data=data.split(";");
                    $("#county").html("");
                    $("#county").append("<option>请选择...</option>");
                    $.each(data,function (i,item) {
                        $("#county").append("<option>"+item+"</option>")
                    })
                }
            });
        })
     });
     getcity();
 </script>
</body>
</html>
