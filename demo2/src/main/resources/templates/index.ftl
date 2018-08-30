<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div class="container">
    <h2>${msg}</h2>
    <div>
        <form action="/file" method="post" enctype="multipart/form-data">
            <input type="file" value="上传文件" name="file">
            <input type="submit">
        </form>
    </div>
</div>
</body>
</html>