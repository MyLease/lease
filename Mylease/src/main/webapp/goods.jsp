<%--
  Created by IntelliJ IDEA.
  User: Join
  Date: 2017/11/10
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/GoodsController/selectGoods" method="post">
    <table>
        <tr>
            <td>商品名称</td>
            <td>
                <input type="text" name="goodsName">
            </td>
        </tr>
        <tr>
            <td>处理方式</td>
            <td>
                <select name="dealType">
                    <option value="-1" selected="selected">请选择</option>
                    <option value="1">租</option>
                    <option value="2">换</option>
                    <option value="3">买</option>
                    <option value="4">捐</option>
                    <option value="5">送</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>商品类别</td>
            <td>
                <input type="text" name="goodsType">
            </td>
        </tr>
        <tr>
            <td>最低价</td>
            <td>
                <input type="text" name="lowPrice">
            </td>
        </tr>
        <tr>
            <td>最高价</td>
            <td>
                <input type="text" name="highPrice">
            </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>

</form>

</body>
</html>
